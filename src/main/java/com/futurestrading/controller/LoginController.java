package com.futurestrading.controller;

import com.futurestrading.service.ITradingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    ITradingService service;

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
        return "order";
    }

    @GetMapping("/index")
    public String index(HttpServletRequest request) {
        request.setAttribute("agmtcd", service.selectByAgmtcd());
        request.setAttribute("trdvar", service.selectByTrdvar());
        return "index";
    }


}
