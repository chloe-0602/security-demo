package com.chloe.security.demo.config;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: MyLogoutHandler
 * Package: com.chloe.security.demo.config
 * Description:
 *
 * @Author Xu, Luqin
 * @Create 2024/11/21 23:28
 * @Version 1.0
 */
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Map map = new HashMap<>();
        map.put("code", 200);
        map.put("message", "注销成功");
        map.put("data", authentication.getPrincipal());

        String result = JSON.toJSONString(map);

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(result);
    }
}
