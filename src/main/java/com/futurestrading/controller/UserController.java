package com.futurestrading.controller;


import com.futurestrading.entity.User;
import com.futurestrading.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author sensor
 * @since 2019-03-24
 */
@Controller
@RequestMapping("/user")
public class UserController {
    protected static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    HttpSession httpSession;
    @Autowired
    IUserService userService;

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @ResponseBody
    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        logger.info(username + password);
        if (userService.checkUserName(username)) {
            Subject currentUser = SecurityUtils.getSubject();
            if (currentUser.isRemembered()) {
            } else {
            }
            if (!currentUser.isAuthenticated()) {
                UsernamePasswordToken token = new UsernamePasswordToken(username, password);
                try {
                    logger.info("1. " + token.hashCode());
                    // 执行登录.
                    currentUser.login(token);
                }
                // 所有认证时异常的父类.
                catch (Exception ae) {
                    return "validationError";
                }
                httpSession.setAttribute("userInfo", userService.getUserDto(username));
                return "true";
            }
        } else {

            return "unknownUser";
        }

        return "false";
    }

    /**
     * 用户注册
     * @param username
     * @param password
     * @param tel
     * @param email
     * @return
     */
    @ResponseBody
    @PostMapping("/register")
    public boolean register(@RequestParam("username") String username, @RequestParam("password") String password,
                            @RequestParam("tel") String tel, @RequestParam("email") String email) {
        if (!userService.checkEmail(email) && !userService.checkTel(tel) && !userService.checkUserName(username)) {
            return userService.save(new User(username, password, tel, email, 10000.00));
        }
        return false;
    }

    /**
     * 检查手机号是否绑定
     * @param tel
     * @return
     */
    @ResponseBody
    @PostMapping("/checkTel")
    public boolean checkTel(@RequestParam("tel") String tel) {

        return userService.checkTel(tel);


    }

    /**
     * 检查用户名是否注册
     * @param username
     * @return
     */
    @ResponseBody
    @PostMapping("/checkUserName")
    public boolean checkUser(@RequestParam("username") String username) {
        return userService.getUser(username) == null ? false : true;
    }

    /**
     * 检查邮箱是否绑定
     * @param email
     * @return
     */
    @ResponseBody
    @PostMapping("/checkEmail")
    public boolean checkEmail(@RequestParam("email") String email) {
        return userService.checkEmail(email);
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @GetMapping("/update")
    public String update(User user) {
         userService.update(user,null);
         return  "userInfo";
    }

}
