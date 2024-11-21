package com.chloe.security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ClassName: LoginController
 * Package: com.chloe.security.demo.controller
 * Description:
 *
 * @Author Xu, Luqin
 * @Create 2024/11/21 22:17
 * @Version 1.0
 */
@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
