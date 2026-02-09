package com.example.employee.service.service.impl;

import com.example.employee.service.Entity.User;
import com.example.employee.service.Repository.UserRepository;
import com.example.employee.service.exceptionhandling.UserNotFoundException;
import com.example.employee.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public User getUserById(String id) {
        return repository.findById(id).orElseThrow(()-> new UserNotFoundException("User not found with id " + id));
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User updateUser(String id, User user) {
        User existing = getUserById(id);
        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        return repository.save(existing);
    }

    @Override
    public Void deleteUser(String id) {
         repository.deleteById(id);
        return null;
    }
}
