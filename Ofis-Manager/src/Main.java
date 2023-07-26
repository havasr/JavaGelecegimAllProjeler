import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        Department department1 = new Department("Marketing")

        Employee seller = new Seller("Ahmet", "Demir", 1995, "101", department1,
                ShiftEnum.DAY_TIME, new BigDecimal(12000));

        Employee engineer = new Engineer("Sena", "Sel", 1992, "102", department1,
                ShiftEnum.DAY_TIME, new BigDecimal(25000));
        Employee intern = new Intern("Mehmet", "Koray", 1999, "103", department1,
                ShiftEnum.DAY_TIME, new BigDecimal(11000));

        Employee cleaner = new Cleaner("Mustafa", "Kaba", 1989, "104", department1,
                ShiftEnum.NIGHT_TIME, new BigDecimal(11000));

        employeeArrayList.add(seller);
        employeeArrayList.add(engineer);
        employeeArrayList.add(intern);
        employeeArrayList.add(cleaner);

        for (Employee employee : employeeArrayList) {
            if (employee instanceof Engineer) {
                employee.raiseSalary(30);
            } else if (employee instanceof Seller) {
                employee.raiseSalary(20);
            } else if (employee instanceof Cleaner) {
                employee.raiseSalary(12);
            } else if(employee instanceof Intern){
                employee.raiseSalary(10);
            } else {
                employee.raiseSalary(5);
            }

        }

    }
}