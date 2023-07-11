package service;

import model.BankAccount;
import model.DanceCourse;
import model.Instructor;
import model.PaymentMovement;

import java.awt.*;

public class DanceCourseService {

    public DanceCourse createDanceCourse(String name, String address, String founder, String taxNumber, String taxOffice){
        DanceCourse danceCourse = new DanceCourse();
        danceCourse.setName(name);
        danceCourse.setAddress(address);
        danceCourse.setFounder(founder);
        danceCourse.setTaxNumber(taxNumber);
        danceCourse.setTaxOffice(taxOffice);

        return danceCourse;
    }

}


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