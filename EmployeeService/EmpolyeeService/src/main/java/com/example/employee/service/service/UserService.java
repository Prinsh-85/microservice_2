package com.example.employee.service.service;

import com.example.employee.service.Entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(String  id);
    List<User> getAllUsers();
    User updateUser(String id, User user);
    Void deleteUser(String id);
}
