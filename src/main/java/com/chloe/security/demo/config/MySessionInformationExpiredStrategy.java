package com.chloe.security.demo.config;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: MySessionInformationExpiredStrategy
 * Package: com.chloe.security.demo.config
 * Description:
 *
 * @Author Xu, Luqin
 * @Create 2024/11/22 9:54
 * @Version 1.0
 */
public class MySessionInformationExpiredStrategy implements SessionInformationExpiredStrategy {
    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
        HttpServletResponse response = event.getResponse();
        Map map = new HashMap<>();
        map.put("code", 201);
        map.put("message", "有其他机器登录");

        String result = JSON.toJSONString(map);

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(result);
    }
}
