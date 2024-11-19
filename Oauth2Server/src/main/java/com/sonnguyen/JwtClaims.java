package com.sonnguyen;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Component
@Slf4j
public class JwtClaims {

    public Map<String, Object> getClaims(Authentication principal) {
        Map<String, Object> claims = new HashMap<>();
        if(principal==null|| !principal.isAuthenticated()) {
            return Map.of();
        }
        claims.put("roles", principal.getAuthorities().stream().map((GrantedAuthority::getAuthority)));
        return claims;
    }

    private String convertToString(Object obj) {
        return obj == null ? null : obj.toString();
    }

}
