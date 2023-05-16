package com.db.carshop.authentication.impl;


import com.db.carshop.authentication.AuthenticationService;
import com.db.carshop.security.impl.UserDetailsImpl;
import com.db.carshop.user.User;
import com.db.carshop.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Invalid email/username"));

        return UserDetailsImpl.build(user);
    }
}
