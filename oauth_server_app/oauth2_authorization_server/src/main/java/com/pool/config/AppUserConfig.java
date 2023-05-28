package com.pool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppUserConfig {

    @Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager detailsManager=new InMemoryUserDetailsManager();
        UserDetails userDetails= User.withDefaultPasswordEncoder()
                                     .username("shiva")
                                     .password("shiva")
                                     .roles("admin")
                                     .build();
        detailsManager.createUser(userDetails);
        return detailsManager;
    }
    //@Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
