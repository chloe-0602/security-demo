
package com.chloe.security.demo.controller;

import com.chloe.security.demo.entity.User;
import com.chloe.security.demo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    public UserService userService;

    @GetMapping("/list")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getList(){
        return userService.list();
    }

    @PostMapping("add")
    @PreAuthorize("hasRole('ADMIN') and authentication.name == 'admin'")
    public String add(@RequestBody User user){
        userService.addUserDetails(user);
        return "add user successfully";
    }
}