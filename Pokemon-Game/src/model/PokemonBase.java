package model;

public class PokemonBase {

    private int id;
    private String name;
    private int health;
    private int damage;
    private TypeEnum type;
    private SpecialPowerBase specialPowerBase;

    public PokemonBase(int id, String name, int health, int damage, TypeEnum type, SpecialPowerBase specialPowerBase) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.type = type;
        this.specialPowerBase = specialPowerBase;
    }

    public PokemonBase() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public SpecialPowerBase getSpecialPower() {
        return specialPowerBase;
    }

    public void setSpecialPower(SpecialPowerBase specialPowerBase) {
        this.specialPowerBase = specialPowerBase;
    }

    public int specialAttack(){
        if (this.specialPowerBase.getRemainRight()>0){
            this.specialPowerBase.setRemainRight(this.specialPowerBase.getRemainRight()-1);
            return this.damage + this.specialPowerBase.getExtraDamage();
        } else {
            System.out.println("You cannot use special power.");
            return 0;
        }
    }

    @Override
    public String toString() {
        return "- Name: " + name + "\n" +
                "Health: " + health +
                ", Damage: " + damage +
                ", Special Power: " + specialPowerBase +
                ", Type: " + type;
    }
}
