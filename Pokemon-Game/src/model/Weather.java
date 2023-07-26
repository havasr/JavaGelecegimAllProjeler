package model;

public class Weather {
    private String name;
    private int effect;

    public Weather(String name, int effect) {
        this.name = name;
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEffect() {
        return effect;
    }

    public void setEffect(int effect) {
        this.effect = effect;
    }

    @Override
    public String toString() {
        return name;
    }
}
