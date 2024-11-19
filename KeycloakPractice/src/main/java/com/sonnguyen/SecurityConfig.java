package com.sonnguyen;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((httpRequests) -> httpRequests.anyRequest().authenticated());
        http.oauth2ResourceServer(resourceServerConfigurer -> {
            resourceServerConfigurer.jwt(jwtConfigurer -> {
                jwtConfigurer.jwtAuthenticationConverter(new JwtAuthenticationConverter());
            });
        });
        return http.build();
    }
}
