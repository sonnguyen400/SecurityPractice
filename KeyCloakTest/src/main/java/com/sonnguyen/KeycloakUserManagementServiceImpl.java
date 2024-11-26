package com.sonnguyen;

import org.keycloak.admin.client.Keycloak;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

@ConditionalOnBean(Keycloak.class)
public class KeycloakUserManagementServiceImpl implements UserManagementService{

    @Override
    public String test() {
        return "test";
    }
}
