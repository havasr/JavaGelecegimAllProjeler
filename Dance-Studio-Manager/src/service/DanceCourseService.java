package service;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class DanceCourseService {

    public DanceCourse createDanceCourse(String name, String address, String founder, String taxNumber, String taxOffice) {
        DanceCourse danceCourse = new DanceCourse();
        danceCourse.setName(name);
        danceCourse.setAddress(address);
        danceCourse.setFounder(founder);
        danceCourse.setTaxNumber(taxNumber);
        danceCourse.setTaxOffice(taxOffice);

        return danceCourse;
    }

    public void createBankAccountToDanceCourse(DanceCourse danceCourse, BankAccount bankAccount) {

        if (danceCourse.getBankAccountList() != null) {
            if (isExistBankAccount(danceCourse, bankAccount)) {
                addAmountToExistBankAccount(danceCourse, bankAccount);
            } else {
                danceCourse.getBankAccountList().add(bankAccount);
            }
        } else {
           List<BankAccount> bankAccountList = new ArrayList<>();
           bankAccountList.add(bankAccount);
           danceCourse.setBankAccountList(bankAccountList);
        }
    }

    private boolean isExistBankAccount(DanceCourse danceCourse, BankAccount bankAccount) {
        boolean isExist = false;

        for (BankAccount bankAccount1 : danceCourse.getBankAccountList()) {
            if (bankAccount1.getIbanNo().equals(bankAccount.getIbanNo())) {
                bankAccount1.setAmount(bankAccount1.getAmount().add(bankAccount.getAmount()));
                isExist = true;
                break;
            }
        }
        return isExist;
    }


    private void addAmountToExistBankAccount(DanceCourse danceCourse, BankAccount bankAccount) {
        for (BankAccount bankAccount1 : danceCourse.getBankAccountList()) {
            if (bankAccount1.getIbanNo().equals(bankAccount.getIbanNo())) {
                bankAccount1.setAmount(bankAccount1.getAmount().add(bankAccount.getAmount()));
                break;
            }
        }
    }

    public void addInstructorToDanceCourse(DanceCourse danceCourse, Instructor instructor) {
        BankAccountService bankAccountService = new BankAccountService();
        PaymentMovementService paymentMovementService = new PaymentMovementService();

        if (danceCourse.getBankAccountList() != null) {
            BankAccount bankAccount = bankAccountService.
                    getBankAccountWithEnoughMoney(danceCourse, instructor.getSalary());

            if (bankAccount != null) {
                bankAccount.setAmount(bankAccount.getAmount().subtract(instructor.getSalary()));
                PaymentMovement paymentMovement = paymentMovementService.
                        createPaymentMovement(bankAccount, instructor.getName() + " maaş ödemesi",
                                MovementType.OUTCOME, instructor.getSalary());

                addPaymentMovementToDanceCourse(danceCourse, paymentMovement);

                if (danceCourse.getInstructorList() != null) {
                    danceCourse.getInstructorList().add(instructor);
                } else {
                    danceCourse.setInstructorList(List.of(instructor));
                }

            } else {
                System.out.println("Yeterli bakiyesi olmadığı için öğretmen alımı yapılamaz.");
            }
        } else {
            System.out.println("Banka hessabı olmadığı için öğretmen alımı yapılamaz.");
        }


    }

    public void addPaymentMovementToDanceCourse(DanceCourse danceCourse, PaymentMovement paymentMovement) {
        if (danceCourse.getPaymentMovementList() != null) {
            danceCourse.getPaymentMovementList().add(paymentMovement);
        } else {
            danceCourse.setPaymentMovementList(List.of(paymentMovement));
        }
    }


    public  void addLectureToDanceCourse(DanceCourse danceCourse, Lecture lecture){
        if (danceCourse.getCourseList() != null) {
            danceCourse.getCourseList().add(lecture);
        } else {
            danceCourse.setCourseList(List.of(lecture));
        }
    }

  public void addStudentToCourse(DanceCourse danceCourse, Student student){
      BankAccountService bankAccountService = new BankAccountService();
      PaymentMovementService paymentMovementService = new PaymentMovementService();

      makePaymentFromStudentToCourse(danceCourse, student);

      if (danceCourse.getAllStudentList() != null) {
          danceCourse.getAllStudentList().add(student);
      } else {
          danceCourse.setAllStudentList(List.of(student));
      }

      }

public void makePaymentFromStudentToCourse(DanceCourse danceCourse, Student student){
    BankAccountService bankAccountService = new BankAccountService();
    PaymentMovementService paymentMovementService = new PaymentMovementService();

    BankAccount bankAccount = bankAccountService.getRandomBankAccount(danceCourse);
    bankAccount.setAmount(student.getConstractAmount());
    student.setIsPaid(true);
    PaymentMovement paymentMovement = paymentMovementService.createPaymentMovement(bankAccount, student.getName(),
            MovementType.INCOME, student.getConstractAmount());
}


}





/*
public void createBankAccountToDanceCourse(DanceCourse danceCourse, BankAccount bankAccount){

        if(danceCourse.getBankAccountList()!=null){
            danceCourse.getBankAccountList().add(bankAccount);
        } else {
           // List<BankAccount> bankAccountList = new ArrayList<>();
            // bankAccountList.add(bankAccount);
            danceCourse.setBankAccountList(List.of(bankAccount));
        }

}
 */




/*



public Team createTeam(String teamName, String nickname, String colors, String coach, String president, String stadiumName,
                       BigDecimal budget, Currency currency, String country){

  Team team = new Team();
  team.setName(teamName);
  team.setNickname(nickname);
  team.setColors(colors);
  team.setCoach(coach);
  team.setPresident(president);
  team.setStadiumName(stadiumName);
  team.setBudget(budget);
  team.setCurrency(currency);
  team.setCountry(country);

    return team;
}



 */