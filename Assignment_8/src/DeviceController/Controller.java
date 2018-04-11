package DeviceController;

public class Controller extends Thread {
    private Device device;
    private Sensor heat;
    private Sensor pressure;

    Controller(Device device, Sensor heat, Sensor pressure){
        this.device = device;
        this.heat = heat;
        this.pressure = pressure;
    }

    public void run(){
//        heat.start();
//        pressure.start();
//        try {
//            heat.join();
//            pressure.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        device.startup();
        while (heat.getValue() <= 70 && pressure.getValue() <= 100) {
            heat.run();
            try {
                Thread.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pressure.run();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("heat -> " + String.format("%.2f",heat.getValue()) + " , pressure -> " + String.format("%.2f",pressure.getValue()));
            if (heat.getValue() > 70 || pressure.getValue() > 100) {
                device.shutdown();
                System.out.println("Device shutting down due to maintenance");
            }

        }
    }
}
