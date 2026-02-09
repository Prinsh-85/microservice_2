package com.example.user.service.Controller;

import com.example.user.service.entity.Employee;
import com.example.user.service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;


    //create
    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee){
        return new ResponseEntity<>(service.create(employee), HttpStatus.CREATED);
    }

    //get by id
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable String id){
        Employee abc = service.getById(id);
        return ResponseEntity.ok(abc);
    }

    //get all
    @GetMapping
    public  ResponseEntity<List<Employee>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    //update
    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable String id, @RequestBody Employee employee){
        return ResponseEntity.ok(service.update(id, employee));
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}
