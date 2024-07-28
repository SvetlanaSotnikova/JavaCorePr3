package org.Sem3HM.app;

import org.Sem3HM.employee.Employee;
import org.Sem3HM.employee.Manager;
import org.Sem3HM.employee.Role;
import org.Sem3HM.impl.SalaryRaiserIMPL;
import org.Sem3HM.util.DateUtils;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = getEmployees();

        employees.sort((e1, e2) -> DateUtils.compareDates(e1.getDateOfBirth().toString(), e2.getDateOfBirth().toString()));

        employees.forEach(System.out::println);

        SalaryRaiserIMPL.raiseSalaryOnlyDevs(employees, 6000.5);

        employees.forEach(emp ->System.out.println(emp.getName() + ": " + emp.getSalary()));
    }

    private static List<Employee> getEmployees() {
        Employee emp1 = new Employee(1, "Konstantin", 25, LocalDate.of(1998, 10, 25), Role.SENIOR_DEVELOPER, 200000f);
        Employee emp2 = new Employee(2, "Konstantin1", 35, LocalDate.of(1989, 1, 5), Role.MANAGER, 250000f);
        Employee emp3 = new Employee(3, "Konstantin2", 15, LocalDate.of(2009, 10, 2), Role.JUNIOR_DEVELOPER, 100000f);
        Employee emp4 = new Employee(4, "Konstantin3", 22, LocalDate.of(2002, 5, 15), Role.MID_LEVEL_DEVELOPER, 180000f);
        Manager mngr1 = new Manager(5, "Ne Konstantin", 20, LocalDate.of(2003, 10, 24), Role.MANAGER, 300000f, 4);
        return Arrays.asList(emp1, emp2, emp3, emp4, mngr1);
    }
}
