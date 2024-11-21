
package com.chloe.security.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chloe.security.demo.entity.User;
import com.chloe.security.demo.mapper.UserMapper;
import com.chloe.security.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}