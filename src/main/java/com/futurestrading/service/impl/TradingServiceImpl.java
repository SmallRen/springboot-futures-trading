package com.futurestrading.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.futurestrading.entity.Trading;
import com.futurestrading.mapper.TradingMapper;
import com.futurestrading.service.ITradingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
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
    public List<List<String>> select(String fdt001, String trdvar, String agmtcd) {
        List<List<String>> lists = new ArrayList<>();
        QueryWrapper<Trading> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Trading::getFdt001, fdt001).eq(Trading::getTrdvar, trdvar).eq(Trading::getAgmtcd, agmtcd);

        List<Trading> list = this.list(queryWrapper);
        for (int i = 0; i < list.size(); i++) {
            List<String> strings = new ArrayList<>();
            Trading trading = list.get(i);
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            strings.add(df.format(trading.getTrddt()));
            strings.add(String.valueOf(trading.getFdt003()));
            strings.add(String.valueOf(trading.getFdt004()));
            strings.add(String.valueOf(trading.getFdt005()));
            strings.add(String.valueOf(trading.getFdt006()));
            strings.add(String.valueOf(trading.getFdt007()));
            strings.add(String.valueOf(trading.getFdt010()));
            strings.add(String.valueOf(trading.getFdt011()));
            strings.add(String.valueOf(trading.getFdt013()));
            // 数据意义：开盘(open)，收盘(close)，最低(lowest)，最高(highest)
            lists.add(strings);
        }

           /* var data0 = splitData([
                     ['2013/1/24', 2320.26, 2320.26, 2287.3, 2362.94],
                     ['2013/6/13', 2190.1, 2148.35, 2126.22, 2190.1]
                 ]);*/


        return lists;

    }


}
