package org.Sem3HM.employee;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Employee {
    private int id;
    private String name;
    private int age;
    private LocalDate dateOfBirth;
    private Role role;
    private double Salary;
}


