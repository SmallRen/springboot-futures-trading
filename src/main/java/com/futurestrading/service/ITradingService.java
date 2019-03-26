package com.futurestrading.service;

import com.futurestrading.entity.Trading;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sensor
 * @since 2019-03-25
 */
public interface ITradingService extends IService<Trading> {
    /**
     * 查询交易品种
     * @return List<String>
     */
    List<String> selectByTrdvar();

    /**
     * 合约代码
     * @return
     */
    List<String> selectByAgmtcd();
    /**
     * 条件查询
     * @param fdt001 交易所
     * @param trdvar 交易品种
     * @param agmtcd 合约代码
     * @return
     */
    List<List<String>> select(String fdt001, String trdvar, String agmtcd);
}
