package com.db.carshop.authentication;

public class LoggedUser {
    private final AuthTokenService tokenService;
    private String token;

    public LoggedUser(AuthTokenService tokenService) {
        this.tokenService = tokenService;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return tokenService.getUserId(token);
    }

}