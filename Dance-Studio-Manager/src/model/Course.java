package model;

import java.util.List;

public class Course {

    private String name;

    private Instructor instructor;

    private Branch branch;

    private int capacity;

    private List<CourseScheduleTime> courseScheduleTimeList;

    private List<Student> studentList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<CourseScheduleTime> getCourseScheduleTimeList() {
        return courseScheduleTimeList;
    }

    public void setCourseScheduleTimeList(List<CourseScheduleTime> courseScheduleTimeList) {
        this.courseScheduleTimeList = courseScheduleTimeList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
