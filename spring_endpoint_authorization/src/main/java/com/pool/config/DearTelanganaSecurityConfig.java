package com.pool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DearTelanganaSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       return http.httpBasic().and()
               //.authorizeHttpRequests(autz->autz.anyRequest().authenticated())
               //.authorizeHttpRequests(autz->autz.anyRequest().permitAll())
               //.authorizeHttpRequests(autz->autz.anyRequest().hasAnyAuthority("read"))
               //.authorizeHttpRequests(autz->autz.anyRequest().hasAnyRole("ROLE_ADMIN"))
               //.authorizeHttpRequests(autz->autz.anyRequest().access("isAuthenticated()"))
               /*.authorizeHttpRequests(autz ->{
                   //autz.requestMatchers("/").hasAuthority("read");
                   autz.requestMatchers("/welcome/*").hasAuthority("write");
                   autz.anyRequest().authenticated();
               })*/
               .authorizeHttpRequests().requestMatchers("/api/v1/welcome").hasAuthority("write")
               .anyRequest().authenticated()
               .and()
               .build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager detailsManager=new InMemoryUserDetailsManager();
        UserDetails userOne= User.builder().username("shiva").password(passwordEncoder().encode("shiva")).roles("USER").authorities("read").build();
        UserDetails userTwo= User.builder().username("dasari").password(passwordEncoder().encode("dasari")).roles("ADMIN").authorities("write").build();
        detailsManager.createUser(userOne);
        detailsManager.createUser(userTwo);
        return detailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
