package com.sonnguyen;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/test")
    public String test() {
        return "test";
    }
    @GetMapping("/user")
    public Object getUser() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
