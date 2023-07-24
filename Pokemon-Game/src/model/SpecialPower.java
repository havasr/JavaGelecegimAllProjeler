package model;

public class SpecialPower {
    private String name;
    private int extraDamage;
    private int remainRight;

    public SpecialPower(String name, int extraDamage, int remainRight) {
        this.name = name;
        this.extraDamage = extraDamage;
        this.remainRight = remainRight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExtraDamage() {
        return extraDamage;
    }

    public void setExtraDamage(int extraDamage) {
        this.extraDamage = extraDamage;
    }

    public int getRemainRight() {
        return remainRight;
    }

    public void setRemainRight(int remainRight) {
        this.remainRight = remainRight;
    }

    @Override
    public String toString() {
        return "SpecialPower{" +
                "name='" + name + '\'' +
                ", extraDamage=" + extraDamage +
                ", remainRight=" + remainRight +
                '}';
    }
}
