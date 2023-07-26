package model;

public class Map {
    private String name;
    private int xLength;
    private int yLength;

    public Map(String name, int xLength, int yLength) {
        this.name = name;
        this.xLength = xLength;
        this.yLength = yLength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getxLength() {
        return xLength;
    }

    public void setxLength(int xLength) {
        this.xLength = xLength;
    }

    public int getyLength() {
        return yLength;
    }

    public void setyLength(int yLength) {
        this.yLength = yLength;
    }

    @Override
    public String toString() {
        return "Map{" +
                "name='" + name + '\'' +
                ", xLength=" + xLength +
                ", yLength=" + yLength +
                '}';
    }
}
