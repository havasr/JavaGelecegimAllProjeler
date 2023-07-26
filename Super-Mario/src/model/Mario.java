package model;

public class Mario extends MarioBaseCharacter{
    public Mario(String name, int health, GrowthCycleEnum growthCycleEnum, int length, Coordinates coordinates, boolean immortality, int remainingLife) {
        super(name, health, growthCycleEnum, length, coordinates, immortality, remainingLife);
    }
}
