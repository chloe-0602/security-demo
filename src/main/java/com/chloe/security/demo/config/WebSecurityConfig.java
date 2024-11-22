package com.chloe.security.demo.config;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: WebSecurityConfig
 * Package: com.chloe.security.demo.config
 * Description:
 *
 * @Author Xu, Luqin
 * @Create 2024/11/21 16:28
 * @Version 1.0
 */
@Configuration
//@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(
                authorize -> authorize
                        .requestMatchers("/user/**").hasRole("ADMIN")
//                        .requestMatchers("/user/list").hasAnyAuthority("USER_LIST")
//                        .requestMatchers("/user/add").hasAnyAuthority("USER_ADD")
                        .anyRequest()
                        .authenticated()
        );

        http.formLogin(
                form -> {
                    form.loginPage("/login").permitAll()
                            .usernameParameter("myusername")
                            .passwordParameter("mypassword")
                            .failureUrl("/login?failure") //注意是 failureurl 不是其他的
                            .successHandler(new MyAuthenticationSuccessHandler())
                            .failureHandler(new MyAuthenticationFailureHandler());// 注意这个需要再failureurl之后，否则不生效
                });

        http.formLogin(Customizer.withDefaults()); //默认的登录登出页
//                .httpBasic(Customizer.withDefaults());// 使用基本的授权方式，一般不用！

        http.logout(
                logout ->
                        logout.logoutSuccessHandler(new MyLogoutSuccessHandler())
        );

        http.exceptionHandling(exception -> {
            exception.authenticationEntryPoint(new MyAuthenticationEntryPoint());
            exception.accessDeniedHandler((request, response, accessDeniedException) -> {
                Map map = new HashMap<>();
                map.put("code", 400);
                map.put("message", "权限不足");

                String result = JSON.toJSONString(map);

                response.setContentType("application/json;charset=UTF-8");
                response.getWriter().write(result);
            });
        });

        http.cors(Customizer.withDefaults());

        http.sessionManagement(
                session -> {
                    session.maximumSessions(1)
                            .expiredSessionStrategy(new MySessionInformationExpiredStrategy());
                }
        );

        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
/*    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(
                User.withDefaultPasswordEncoder()
                        .username("chloe")
                        .password("000000")
                        .build()
        );
        return manager;
    }*/

/*    @Bean
    public UserDetailsService userDetailsService() {
        return new DBUserDetailsManager();
    }*/
}
