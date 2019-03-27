package com.futurestrading.controller;

import com.futurestrading.mapper.TOrderMapper;
import com.futurestrading.service.ITOrderService;
import com.futurestrading.service.ITradingService;
import com.futurestrading.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    ITradingService service;
    @Autowired
    IUserService userService;
    @Autowired
    HttpSession httpSession;
    @Autowired
    ITOrderService orderService;

    @GetMapping("/login")
    public String Login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/userInfo")
    public String userInfo() {
        return "userInfo";
    }


    @GetMapping("/order")
    public String order() {
        httpSession.setAttribute("order", orderService.list());
        return "order";
    }

    @GetMapping("/index")
    public String index(HttpServletRequest request) {
        request.setAttribute("agmtcd", service.selectByAgmtcd());
        request.setAttribute("trdvar", service.selectByTrdvar());
        return "index";
    }
    @GetMapping("/business")
    public String business(HttpServletRequest request) {
        request.setAttribute("agmtcd", service.selectByAgmtcd());
        request.setAttribute("trdvar", service.selectByTrdvar());
        return "business";
    }

}
