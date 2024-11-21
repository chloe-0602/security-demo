package com.chloe.security.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.lang.invoke.VarHandle;

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
        http
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults()); //默认的登录登出页
//                .httpBasic(Customizer.withDefaults());// 使用基本的授权方式，一般不用！
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
