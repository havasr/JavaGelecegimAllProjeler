package model;

import java.math.BigDecimal;
import java.util.Date;

public class Student {

    private String name;
    private int age;
    private Sex sex;
    private boolean isPaid = Boolean.FALSE;
    private BigDecimal constractAmount;
    private Date startDate;
    private Date endDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean paid) {
        isPaid = paid;
    }

    public BigDecimal getConstractAmount() {
        return constractAmount;
    }

    public void setConstractAmount(BigDecimal constractAmount) {
        this.constractAmount = constractAmount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", isPaid=" + isPaid +
                ", constractAmount=" + constractAmount +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
