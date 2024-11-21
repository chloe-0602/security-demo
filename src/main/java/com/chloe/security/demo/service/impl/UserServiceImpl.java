
package com.chloe.security.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chloe.security.demo.config.DBUserDetailsManager;
import com.chloe.security.demo.entity.User;
import com.chloe.security.demo.mapper.UserMapper;
import com.chloe.security.demo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private DBUserDetailsManager dbUserDetailsManager;

    @Override
    public void addUserDetails(User user) {
        dbUserDetailsManager.createUser(org.springframework.security.core.userdetails.User
                .withDefaultPasswordEncoder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build());
    }
}