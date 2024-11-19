package com.sonnguyen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RestClient {
    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
