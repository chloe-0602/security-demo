package com.chloe.security.demo.config;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: MyAuthenticationEntryPoint
 * Package: com.chloe.security.demo.config
 * Description:
 *
 * @Author Xu, Luqin
 * @Create 2024/11/22 0:00
 * @Version 1.0
 */
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        Map map = new HashMap<>();
        map.put("code", 202);
        map.put("message", "需要登录");

        String result = JSON.toJSONString(map);

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(result);
    }
}
