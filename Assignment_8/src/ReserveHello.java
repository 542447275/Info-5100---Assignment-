public class ReserveHello extends Thread{

    private int counter;
    ReserveHello(int counter) {
        super("Thread " + counter);
        this.counter = counter;
    }

    public void run() {
        counter++;
        if(counter <= 51) {
            ReserveHello rh = new ReserveHello(counter);
            rh.start();
            try {
                rh.join();
                System.out.println("Hello from "+ getName());
            } catch (Exception e) {
                System.out.println("Something wrong!");
            }
        }
    }

    public static void main (String args[]) {
        ReserveHello th1 = new ReserveHello(1);
        th1.start();
    }

}
