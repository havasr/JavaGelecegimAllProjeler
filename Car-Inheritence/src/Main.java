import model.*;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine(5000, 350, FuelTypeEnum.OIL);
        Ferrari ferrari = new Ferrari(engine);
        ferrari.setAutomatic(true);
        ferrari.setColor(ColorEnum.RED);
        ferrari.setModel("Ferrari");
        ferrari.setCaseType(CaseTypeEnum.HATCHBACK);
        ferrari.setFromZeroToHundredSec(3);
        ferrari.setSpeed(0);
        ferrari.setMaxSpeed(250);

        ferrari.useGas();
        System.out.println(ferrari);
        ferrari.useGas();
        System.out.println(ferrari);
        ferrari.useBreak();
        System.out.println(ferrari);


        Engine engine2 = new Engine(4000, 300, FuelTypeEnum.OIL);
        Porsche porsche = new Porsche(engine2);
        porsche.setAutomatic(true);
        porsche.setColor(ColorEnum.WHITE);
        porsche.setModel("Porsche");
        porsche.setCaseType(CaseTypeEnum.HATCHBACK);
        porsche.setFromZeroToHundredSec(4);
        porsche.setSpeed(0);
        porsche.setMaxSpeed(220);


        porsche.useGas();
        System.out.println(porsche);
        porsche.useGas();
        System.out.println(porsche);
        porsche.useBreak();
        System.out.println(porsche);

        ferrari.useGasAccordingToHorsePower();
        System.out.println(ferrari.getSpeed());
        ferrari.useBreak();
        ferrari.useGas();
        System.out.println(ferrari.getSpeed());
    }

}