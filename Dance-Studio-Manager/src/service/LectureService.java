package service;

import model.*;

import java.util.Set;

public class LectureService {
    public Lecture createCourse(String name, Branch branch, int capacity) {
        Lecture lecture = new Lecture();
        lecture.setName(name);
        lecture.setBranch(branch);
        lecture.setCapacity(capacity);

        return lecture;
    }

    public void addInstructorToCourse(Lecture lecture, Instructor instructor) {
        if (lecture.getInstructor() != null) {
            lecture.setInstructor(null);
        }
        lecture.setInstructor(instructor);
    }

    public void addScheduleToCourse(Lecture lecture, Set<LectureScheduleTime> lectureScheduleTimeSet) {
        if (lecture.getCourseScheduleTimeSet() != null) {
            lecture.getCourseScheduleTimeSet().addAll(lectureScheduleTimeSet);
        } else {
            lecture.setCourseScheduleTimeSet(lectureScheduleTimeSet);
        }

    }

    public void autoGenerateScheduleTimeForCourse(Lecture lecture, RepeatedTime repeatedTime, String time) {

    }

}
