package com.example.employer.reactSpringBootProject.service;

import com.example.employer.reactSpringBootProject.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployee();

    boolean deleteEmployeeById(Long id);

    Employee getEmployeeByID(Long id);

    Employee updateEmployee(Long id, Employee employee);
}
