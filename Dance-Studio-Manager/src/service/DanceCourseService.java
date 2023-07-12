package service;

import model.BankAccount;
import model.DanceCourse;
import model.Instructor;
import model.PaymentMovement;

import java.awt.*;
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
            // List<BankAccount> bankAccountList = new ArrayList<>();
            // bankAccountList.add(bankAccount);
            danceCourse.setBankAccountList(List.of(bankAccount));
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