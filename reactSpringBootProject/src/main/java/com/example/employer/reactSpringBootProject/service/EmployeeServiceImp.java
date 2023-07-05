package com.example.employer.reactSpringBootProject.service;

import com.example.employer.reactSpringBootProject.entity.EmployeeEntity;
import com.example.employer.reactSpringBootProject.model.Employee;
import com.example.employer.reactSpringBootProject.repositary.EmployeeRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    public EmployeeServiceImp(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();

        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepo.save(employeeEntity);


        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {

        List<EmployeeEntity> employeeEntityList = employeeRepo.findAll();

        List<Employee> employeeList = employeeEntityList.stream().map(emp ->
                new Employee(emp.getId(), emp.getFirstname(), emp.getLastname(), emp.getEmail()))
                .collect(Collectors.toList());
        return employeeList;
    }

    @Override
    public boolean deleteEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepo.findById(id).get();
        if(employeeEntity != null){
            employeeRepo.delete(employeeEntity);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Employee getEmployeeByID(Long id) {
        EmployeeEntity employeeEntity = employeeRepo.findById(id).get();

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity,employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        EmployeeEntity employeeEntity = employeeRepo.findById(id).get();
        employeeEntity.setFirstname(employee.getFirstname());
        employeeEntity.setLastname(employee.getLastname());
        employeeEntity.setEmail(employee.getEmail());
        employeeRepo.save(employeeEntity);
        return employee;
    }
}
