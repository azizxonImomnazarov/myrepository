public class Printer {
    private final Object monitor = new Object();
    public void printA() {
        synchronized (monitor) {
            System.out.println("A");
            monitor.notify();

        }
    }

    public void printB() {
        synchronized (monitor) {
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B");
            notify();
        }
    }

    public void printC() {
        synchronized (monitor) {
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("C");
        }
    }
}
