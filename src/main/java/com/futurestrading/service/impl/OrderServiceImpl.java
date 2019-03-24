package com.futurestrading.service.impl;

import com.futurestrading.entity.Order;
import com.futurestrading.mapper.OrderMapper;
import com.futurestrading.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sensor
 * @since 2019-03-24
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
