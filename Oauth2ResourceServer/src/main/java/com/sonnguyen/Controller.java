package com.sonnguyen;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class Controller {
    @PreAuthorize("hasAnyRole('ROLE_READ')")
    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello World";
    }
    @PreAuthorize("hasAnyRole('ROLE_WRITE')")
    @PostMapping(value = "/hello")
    public String postHello(@RequestParam(name = "name", defaultValue = "xin chao",required = false) String name) {
        return name;
    }
}
