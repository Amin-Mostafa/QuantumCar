package quantum_car;

public interface Engine {
    void start();
    void stop();
    void increase();
    void decrease();
    void adjustSpeed(int carSpeed);
    int getSpeed();
}