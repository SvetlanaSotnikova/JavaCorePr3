package org.Sem4HM.util;


import org.Sem4HM.Employee;
import org.Sem4HM.Male;

import java.time.LocalDate;
import java.util.List;

public class GreetEmployee {
    private static final Holiday holiday = Holiday.getHolidayByDate(LocalDate.now());
    private static final String greeting = holiday.getDescription();

    public static void getGreet(List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            if (holiday == Holiday.NEW_YEAR ||
                    holiday == Holiday.INTERNATIONAL_WOMENS_DAY && employee.getMale() == Male.FEMALE ||
                    holiday == Holiday.DEFENDERS_DAY && employee.getMale() == Male.MALE ||
                    holiday == Holiday.NO_HOLIDAY) {
                System.out.println(greeting + " " + employee.getName());
            }
        }
    }
}
