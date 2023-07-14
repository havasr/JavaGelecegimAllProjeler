import model.AwardCategory;
import model.AwardTypeEnum;
import model.Team;
import service.TeamService;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        TeamService teamService = new TeamService();

        Team team = teamService.createTeam("Galatasaray", "GS", "yellom-red", "Fatih Terim",
                "Dursun Ozbek", "Nef Arena", new BigDecimal(10000000),
                "Dolar", "Turkey");

        System.out.println(team.toString());
        teamService.addAwardToTeam(team, "Championship Cup", 2023, AwardTypeEnum.CUP,
                AwardCategory.INTERNATIONAL);

        System.out.println(team.toString());

        System.out.println(team.toString());
        teamService.addAwardToTeam(team, "League Cup", 2023, AwardTypeEnum.CUP,
                AwardCategory.NATIONAL);

        System.out.println(team.toString());

    }
}

/*  hasNext() - input.nextInt();
Scanner yaygin kullanilmayan bir sey

enum

static sinif olarak ulasabiliyorsun ama instance olusturup obje olunca obje uzerinden ulasabiliyorsun


Zate fonskiyonda bir obje olusturuluyor tekrar mainde create etmeye gerek yok Team team = new Team()

 if (team.getAwards()!=null){
   team.getAwards().add(award);
 } else {
   List<Award> awardList = new ArrayList<>();
   awardList.add(award);
   team.setAwards(awardList);
 }

 Null sa yeni liste olusturuyor degilse ustune ekliyor


 Referansini gostermeyim kendisini gostermesini istiyorsan to String()
 */