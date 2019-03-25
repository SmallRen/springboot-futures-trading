package com.futurestrading.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.futurestrading.entity.Trading;
import com.futurestrading.mapper.TradingMapper;
import com.futurestrading.service.ITradingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author sensor
 * @since 2019-03-25
 */
@Service
public class TradingServiceImpl extends ServiceImpl<TradingMapper, Trading> implements ITradingService {

    @Override
    public List<String> selectByTrdvar() {
        List<String> stringList = new ArrayList<>();
        QueryWrapper<Trading> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().groupBy(Trading::getTrdvar).select(Trading::getTrdvar);
        List<Trading> list = this.list(queryWrapper);
        for (Trading trading : list) {
            stringList.add(trading.getTrdvar());
        }
        return stringList;
    }

    @Override
    public List<String> selectByAgmtcd() {
        List<String> stringList = new ArrayList<>();
        QueryWrapper<Trading> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().groupBy(Trading::getAgmtcd).select(Trading::getAgmtcd);
        List<Trading> list = this.list(queryWrapper);
        for (Trading trading : list) {
            stringList.add(trading.getAgmtcd());
        }
        return stringList;
    }

    @Override
    public List<Trading> select(String fdt001, String trdvar, String agmtcd) {
        QueryWrapper<Trading> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Trading::getFdt001, fdt001).eq(Trading::getTrdvar, trdvar).eq(Trading::getAgmtcd, agmtcd);
        return this.list(queryWrapper);

    }


}
