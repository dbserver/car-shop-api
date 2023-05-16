package com.db.carshop.authentication.impl;

import com.db.carshop.authentication.AuthTokenService;
import com.db.carshop.security.impl.UserDetailsImpl;
import com.db.carshop.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

public class AuthTokenServiceImpl implements AuthTokenService {
    private final String expiration;
    private final String secret;

    private static final String API = "API";
    private static final String TYPE = "type";
    private static final String EMAIL = "email";

    public AuthTokenServiceImpl(String expiration, String secret) {
        this.expiration = expiration;
        this.secret = secret;
    }

    @Override
    public String generateToken(Authentication authentication) {

        UserDetailsImpl user = (UserDetailsImpl) authentication.getPrincipal();

        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
                .setIssuer(API)
                .claim(TYPE, "App")
                .claim(EMAIL, user.getEmail())
                .setSubject(user.getId().toString())
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    @Override
    public boolean isValidToken(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return  true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Long getUserId(String token) {
        Claims claims = getClaims(token);
        return Long.parseLong(claims.getSubject());
    }

    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
    }
}
