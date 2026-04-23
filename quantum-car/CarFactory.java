package quantum_car;

public class CarFactory {

    public enum Type {
        GAS, ELECTRIC, HYBRID
    }

    public Car create(Type type) {
        Engine engine = createEngine(type);
        return new Car(engine);
    }

    public void replace(Car car, Type type) {
        car.replaceEngine(createEngine(type));
    }

    private Engine createEngine(Type type) {
        switch (type) {
            case GAS:
                return new GasEngine();
            case ELECTRIC:
                return new ElectricEngine();
            case HYBRID:
                return new HybridEngine();
            default:
                throw new RuntimeException("unknown type");
        }
    }
}