
package com.chloe.security.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chloe.security.demo.entity.User;

public interface UserService extends IService<User> {
    void addUserDetails(User user);
}