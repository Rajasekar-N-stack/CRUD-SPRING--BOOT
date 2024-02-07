package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Employee;
import com.example.springapp.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService empservice;

    @PostMapping("/api/employee")
    public ResponseEntity<Employee> addEmployeeDetails(Employee employee){
       Employee added =  empservice.addEmployeeDetails(employee);
       if(added!=null){
         return ResponseEntity.ok(added);
       }else{
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
       }


    }


    
}
