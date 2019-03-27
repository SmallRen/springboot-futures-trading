package com.futurestrading.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.futurestrading.entity.TOrder;
import com.futurestrading.entity.User;
import com.futurestrading.service.ITOrderService;
import com.futurestrading.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author sensor
 * @since 2019-03-24
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    ITOrderService service;
    @Autowired
    HttpSession httpSession;

    /**
     * 查询交易品种
     *
     * @return
     */
    @ResponseBody
    @GetMapping("/all")
    public IPage<TOrder> all(Integer userId, long current) {
        return service.selectByUserId(userId, current);
    }


    /**
     * 创建订单
     *
     * @return
     */
    @ResponseBody
    @PostMapping("/insert")
    public boolean insert(TOrder order) {
        QueryWrapper<TOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().orderByDesc(TOrder::getOrderId);
        List<TOrder> tOrder = service.list(queryWrapper);
        User user = (User) httpSession.getAttribute("userInfo");
        order.setcTime(DateUtils.fromDate(new Date()));
        order.setUserId(user.getId());
        order.setAccountNum(tOrder.get(0).getAccountNum()-order.getTradeNum());
        return service.save(order);
    }

}
