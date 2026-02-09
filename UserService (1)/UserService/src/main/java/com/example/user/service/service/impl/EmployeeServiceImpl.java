package com.example.user.service.service.impl;

import com.example.user.service.Repository.EmployeeRepository;
import com.example.user.service.entity.Employee;
import com.example.user.service.service.EmployeeService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;


    @Override
    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee getById(String id) {
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Employee not found with id " + id));
    }

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @Override
    public Employee update(String id, Employee employee) {
        Employee existing = getById(id);
        existing.setName(employee.getName());
        existing.setDepartment(employee.getDepartment());
        existing.setSalary(employee.getSalary());
        return repository.save(existing);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);

    }
}
