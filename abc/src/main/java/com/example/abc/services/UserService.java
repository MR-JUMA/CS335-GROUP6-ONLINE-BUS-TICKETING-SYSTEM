package com.example.abc.services;

import com.example.abc.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User getUserById(int id);
}
