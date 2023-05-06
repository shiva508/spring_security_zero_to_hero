package com.pool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SpringReactiveSecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http){
        http.httpBasic()
                .and()
                .formLogin();
        http.authorizeExchange()
               // .pathMatchers("/getrollnumbers").hasAnyAuthority("read")
                .anyExchange()
                .authenticated();
        return http.build();
    }

    @Bean
    public ReactiveUserDetailsService reactiveUserDetailsService(){
        UserDetails userDetailsOne= User.withUsername("shiva").password(passwordEncoder().encode( "shiva")).authorities("read").build();
        UserDetails userDetailsTwo= User.withUsername("shivad").password(passwordEncoder().encode( "shivad")).authorities("write").build();
        return new MapReactiveUserDetailsService(userDetailsOne,userDetailsTwo);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
