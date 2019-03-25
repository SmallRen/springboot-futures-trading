package com.futurestrading.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.futurestrading.entity.Order;
import com.futurestrading.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    IOrderService service;

    /**
     * 查询交易品种
     *
     * @return
     */
    @ResponseBody
    @GetMapping("/all")
    public IPage<Order> all(Integer userId, long current) {
        return service.selectByUserId(userId, current);
    }


    /**
     * 创建订单
     *
     * @return
     */
    @ResponseBody
    @GetMapping("/insert")
    public boolean insert(Order order) {
        return service.save(order);
    }

}
