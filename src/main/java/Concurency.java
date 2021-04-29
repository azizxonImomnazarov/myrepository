public class Concurency {

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        int limit = 10000000;
        Counter counter = new Counter();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < limit; i++) {
                counter.inc1();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < limit; i++) {
                counter.dec1();
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.getValue1());
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }
}
