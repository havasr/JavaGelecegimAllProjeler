package model;

import java.util.List;

public class DanceCourse {

    private String name;
    private String address;
    private String founder;
    private String taxNumber;
    private String taxOffice;

    private List<BankAccount> bankAccountList;

    private List<PaymentMovement> paymentMovementList;

    private List<Instructor> instructorList;

    private List<Lecture> lectureList;


    private List<Student> allStudentList;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getTaxOffice() {
        return taxOffice;
    }

    public void setTaxOffice(String taxOffice) {
        this.taxOffice = taxOffice;
    }

    public List<BankAccount> getBankAccountList() {
        return bankAccountList;
    }

    public void setBankAccountList(List<BankAccount> bankAccountList) {
        this.bankAccountList = bankAccountList;
    }

    public List<PaymentMovement> getPaymentMovementList() {
        return paymentMovementList;
    }

    public void setPaymentMovementList(List<PaymentMovement> paymentMovementList) {
        this.paymentMovementList = paymentMovementList;
    }

    public List<Instructor> getInstructorList() {
        return instructorList;
    }

    public void setInstructorList(List<Instructor> instructorList) {
        this.instructorList = instructorList;
    }

    public List<Lecture> getCourseList() {
        return lectureList;
    }

    public void setCourseList(List<Lecture> lectureList) {
        this.lectureList = lectureList;
    }

    public List<Lecture> getLectureList() {
        return lectureList;
    }

    public void setLectureList(List<Lecture> lectureList) {
        this.lectureList = lectureList;
    }

    public List<Student> getAllStudentList() {
        return allStudentList;
    }

    public void setAllStudentList(List<Student> allStudentList) {
        this.allStudentList = allStudentList;
    }

    @Override
    public String toString() {
        return "DanceCourse{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", founder='" + founder + '\'' +
                ", taxNumber='" + taxNumber + '\'' +
                ", taxOffice='" + taxOffice + '\'' +
                ", bankAccountList=" + bankAccountList +
                ", paymentMovementList=" + paymentMovementList +
                ", instructorList=" + instructorList +
                ", lectureList=" + lectureList +
                ", allStudentList=" + allStudentList +
                '}';
    }
}
