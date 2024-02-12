package com.bestbuykamps.websiteshop.web_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {
    @GetMapping("register")
    public String moveToLoginPage(){
        return "REGISTER_PAGE";
    }
}
