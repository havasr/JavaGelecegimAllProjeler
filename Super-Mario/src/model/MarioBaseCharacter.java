package model;

public class MarioBaseCharacter {
    private String name;
    private int health;
    private GrowthCycleEnum growthCycleEnum;
    private int length;
    private Coordinates coordinates;
    private boolean immortality;
    private int remainingLife;

    public MarioBaseCharacter(String name, int health, GrowthCycleEnum growthCycleEnum, int length,
                              Coordinates coordinates, boolean immortality, int remainingLife) {
        this.name = name;
        this.health = health;
        this.growthCycleEnum = growthCycleEnum;
        this.length = length;
        this.coordinates = coordinates;
        this.immortality = immortality;
        this.remainingLife = remainingLife;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public GrowthCycleEnum getGrowthCycleEnum() {
        return growthCycleEnum;
    }

    public void setGrowthCycleEnum(GrowthCycleEnum growthCycleEnum) {
        this.growthCycleEnum = growthCycleEnum;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public boolean isImmortality() {
        return immortality;
    }

    public void setImmortality(boolean immortality) {
        this.immortality = immortality;
    }

    public int getRemainingLife() {
        return remainingLife;
    }

    public void setRemainingLife(int remainingLife) {
        this.remainingLife = remainingLife;
    }

    @Override
    public String toString() {
        return "MarioBaseCharacter{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", growthCycleEnum=" + growthCycleEnum +
                ", length=" + length +
                ", coordinates=" + coordinates +
                ", immortality=" + immortality +
                ", remainingLife=" + remainingLife +
                '}';
    }
}
