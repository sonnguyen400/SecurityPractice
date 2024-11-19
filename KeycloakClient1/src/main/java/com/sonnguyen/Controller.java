package com.sonnguyen;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class Controller {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
    @GetMapping("/user")
    public Object user() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
