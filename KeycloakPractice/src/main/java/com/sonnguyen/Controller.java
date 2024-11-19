package com.sonnguyen;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class Controller {
    @GetMapping(value = "/hello")
    @PreAuthorize("hasAnyRole('ROLE_READ')")
    public String hello() {
        return "READ Hello World";
    }
    @PostMapping(value = "/hello")
    @PreAuthorize("hasAnyRole('ROLE_WRITE')")
    public String helloPost(@RequestParam(name = "name",defaultValue = "hello word",required = false) String name) {
        return "WRITE "+name;
    }
    @PutMapping(value = "/hello")
    @PreAuthorize("hasAnyRole('ROLE_EDIT')")
    public String helloPut(@RequestParam(name = "name",defaultValue = "hello word",required = false) String name) {
        return "EDIT "+name;
    }

}
