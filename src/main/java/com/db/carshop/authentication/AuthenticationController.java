package com.db.carshop.authentication;

import com.db.carshop.authentication.dto.AuthenticationOutput;
import com.db.carshop.authentication.dto.AuthenticationInput;
import com.db.carshop.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authManager;
    private final AuthTokenService tokenService;

    @PostMapping("/auth")
    public ResponseEntity<AuthenticationOutput> authenticate(@RequestBody AuthenticationInput  input) {


        UsernamePasswordAuthenticationToken loginModel = input.toUsernamePasswordAuthenticationToken();

        try {
            Authentication authentication = authManager.authenticate(loginModel);
            String token = tokenService.generateToken(authentication);

            return ResponseEntity.ok(new AuthenticationOutput(token));
        } catch (AuthenticationException e) {
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
