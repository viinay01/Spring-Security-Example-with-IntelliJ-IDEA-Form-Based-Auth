package com.spring.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @author Vinay Kumar
 **/
@EnableWebSecurity
@ComponentScan("com.spring.demo")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder()
                .username("vinay").password("vinay").roles("ADMIN").build());
        return manager;
    }

    /**
     * For form based Authentication
     * there is no security for "/index", "/user" and "/"
     * For authenticate formLogin() will render login form.
     **/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
                antMatchers("/index", "/user","/").permitAll()
                .antMatchers("/home").authenticated()
                .and()
                .formLogin()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }
    /**
     * For spring login/logout
     * request with role ADMIN will authenticate by SpringSecurity.
     **/
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http
//                .authorizeRequests()
//                .anyRequest().hasRole("ADMIN")
//                .and().formLogin().and()
//                .httpBasic()
//                .and()
//                .logout()
//                .logoutUrl("/j_spring_security_logout")
//                .logoutSuccessUrl("/")
//        ;
//    }

    /**
     * For custom login/logout
     * there is no security for "/index", "/user" and "/"
     * if /admin url will open then it will authenticate.
     * for authentication /login will call by loginPage() method.
     **/
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests().
//                antMatchers("/index", "/user", "/").permitAll()
//                .antMatchers("/admin").authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
//    }
}
