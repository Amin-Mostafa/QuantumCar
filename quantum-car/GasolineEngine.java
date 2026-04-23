package quantum_car;

public class GasEngine implements Engine {

    private int speed;
    private boolean running;

    public void start() {
        running = true;
        speed = 0;
    }

    public void stop() {
        running = false;
        speed = 0;
    }

    public void increase() {
        if (running) speed++;
    }

    public void decrease() {
        if (running && speed > 0) speed--;
    }

    public void adjustSpeed(int carSpeed) {
        if (!running) return;

        while (speed < carSpeed) increase();
        while (speed > carSpeed) decrease();
    }

    public int getSpeed() {
        return speed;
    }
}