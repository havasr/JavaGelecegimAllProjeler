package model;

import java.math.BigDecimal;

public class Intern extends Employee {
    public Intern(String firstName, String lastName, int birthYear, String id, Department department, ShiftEnum shiftType, BigDecimal salary) {
        super(firstName, lastName, birthYear, id, department, shiftType, salary);
    }
}
