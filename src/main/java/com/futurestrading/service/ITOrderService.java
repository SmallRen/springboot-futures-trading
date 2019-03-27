package com.futurestrading.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.futurestrading.entity.TOrder;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sensor
 * @since 2019-03-27
 */
public interface ITOrderService extends IService<TOrder> {
    /**
     * 查询用户交易信息
     * @param userId
     * @return
     */
    IPage<TOrder> selectByUserId(Integer userId, long current);
}
