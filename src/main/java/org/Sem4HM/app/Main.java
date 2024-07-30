package org.Sem4HM.app;

import org.Sem4HM.Employee;
import org.Sem4HM.Male;
import org.Sem4HM.Role;
import org.Sem4HM.util.GreetEmployee;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Costea", Male.MALE, 20, Role.SENIOR_DEVELOPER);
        Employee emp2 = new Employee("Nastea", Male.FEMALE, 28, Role.MANAGER);
        Employee emp3 = new Employee("Kirill", Male.MALE, 22, Role.MID_LEVEL_DEVELOPER);
        Employee emp4 = new Employee("Sasha", Male.MALE, 23, Role.JUNIOR_DEVELOPER);

        List<Employee> employees = List.of(emp1, emp2, emp3, emp4);
        GreetEmployee.getGreet(employees);
    }
}
