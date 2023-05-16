package com.db.carshop.security;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserDetailsService {
    Optional<UserDetails> findById(Long id);
}