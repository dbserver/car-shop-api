package com.db.carshop.authentication;

import com.db.carshop.authentication.impl.AuthTokenServiceImpl;
import com.db.carshop.authentication.impl.AuthenticationServiceImpl;
import com.db.carshop.user.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class AuthenticationConfig {
    @Value("${jwt.expiration}")
    private String tokenExpiration;

    @Value("${jwt.secret}")
    private String tokenSecret;

    @Bean
    public AuthTokenService tokenService() {
        return new AuthTokenServiceImpl(tokenExpiration, tokenSecret);
    }

    @Bean
    public AuthenticationService appAuthenticationService(UserService userService) {
        return new AuthenticationServiceImpl(userService);
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public LoggedUser appLoggedUser() {
        return new LoggedUser(tokenService());
    }
}
