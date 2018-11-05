package com.example.demo2.service;

import com.example.demo2.entity.User;
import com.example.demo2.exception.UserNotFoundException;
import com.example.demo2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User findUser(String username) throws UserNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException());
        return user;
    }
}
