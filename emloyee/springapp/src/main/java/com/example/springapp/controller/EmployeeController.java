package com.example.springapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Employee;
import com.example.springapp.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService empservice;

    @PostMapping("/api/employee")
    public ResponseEntity<Employee> addEmployeeDetails(@RequestBody Employee employee){
       Employee added =  empservice.addEmployeeDetails(employee);
       if(added!=null){
         return  new ResponseEntity<>(added , HttpStatus.CREATED);
       }else{
        return new  ResponseEntity<>(added , HttpStatus.INTERNAL_SERVER_ERROR);
       }


    }

    @GetMapping("/api/employee/{employeeId}")
    public Optional<Employee> getbyemployeeid(@PathVariable int employeeId){
        return empservice.getemployeebyid(employeeId);
    }

    @PutMapping("/api/employee/{employeeId}")
    public Employee updateShirt(@RequestBody Employee employee, @PathVariable int employeeId) {
        return empservice.updateproduct(employee, employeeId);
    }

    @DeleteMapping("/api/employee/{employeeId}")
    public boolean deleteemployee(@PathVariable int employeeId){
        return empservice.deleteemployee(employeeId);
    }



    
}
