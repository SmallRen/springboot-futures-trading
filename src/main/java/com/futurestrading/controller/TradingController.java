package com.futurestrading.controller;


import com.futurestrading.entity.Trading;
import com.futurestrading.service.ITradingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sensor
 * @since 2019-03-24
 */
@RestController
@RequestMapping("/trading")
public class TradingController {
    @Autowired
    ITradingService service;

    /**
     * 查询所有的期货
     * @return List<Trading>
     */
    @ResponseBody
    @GetMapping("/all")
    public List<Trading> all() {
        return service.list();
    }

    /**
     * 条件查询
     * @param fdt001 交易所
     * @param trdvar 交易品种
     * @param agmtcd 合约代码
     * @return
     */
    @ResponseBody
    @GetMapping("/select")
    public List<List<String>> select(String fdt001,String trdvar,String agmtcd) {
        return service.select(fdt001,trdvar,agmtcd);
    }

    /**
     * 查询交易品种
     * @return
     */
    @ResponseBody
    @GetMapping("/trdvar")
    public List<String> trdvar() {
        return service.selectByTrdvar();
    }

    /**
     * 查询交易品种
     * @return
     */
    @ResponseBody
    @GetMapping("/agmtcd")
    public List<String> agmtcd() {
        return service.selectByAgmtcd();
    }

}
