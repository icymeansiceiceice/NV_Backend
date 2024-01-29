package com.management.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.management.dto.ApiResponse;
import com.management.entity.User;
import com.management.service.UserService;


@RestController
@RequestMapping("/User")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createUser(@RequestBody User user){
        if(userService.validate(user)){
            userService.createUser(user);
            return new ResponseEntity<ApiResponse>(ApiResponse.builder().success(true).message("successful").build(),HttpStatus.OK);
        }
        return new ResponseEntity<ApiResponse>(ApiResponse.builder().success(false).message("unsuccessful").build(),HttpStatus.CONFLICT);
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponse> updateUser(@RequestBody User user) {
        if(userService.validate(user)){
            userService.updateUser(user);
            return new ResponseEntity<ApiResponse>(ApiResponse.builder().success(true).message("successful").build(),HttpStatus.OK);
        }
        return new ResponseEntity<ApiResponse>(ApiResponse.builder().success(false).message("unsuccessful").build(),HttpStatus.CONFLICT);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return new ResponseEntity<User>(userService.getUserById(id),HttpStatus.OK);
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getUser() {
        return new ResponseEntity<List<User>>(userService.getUsers(),HttpStatus.OK);
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return new ResponseEntity<ApiResponse>(ApiResponse.builder().success(true).message("successful").build(),HttpStatus.OK);
    }

}
