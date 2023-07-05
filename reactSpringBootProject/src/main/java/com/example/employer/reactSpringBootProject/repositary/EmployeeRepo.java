package com.example.employer.reactSpringBootProject.repositary;

import com.example.employer.reactSpringBootProject.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity,Long> {


}
