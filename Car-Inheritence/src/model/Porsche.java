package model;

public class Porsche extends Car{
    public Porsche(Engine engine) {
        super(engine);
    }

    public Porsche(String model, boolean isAutomatic, CaseTypeEnum caseType, ColorEnum color, int fromZeroToHundredSec, Engine engine) {
        super(model, isAutomatic, caseType, color, fromZeroToHundredSec, engine);
    }
}
