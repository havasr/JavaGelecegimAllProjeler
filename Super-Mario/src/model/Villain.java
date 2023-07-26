package model;

public class Villain {
    private String name;
    private int damage;
    private boolean isMortal;
    private int health;
    private MoveTypeEnum moveType;

    private Coordinates coordinates;

    public Villain(String name, int damage, boolean isMortal, int health, MoveTypeEnum moveType, Coordinates coordinates) {
        this.name = name;
        this.damage = damage;
        this.isMortal = isMortal;
        this.health = health;
        this.moveType = moveType;
        this.coordinates = coordinates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isMortal() {
        return isMortal;
    }

    public void setMortal(boolean mortal) {
        isMortal = mortal;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public MoveTypeEnum getMoveType() {
        return moveType;
    }

    public void setMoveType(MoveTypeEnum moveType) {
        this.moveType = moveType;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Villain{" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", isMortal=" + isMortal +
                ", health=" + health +
                ", moveType=" + moveType +
                ", coordinates=" + coordinates +
                '}';
    }
}
