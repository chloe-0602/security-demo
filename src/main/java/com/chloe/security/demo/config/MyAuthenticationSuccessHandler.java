package com.chloe.security.demo.config;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: MyAuthenticationSuccessHandler
 * Package: com.chloe.security.demo.config
 * Description:
 *
 * @Author Xu, Luqin
 * @Create 2024/11/21 23:10
 * @Version 1.0
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Map map = new HashMap<>();
        map.put("code", 200);
        map.put("message", "登录成功");
        map.put("data", authentication.getPrincipal());

        String result = JSON.toJSONString(map);

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(result);
    }
}
