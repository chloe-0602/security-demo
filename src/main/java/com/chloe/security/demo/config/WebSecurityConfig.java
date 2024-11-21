package com.chloe.security.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

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
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(
                User.withDefaultPasswordEncoder()
                        .username("chloe")
                        .password("000000")
                        .build()
        );
        return manager;
    }
}
