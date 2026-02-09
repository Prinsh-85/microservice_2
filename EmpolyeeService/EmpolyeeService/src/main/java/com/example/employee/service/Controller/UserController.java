package com.example.employee.service.Controller;

import com.example.employee.service.Entity.User;
import com.example.employee.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //Get by id
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id){
        User user = service.getUserById(id);
        return ResponseEntity.ok(user);
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(service.getAllUsers());
    }

}
