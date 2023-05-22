package com.db.carshop.core.security;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserDetailsService {
    Optional<UserDetails> findById(Long id);
}