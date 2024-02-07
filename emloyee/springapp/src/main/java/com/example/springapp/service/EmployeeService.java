package com.example.springapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.springapp.model.Employee;
import com.example.springapp.repository.EmployeeRepo;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo empRepo;

    public Employee addEmployeeDetails(Employee employee){
        empRepo.save(employee);
        return employee;
        
       
    }

    public Optional<Employee> getemployeebyid(int employeeId){
        return empRepo.findById(employeeId);
    }

    

    public Employee updateemployeebyId(Employee employee , int employeeId){
        if(empRepo.existsById(employeeId)){
            empRepo.save(employee);
            return employee;
        }
        return null;
    }

    
    
}
