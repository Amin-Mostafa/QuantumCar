package quantum_car;

public class HybridEngine implements Engine {

    private static final int SWITCH = 50;

    private GasEngine gas = new GasEngine();
    private ElectricEngine electric = new ElectricEngine();

    private boolean running;
    private int speed;

    public void start() {
        running = true;
        speed = 0;
        electric.start();
    }

    public void stop() {
        running = false;
        speed = 0;
        gas.stop();
        electric.stop();
    }

    public void increase() {
        if (!running) return;
        speed++;
    }

    public void decrease() {
        if (!running) return;
        if (speed > 0) speed--;
    }

    public void adjustSpeed(int carSpeed) {
        if (!running) return;

        speed = carSpeed;

        if (carSpeed < SWITCH) {
            gas.stop();
            electric.start();
            electric.adjustSpeed(carSpeed);
        } else {
            electric.stop();
            gas.start();
            gas.adjustSpeed(carSpeed);
        }
    }

    public int getSpeed() {
        return speed;
    }
}