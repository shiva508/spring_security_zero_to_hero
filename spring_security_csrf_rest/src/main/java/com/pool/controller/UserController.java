package com.pool.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pool.model.MyUser;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/me")
    public MyUser me(Authentication authentication) {
        return new MyUser(authentication.getName());
    }
}
