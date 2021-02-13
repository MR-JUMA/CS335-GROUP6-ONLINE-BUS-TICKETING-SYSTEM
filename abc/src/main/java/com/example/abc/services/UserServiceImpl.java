package com.example.abc.services;

import com.example.abc.models.User;
import com.example.abc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public User getUserById(int id) {
        return userRepository.findById((long) id).orElse(null);
    }
}
