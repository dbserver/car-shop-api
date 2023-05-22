package com.db.carshop.user.impl;

import com.db.carshop.core.security.UserDetailsService;
import com.db.carshop.core.security.impl.UserDetailsImpl;
import com.db.carshop.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository repository;

    @Override
    public Optional<UserDetails> findById(Long id) {
        return repository.findById(id).map(UserDetailsImpl::build);
    }
}
