package com.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Employee;
import com.example.springapp.repository.EmployeeRepo;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo empRepo;

    public ResponseEntity<Employee> addEmployeeDetails(Employee employee){
       Employee added =  empRepo.save(employee);
       if(added != null){
        return new ResponseEntity<>(employee , HttpStatus.CREATED);
       }else{
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
    
}
