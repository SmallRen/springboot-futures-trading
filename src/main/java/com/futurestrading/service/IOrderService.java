package com.futurestrading.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.futurestrading.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sensor
 * @since 2019-03-25
 */
public interface IOrderService extends IService<Order> {
    /**
     * 查询用户交易信息
     * @param userId
     * @return
     */
    IPage<Order> selectByUserId(Integer userId, long current);
}
