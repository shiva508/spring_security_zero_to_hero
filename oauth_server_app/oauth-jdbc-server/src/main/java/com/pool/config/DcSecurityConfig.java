package com.pool.config;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
public class DcSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public ApplicationRunner userRunner(JdbcUserDetailsManager jdbcUserDetailsManager){
        return args -> {
            User.UserBuilder userBuilder = User.builder().roles("USER");
            Map<String,String> users=Map.of("shiva",passwordEncoder().encode("shiva"),"dasari",passwordEncoder().encode("shiva"));
            users.forEach((usename,passwod)->{
                if (!jdbcUserDetailsManager.userExists(usename)) {
                    UserDetails user=userBuilder.username(usename).password(passwod).build();
                    jdbcUserDetailsManager.createUser(user);
                }
            });
        };
    }
}
