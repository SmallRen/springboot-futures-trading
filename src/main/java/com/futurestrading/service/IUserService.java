package com.futurestrading.service;

import com.futurestrading.dto.UserDto;
import com.futurestrading.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author sensor
 * @since 2019-03-25
 */
public interface IUserService extends IService<User> {


    /**
     * 获取用户信息
     *
     * @param username
     * @return
     */
    UserDto getUserDto(String username);

    /**
     * 获取用户信息
     *
     * @param username
     * @return
     */
    User getUser(String username);

    /**
     * 检查邮箱是否注册
     *
     * @param email
     * @return
     */
    boolean checkEmail(String email);

    /**
     * 检查用户名是否注册
     *
     * @param username
     * @return
     */
    boolean checkUserName(String username);

    /**
     * 检查手机号是否注册
     *
     * @param tel
     * @return
     */
    boolean checkTel(String tel);
}
