package com.futurestrading.service.impl;

import com.futurestrading.entity.User;
import com.futurestrading.mapper.UserMapper;
import com.futurestrading.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
