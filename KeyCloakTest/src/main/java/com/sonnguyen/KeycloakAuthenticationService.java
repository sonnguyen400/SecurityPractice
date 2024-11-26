package com.sonnguyen;

import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class KeycloakAuthenticationService {
    @Autowired
    OAuth2AuthorizedClientService oauth2AuthorizedClientService;
    public ResponseEntity<Map<String, Object>> login(Map<String,Object> payload) {
        OAuth2AuthenticationToken authentication = (OAuth2AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        OAuth2AuthorizedClient oAuth2AuthorizedClient=oauth2AuthorizedClientService.loadAuthorizedClient(authentication.getAuthorizedClientRegistrationId(),authentication.getName());
        return  ResponseEntity.ok(
                Map.of(
                        "refresh_token",oAuth2AuthorizedClient.getRefreshToken().getTokenValue(),
                        "access_token",oAuth2AuthorizedClient.getAccessToken().getTokenValue()
                )
        );
    }
}
