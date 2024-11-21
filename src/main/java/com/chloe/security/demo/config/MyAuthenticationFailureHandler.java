package com.chloe.security.demo.config;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: MyAuthenticationFailureHandler
 * Package: com.chloe.security.demo.config
 * Description:
 *
 * @Author Xu, Luqin
 * @Create 2024/11/21 23:19
 * @Version 1.0
 */
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        Map map = new HashMap<>();
        map.put("code", 201);
        map.put("message", exception.getLocalizedMessage());

        String result = JSON.toJSONString(map);

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(result);
    }
}
