package com.management.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.entity.User;
import com.management.service.UserService;

@RestController
@RequestMapping("/Auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user){
        User userResponse = userService.loginUser(user);
        if(userService.loginValidation(user) && Objects.nonNull(userResponse)){
            return new ResponseEntity<User>(userResponse,HttpStatus.OK);
        }
        return new ResponseEntity<User>(new User(),HttpStatus.UNAUTHORIZED);
    }



    
}
