package com.graph.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrafyConfiguration {

    @Value("${jwt.public.key.path}")
    private String jwtPublicKeyPath;

    @Value("${auth.roles.clients}")
    private String[]  authRolesClients;

    public String getJwtPublicKeyPath() {
        return jwtPublicKeyPath;
    }

    public String[] getAuthRolesClients() {
        return authRolesClients;

    }

}
