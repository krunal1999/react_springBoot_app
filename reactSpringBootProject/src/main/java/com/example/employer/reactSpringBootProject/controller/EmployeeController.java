package com.example.employer.reactSpringBootProject.controller;

import com.example.employer.reactSpringBootProject.model.Employee;
import com.example.employer.reactSpringBootProject.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);

    }

    @GetMapping("/employee")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){

        boolean deleted = false;
        deleted = employeeService.deleteEmployeeById(id);
        Map<String, Boolean> response = new HashMap<>();
        if(deleted){
            response.put("deleted",deleted);
            return ResponseEntity.ok(response);
        }
        else{
            response.put("Not deleted",deleted);
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = null;
        employee = employeeService.getEmployeeByID(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){

        employee = employeeService.updateEmployee(id,employee);
        return ResponseEntity.ok(employee);

    }



}
