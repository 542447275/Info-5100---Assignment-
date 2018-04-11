package DeviceController;

import java.util.Random;

public class Sensor extends Thread {
    private final Device device;

    private double value;

    Sensor(Device device) {
        this.device = device;
    }

    public double getValue() {
        return value;
    }

    public void updateValue() {
        this.value += 0.001 * ((int)(Math.random()*10000)); // you check with other values here
    }

    public void run() {
        updateValue();
    }

}
