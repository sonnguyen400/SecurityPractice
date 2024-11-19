package com.sonnguyen;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class Controller {
    @GetMapping("/user")
    public Object hello() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
