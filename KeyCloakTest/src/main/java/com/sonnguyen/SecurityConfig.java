package com.sonnguyen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Autowired
    Oauth2SuccessHandler oauth2SuccessHandler;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
        httpSecurity.oauth2Login((oauth2Login)->{
            oauth2Login.successHandler(oauth2SuccessHandler);
        });
        return  httpSecurity.build();
    }
    @Bean
    public JwtDecoder jwtDecoders(){
        return NimbusJwtDecoder.withJwkSetUri("http://localhost:8080/realms/whatamovie-front/protocol/openid-connect/certs").build();
    }
}
