package model;

public class Engine {
    private int cc;
    private int horsePower;
    private FuelTypeEnum fuelType;

    public Engine(int cc, int horsePower, FuelTypeEnum fuelType) {
        this.cc = cc;
        this.horsePower = horsePower;
        this.fuelType = fuelType;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public FuelTypeEnum getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelTypeEnum fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "cc=" + cc +
                ", horsePower=" + horsePower +
                ", fuelType=" + fuelType +
                '}';
    }
}
