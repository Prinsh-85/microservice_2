package com.example.user.service.service;

import com.example.user.service.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee create(Employee employee);
    Employee getById(String id);
    List<Employee> getAll();
    Employee update(String id, Employee employee);
    void delete(String id);
}
