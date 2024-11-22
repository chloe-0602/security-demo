package com.chloe.security.demo.controller;

import com.alibaba.fastjson2.JSON;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: IndexController
 * Package: com.chloe.security.demo.controller
 * Description:
 *
 * @Author Xu, Luqin
 * @Create 2024/11/21 14:50
 * @Version 1.0
 */
@RestController
public class IndexController {
    @GetMapping("/")
    public String index(){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        String username = authentication.getName();
        Object principal = authentication.getPrincipal();
        Object credentials = authentication.getCredentials();// 凭证，生产情况下需要脱敏
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        Map map = new HashMap();
        map.put("code", 200);
        map.put("message", "success");
        map.put("principal", principal);
        map.put("username", username);
        map.put("credentials", credentials);
        map.put("authorities", authorities);

        return JSON.toJSONString(map);
    }
}
