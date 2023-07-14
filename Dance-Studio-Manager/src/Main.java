import model.*;
import service.*;

import java.math.BigDecimal;
import java.util.*;


public class Main {


    public static void main(String[] args) throws Exception {


        DanceCourseService danceCourseService = new DanceCourseService();
        BankAccountService bankAccountService = new BankAccountService();
        BranchService branchService = new BranchService();
        InstructorService instructorService = new InstructorService();
        LectureService lectureService = new LectureService();
        LectureScheduleService lectureScheduleService = new LectureScheduleService();

        List<Branch> branchList = InitialDataService.loadInitialDataForBranch();

        System.out.println(branchList);


        DanceCourse danceCourse = danceCourseService.createDanceCourse("Özçakır Dance School", "Eskişehir",
                "Tuğçe Özçakır", "98728998789", "Eskişehir");

        System.out.println(danceCourse.toString());

        BankAccount bankAccount = bankAccountService.createBankAccount("T.C. ZİRAAT BANKASI",
                "ÖZÇAKIR LİMİTED ŞİRKETİ", "TR1200002902343", new BigDecimal(100000));

        danceCourseService.createBankAccountToDanceCourse(danceCourse, bankAccount);
        System.out.println(danceCourse);

        BankAccount bankAccount1 = bankAccountService.createBankAccount("T.C. ZİRAAT BANKASI",
                "ÖZÇAKIR LİMİTED ŞİRKETİ", "TR1200002902343", new BigDecimal(200000));


        danceCourseService.createBankAccountToDanceCourse(danceCourse, bankAccount1);
        System.out.println(danceCourse);

        branchService.createBranchToBranchPool(branchList, "Halayy");


        System.out.println(branchList);

        Instructor instructor = instructorService.createInstructor("Lilo Stitch", 22, Sex.FEMALE,
                new BigDecimal(12300));

        danceCourseService.addInstructorToDanceCourse(danceCourse, instructor);

        System.out.println(danceCourse);

        Lecture lecture = lectureService.createCourse("Bachata", branchList.get(0), 10);

        LectureScheduleTime lectureScheduleTime = lectureScheduleService.
                createCourseSchedule(Day.MONDAY, "12.00-14.00");

        Set<LectureScheduleTime> lectureScheduleTimeSet = new HashSet<>();
        lectureScheduleTimeSet.add(lectureScheduleTime);

        lectureService.addScheduleToCourse(lecture, lectureScheduleTimeSet);

        danceCourseService.addCourseToDanceCourse(danceCourse, lecture);

        System.out.println(danceCourse);


    }

}