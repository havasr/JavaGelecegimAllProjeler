package model;

public class Car {
    /*
    model
    otomatik vites
    hatchback?
    max hız
    color
    0-100 süresi
    motor
    yakıt tipi - elektrik dizel benzin
    fiyat

    increaseSpeed -> saatte 30kmh arttır. Ferraride 60 kmh arttır.
    decreaseSpeed -> defaultta 10kmh, ferraride direkt 0
     */
    private String model;
    private boolean isAutomatic;
    private CaseTypeEnum caseType;
    private ColorEnum color;
    private int fromZeroToHundredSec;
    private Engine engine;
    private double speed;
    private int maxSpeed;
    private double increaseSpeed;


    public Car(Engine engine) {
        this.engine = engine;
        this.increaseSpeed = engine.getHorsePower()*(0.10);
    }

    public Car(String model, boolean isAutomatic, CaseTypeEnum caseType, ColorEnum color, int fromZeroToHundredSec, Engine engine) {
        this.model = model;
        this.isAutomatic = isAutomatic;
        this.caseType = caseType;
        this.color = color;
        this.fromZeroToHundredSec = fromZeroToHundredSec;
        this.engine = engine;
        this.increaseSpeed = engine.getHorsePower()*(0.05);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isAutomatic() {
        return isAutomatic;
    }

    public void setAutomatic(boolean automatic) {
        isAutomatic = automatic;
    }

    public CaseTypeEnum getCaseType() {
        return caseType;
    }

    public void setCaseType(CaseTypeEnum caseType) {
        this.caseType = caseType;
    }

    public ColorEnum getColor() {
        return color;
    }

    public void setColor(ColorEnum color) {
        this.color = color;
    }

    public double getIncreaseSpeed() {
        return increaseSpeed;
    }

    public void setIncreaseSpeed(double increaseSpeed) {
        this.increaseSpeed = increaseSpeed;
    }

    public int getFromZeroToHundredSec() {
        return fromZeroToHundredSec;
    }

    public void setFromZeroToHundredSec(int fromZeroToHundredSec) {
        this.fromZeroToHundredSec = fromZeroToHundredSec;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", isAutomatic=" + isAutomatic +
                ", caseType=" + caseType +
                ", color=" + color +
                ", fromZeroToHundredSec=" + fromZeroToHundredSec +
                ", engine=" + engine +
                ", speed=" + speed +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    public void useGas() {
        if (this.getSpeed() + 30 <= this.maxSpeed) {
            this.setSpeed(this.getSpeed() + 30);
        } else {
            this.setSpeed(this.maxSpeed);
        }
    }
    public void useGasAccordingToHorsePower(){
        if (this.getSpeed() + this.increaseSpeed <= this.maxSpeed) {
            this.setSpeed(this.getSpeed() + this.increaseSpeed);
        } else {
            this.setSpeed(this.maxSpeed);
        }
    }

    public void useBreak() {
        if (this.getSpeed() - 10 >= 0) {
            this.setSpeed(this.getSpeed() - 10);
        } else {
            this.setSpeed(0);
        }
    }
}
