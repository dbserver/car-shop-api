package com.db.carshop.user.impl;

import com.db.carshop.user.User;
import com.db.carshop.user.UserRepository;
import com.db.carshop.user.UserService;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
