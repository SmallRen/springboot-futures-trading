package com.futurestrading.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.futurestrading.entity.TOrder;
import com.futurestrading.mapper.TOrderMapper;
import com.futurestrading.service.ITOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sensor
 * @since 2019-03-27
 */
@Service
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements ITOrderService {

    @Override
    public IPage<TOrder> selectByUserId(Integer userId, long current ) {

        IPage<TOrder> page=new Page<>(current,10);
        QueryWrapper<TOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TOrder::getUserId, userId);
        return this.page(page,queryWrapper);
    }
}
