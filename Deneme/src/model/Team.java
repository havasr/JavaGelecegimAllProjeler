package model;

import java.math.BigDecimal;
import java.util.List;

public class Team {

    private String name;
    private String nickname;
    private String colors;
    private String coach;
    private String president;
    private String stadiumName;
    private BigDecimal budget;
    private String currency;
    private String country;
    private List<Award> awards;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Award> getAwards() {
        return awards;
    }

    public void setAwards(List<Award> awards) {
        this.awards = awards;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", colors='" + colors + '\'' +
                ", coach='" + coach + '\'' +
                ", president='" + president + '\'' +
                ", stadiumName='" + stadiumName + '\'' +
                ", budget=" + budget +
                ", currency='" + currency + '\'' +
                ", country='" + country + '\'' +
                ", awards=" + awards +
                '}';
    }
}
