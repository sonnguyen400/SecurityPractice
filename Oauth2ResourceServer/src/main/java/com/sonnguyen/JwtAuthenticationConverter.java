package com.sonnguyen;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Collection;
import java.util.stream.Collectors;

public class JwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {
    public AbstractAuthenticationToken convert(Jwt jwt) {
        Collection<String> authorities = jwt.getClaimAsStringList("roles");
        Collection<GrantedAuthority> grantedAuthorities = authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return new JwtAuthenticationToken(jwt, grantedAuthorities);
    }
}
