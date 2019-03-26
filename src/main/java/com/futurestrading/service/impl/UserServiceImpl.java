package com.futurestrading.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.futurestrading.entity.User;
import com.futurestrading.mapper.UserMapper;
import com.futurestrading.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author sensor
 * @since 2019-03-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    @Override
    public User getUserDto(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUsername, username);
        User user = this.getOne(queryWrapper);
        return user;
    }

    @Override
    public User getUser(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUsername, username);
        return this.getOne(queryWrapper);
    }

    @Override
    public boolean checkEmail(String email) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getEmail, email);
        return this.getOne(queryWrapper) == null ? false : true;
    }

    @Override
    public boolean checkUserName(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUsername, username);
        return this.getOne(queryWrapper) == null ? false : true;
    }

    @Override
    public boolean checkTel(String tel) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getTel, tel);
        return this.getOne(queryWrapper) == null ? false : true;
    }
}
