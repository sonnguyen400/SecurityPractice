package com.sonnguyen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class TestController {
    @Autowired
    KeycloakAuthenticationService keycloakAuthenticationService;
    @GetMapping(value = "/test")
    public String test() {
        return "test";
    }
    @GetMapping(value = "/login")
    public ResponseEntity<Map<String, Object>> token(Map<String,Object> map) {
        return keycloakAuthenticationService.login(map);
    }
}
