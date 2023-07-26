package model;

import java.math.BigDecimal;

public class Employee {

    private String firstName;
    private String lastName;
    private int birthYear;
    private String id;
    private Department department;
    private ShiftEnum shiftType;
    private BigDecimal salary;

    public Employee(String firstName, String lastName, int birthYear, String id, Department department,
                    ShiftEnum shiftType, BigDecimal salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.id = id;
        this.department = department;
        this.shiftType = shiftType;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public ShiftEnum getShiftType() {
        return shiftType;
    }

    public void setShiftType(ShiftEnum shiftType) {
        this.shiftType = shiftType;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void raiseSalary(int percent){
        BigDecimal raise = this.salary.add(new BigDecimal(percent));
        this.salary = this.salary.add(raise);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthYear=" + birthYear +
                ", id='" + id + '\'' +
                ", department=" + department +
                ", shiftType=" + shiftType +
                ", salary=" + salary +
                '}';
    }
}
