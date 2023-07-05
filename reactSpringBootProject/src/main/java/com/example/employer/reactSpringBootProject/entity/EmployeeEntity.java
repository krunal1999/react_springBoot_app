package com.example.employer.reactSpringBootProject.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstname;
    private String lastname;
    private String email;
}
