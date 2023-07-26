package model;

public enum TypeEnum {
    FIRE("FIRE", "Rainy"),
    WATER("WATER", "Harsh Sunny"),
    GRASS("GRASS", "Stormy"),
    ELECTRIC("ELECTRIC", "Snowy"),
    WING("WING", "Rainy"),
    EARTH("EARTH", "Stormy");

    private String name;
    private String weaknessWeather;

    TypeEnum(String name, String weaknessWeather) {
        this.name = name;
        this.weaknessWeather = weaknessWeather;
    }
    public String getName() {
        return name;
    }

    public String getWeaknessWeather() {
        return weaknessWeather;
    }

    @Override
    public String toString() {
        return "TypeEnum{" +
                "name='" + name + '\'' +
                ", weaknessWeather='" + weaknessWeather + '\'' +
                '}';
    }
}
