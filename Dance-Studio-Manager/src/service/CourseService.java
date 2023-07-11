package service;

import model.Branch;
import model.Course;
import model.Instructor;

public class CourseService {
    public Course createCourse(String name, Instructor instructor, Branch branch, int capacity){
        Course course = new Course();
        course.setName(name);
        course.setInstructor(instructor);
        course.setBranch(branch);
        course.setCapacity(capacity);

        return course;
    }
}
