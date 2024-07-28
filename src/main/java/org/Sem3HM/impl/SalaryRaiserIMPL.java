package org.Sem3HM.impl;

import org.Sem3HM.employee.Employee;
import org.Sem3HM.employee.Manager;
import org.Sem3HM.employee.Role;

import java.util.List;

public interface SalaryRaiserIMPL {
    static void raiseSalaryOnlyDevs(List<Employee> employees, double increment) {
        for (Employee employee : employees) {
            if (!(employee instanceof Manager) && (employee.getRole() != Role.MANAGER)) {
                employee.setSalary(employee.getSalary() + increment);
            }
        }
    }
}
