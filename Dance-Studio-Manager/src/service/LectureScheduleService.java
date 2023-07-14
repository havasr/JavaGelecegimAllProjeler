package service;

import model.LectureScheduleTime;
import model.Day;

public class LectureScheduleService {
    public LectureScheduleTime createCourseSchedule(Day day, String time){
        LectureScheduleTime lectureScheduleTime = new LectureScheduleTime();
        lectureScheduleTime.setDay(day);
        lectureScheduleTime.setTime(time);

        return lectureScheduleTime;
    }
}
