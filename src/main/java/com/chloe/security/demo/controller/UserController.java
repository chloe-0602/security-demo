
package com.chloe.security.demo.controller;

import com.chloe.security.demo.entity.User;
import com.chloe.security.demo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    public UserService userService;

    @GetMapping("/list")
    public List<User> getList(){
        return userService.list();
    }

    @PostMapping("add")
    public String add(@RequestBody User user){
        userService.addUserDetails(user);
        return "add user successfully";
    }
}