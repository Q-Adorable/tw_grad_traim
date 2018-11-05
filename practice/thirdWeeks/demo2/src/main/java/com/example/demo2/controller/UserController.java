package com.example.demo2.controller;

import com.example.demo2.controller.request.UserLoginRequest;
import com.example.demo2.entity.User;
import com.example.demo2.exception.UserNotFoundException;
import com.example.demo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String login() {
        User user = new User();
        return "hello!" + user.getUsername() + ":" + user.getPassword() + ":" + user.getId();
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody UserLoginRequest userLoginRequest) throws UserNotFoundException {
        User user = userService.findUser(userLoginRequest.getUsername());
        return ResponseEntity.created(URI.create("/" + user.getId())).build();
    }

    @GetMapping
    public void getUser(@RequestHeader(name = "userId") int userId) {
        System.out.println("+++++++++++++++++" + userId);
    }

}
