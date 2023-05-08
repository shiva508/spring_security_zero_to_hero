package com.pool.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

@Component
public class RequestTrackerService {
    public void trackUser(HttpSession httpSession, String name) {
        var requestCount = httpSession.getAttribute(name) == null ? 0 : (Integer) httpSession.getAttribute(name);
        httpSession.setAttribute(name, requestCount + 1);
    }

    public Integer requestCount(HttpSession httpSession, String name){
        return httpSession.getAttribute(name) == null ? 0 : (Integer) httpSession.getAttribute(name);
    }
}
