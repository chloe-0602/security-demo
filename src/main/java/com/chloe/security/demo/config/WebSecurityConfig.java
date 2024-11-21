package com.chloe.security.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

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
