package quantum_car;

public class Car {

    private static final int MAX_SPEED = 200;
    private static final int STEP = 20;

    private Engine engine;
    private int speed;
    private boolean running;

    public Car(Engine engine) {
        this.engine = engine;
        this.speed = 0;
        this.running = false;
    }

    public void start() {
        if (running) return;

        running = true;
        speed = 0;
        engine.start();
        engine.adjustSpeed(speed);
    }

    public void stop() {
        if (!running) return;

        if (speed != 0) {
            while (speed > 0) {
                brake();
            }
        }

        engine.stop();
        running = false;
    }

    public void accelerate() {
        if (!running) return;

        if (speed >= MAX_SPEED) return;

        speed += STEP;
        if (speed > MAX_SPEED) speed = MAX_SPEED;

        engine.adjustSpeed(speed);
    }

    public void brake() {
        if (!running) return;

        if (speed <= 0) return;

        speed -= STEP;
        if (speed < 0) speed = 0;

        engine.adjustSpeed(speed);
    }

    public void replaceEngine(Engine newEngine) {
        if (running) {
            engine.stop();
            running = false;
            speed = 0;
        }

        this.engine = newEngine;
    }

    public int getSpeed() {
        return speed;
    }
}