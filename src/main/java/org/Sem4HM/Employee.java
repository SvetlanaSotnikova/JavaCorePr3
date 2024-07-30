package org.Sem4HM;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Employee {
    private String name;
    private Male male;
    private int age;
    private Role role;
}
