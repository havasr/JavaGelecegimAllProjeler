package service;

import model.CourseScheduleTime;
import model.Day;

public class CourseScheduleService {
    public CourseScheduleTime createCourseSchedule(Day day, String time){
        CourseScheduleTime courseScheduleTime = new CourseScheduleTime();
        courseScheduleTime.setDay(day);
        courseScheduleTime.setTime(time);

        return courseScheduleTime;
    }
}
