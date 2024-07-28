package org.Sem3HM.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.Sem3HM.impl.SalaryRaiserIMPL;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
public class Manager extends Employee implements SalaryRaiserIMPL {
    private int countOfWorkers;
    public Manager(int id, String name, int age, LocalDate dateOfBirth, Role role, double Salary, int countOfWorkers) {
        super(id, name, age, dateOfBirth, role, Salary);
        this.countOfWorkers = countOfWorkers;
    }
    @Override
    public String toString() {
        return super.toString() + ", CountOfWorkers=" + countOfWorkers;
    }
}
