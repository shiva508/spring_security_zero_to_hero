package com.pool.controller;

import com.pool.service.RequestTrackerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class WelcomeController {

    private final RequestTrackerService requestTrackerService;

    public WelcomeController(RequestTrackerService requestTrackerService) {
        this.requestTrackerService = requestTrackerService;
    }

    @GetMapping("/welcome")
    public String welcome(Principal principal, HttpSession httpSession){
        requestTrackerService.trackUser(httpSession,principal.getName());
        return "Welcome to App :-: "+principal.getName();
    }
    @GetMapping("/requestcount")
    public String requestCount(Principal principal, HttpSession httpSession){
        var requestCount = requestTrackerService.requestCount(httpSession, principal.getName());
        return ":-: "+principal.getName()+" Visited this app "+requestCount+" times";
    }
}
