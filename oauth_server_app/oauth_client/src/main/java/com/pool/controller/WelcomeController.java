package com.pool.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
public class WelcomeController {

    @GetMapping("/")
    public Map<String,String> welcome(Principal principal){
        return Map.of("user",principal.getName());
    }
}
