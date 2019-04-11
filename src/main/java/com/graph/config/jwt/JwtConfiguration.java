package com.graph.config.jwt;

import com.graph.config.GrafyConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Configuration
public class JwtConfiguration {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GrafyConfiguration grafyConfiguration;

    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Bean
    @Qualifier("tokenStore")
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter);
    }

    @Bean
    protected JwtAccessTokenConverter jwtTokenEnhancer() {
        try {
            JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
            String publicKey = new String(Files.readAllBytes(Paths.get(grafyConfiguration.getJwtPublicKeyPath())));
            converter.setVerifierKey(publicKey);
            return converter;
        } catch (IOException e) {
            logger.error("Can not generate jwt token enhancer, message: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
