package model;

import java.util.List;

public class Player {
    private String name;
    private String surname;
    private int kitNumber;
    private int birthYear;
    private String position;
    private List<Transfer> transferHistory;
    private List<Team> teamList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getKitNumber() {
        return kitNumber;
    }

    public void setKitNumber(int kitNumber) {
        this.kitNumber = kitNumber;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Transfer> getTransferHistory() {
        return transferHistory;
    }

    public void setTransferHistory(List<Transfer> transferHistory) {
        this.transferHistory = transferHistory;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }
}
