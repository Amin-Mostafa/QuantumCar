package quantum_car;

public class Main {

    public static void main(String[] args) {

        CarFactory factory = new CarFactory();

        Car gasCar = factory.create(CarFactory.Type.GAS);
        gasCar.start();
        gasCar.accelerate();
        gasCar.accelerate();
        gasCar.brake();

        Car electricCar = factory.create(CarFactory.Type.ELECTRIC);
        electricCar.start();
        electricCar.accelerate();
        electricCar.brake();

        Car hybridCar = factory.create(CarFactory.Type.HYBRID);
        hybridCar.start();
        hybridCar.accelerate();
        hybridCar.accelerate();
        hybridCar.accelerate();

        factory.replace(hybridCar, CarFactory.Type.GAS);
        hybridCar.start();
        hybridCar.accelerate();

        System.out.println("done");
    }
}