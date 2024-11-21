package com.chloe.security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ClassName: IndexController
 * Package: com.chloe.security.demo.controller
 * Description:
 *
 * @Author Xu, Luqin
 * @Create 2024/11/21 14:50
 * @Version 1.0
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
