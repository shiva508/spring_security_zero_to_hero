package com.pool.controller;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.security.Principal;
import java.time.Duration;

@RestController
public class WelcomeController {

    @GetMapping(value = "/getrollnumbers",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @PreAuthorize("hasAnyAuthority('read')")
    public Flux<Integer> rollNumbers(){
        return Flux.just(408,423,501,502,503,504,505,506,507,508,509).delayElements(Duration.ofSeconds(1));
    }

    @GetMapping("/username")
    public Mono<String>  getUserName(){
       //return SecurityContextHolder.getContext().getAuthentication().getName();
        return ReactiveSecurityContextHolder.getContext().map(SecurityContext::getAuthentication)
                .map(Principal::getName);
    }

    @GetMapping("/usernameAuth")
    public Mono<String>  getUserNameAuth(@AuthenticationPrincipal Mono<AuthenticatedPrincipal> principalMono){
        return principalMono.map(AuthenticatedPrincipal::getName);
    }
}
