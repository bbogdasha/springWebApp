package com.bogdan.config;

import com.bogdan.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/", "/greeting", "/registration", "/recipes", "/img/**", "/static/**", "/recipe/*", "/filter").permitAll()
                    .antMatchers("/recipe/delete/**", "/user/**").hasAuthority("ADMIN")
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/greeting")
                    .failureUrl("/login?error=true")
                    .permitAll()
                .and()
                    .logout()
                    .logoutSuccessUrl("/login")
                    .deleteCookies("JSESSIONID")
                    .permitAll()
                .and()
                    .exceptionHandling()
                    .accessDeniedPage("/accessDenied");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userServiceImpl)
                .passwordEncoder(bCryptPasswordEncoder());
    }
}