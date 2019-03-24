package com.futurestrading.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public  String  Login(){
        return  "login";
    }

    @GetMapping("/register")
    public  String  register(){
        return  "register";
    }

    @GetMapping("/index")
    public  String  index(){
        return  "index";
    }


}