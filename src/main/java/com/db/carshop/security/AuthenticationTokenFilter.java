package com.db.carshop.security;

import com.db.carshop.authentication.LoggedUser;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@AllArgsConstructor
public class AuthenticationTokenFilter extends OncePerRequestFilter {
    private final TokenService tokenService;
    private final UserDetailsService userDetailsService;
    private final LoggedUser loggedUser;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
            String token = getTokenByRequest(httpServletRequest);
            boolean validToken = tokenService.isValidToken(token);

            if (validToken) {
                authenticateUser(token);
            }

            filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private void authenticateUser(String token)  {
        Long userId = tokenService.getUserId(token);
        Optional<UserDetails> userOptional = userDetailsService.findById(userId);

        if(userOptional.isPresent()){
            UserDetails user = userOptional.get();
            Authentication authentication = new UsernamePasswordAuthenticationToken(user,null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            loggedUser.setToken(token);
        } else {
            throw new RuntimeException("User with id " + userId + " does not exist");
        }
    }

    private String getTokenByRequest(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer ")) {
            return null;
        }
        return token.substring(7);
    }
}
