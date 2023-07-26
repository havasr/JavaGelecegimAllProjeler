package model;

import java.math.BigDecimal;

public class Cleaner extends Employee{
    public Cleaner(String firstName, String lastName, int birthYear, String id, Department department, ShiftEnum shiftType, BigDecimal salary) {
        super(firstName, lastName, birthYear, id, department, shiftType, salary);
    }


}
