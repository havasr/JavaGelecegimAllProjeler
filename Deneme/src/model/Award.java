package model;

public class Award {

    private String name;
    private int year;


private AwardTypeEnum awardType;

private AwardCategory awardCategory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public AwardTypeEnum getAwardType() {
        return awardType;
    }

    public void setAwardType(AwardTypeEnum awardType) {
        this.awardType = awardType;
    }

    public AwardCategory getAwardCategory() {
        return awardCategory;
    }

    public void setAwardCategory(AwardCategory awardCategory) {
        this.awardCategory = awardCategory;
    }

    @Override
    public String toString() {
        return "Award{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", awardType=" + awardType +
                ", awardCategory=" + awardCategory +
                '}';
    }
}
