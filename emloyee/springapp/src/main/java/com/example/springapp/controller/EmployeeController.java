package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Employee;
import com.example.springapp.service.EmployeeService;

@RequestMapping("/api")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService empservice;

    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmployeeDetails(Employee employee){
        return empservice.addEmployeeDetails(employee);
    }


    
}
