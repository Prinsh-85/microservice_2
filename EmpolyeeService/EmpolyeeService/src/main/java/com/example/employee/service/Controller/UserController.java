package com.example.employee.service.Controller;

import com.example.employee.service.Entity.User;
import com.example.employee.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    //Create
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User saved = service.createUser(user);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);

    }

}
