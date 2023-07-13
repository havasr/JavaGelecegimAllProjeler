package model;

import java.util.List;
import java.util.Set;

public class Course {

    private String name;

    private Instructor instructor;

    private Branch branch;

    private int capacity;

    private Set<CourseScheduleTime> courseScheduleTimeSet;

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

    public Set<CourseScheduleTime> getCourseScheduleTimeSet() {
        return courseScheduleTimeSet;
    }

    public void setCourseScheduleTimeSet(Set<CourseScheduleTime> courseScheduleTimeSet) {
        this.courseScheduleTimeSet = courseScheduleTimeSet;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", instructor=" + instructor +
                ", branch=" + branch +
                ", capacity=" + capacity +
                ", courseScheduleTimeSet=" + courseScheduleTimeSet +
                ", studentList=" + studentList +
                '}';
    }
}
