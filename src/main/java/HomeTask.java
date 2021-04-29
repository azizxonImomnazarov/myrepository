import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HomeTask {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        long t1 = System.currentTimeMillis();
        executorService.execute(() -> {
            int count = 0;
            for (int i = 0; i <= 1000000; i++) {
                if (i % 2 == 0) {
                    count += i;
                }
            }
            System.out.println(count + " - 1");
            countDownLatch.countDown();
        });
        executorService.execute(() -> {
            long count = 0;
            for (int i = 0; i <= 1000000; i++) {
                if (i % 7 == 0) {
                    count += i;
                }
            }
            System.out.println(count + " - 2");
            countDownLatch.countDown();
        });
        executorService.execute(() -> {
            List<Integer> list = new ArrayList<>(1000);
            for (int i = 0; i < 1000; i++) {
                list.add((int)(1000*Math.random()));
            }
            list.forEach(l -> {
                if (l % 2 == 0)
                    System.out.println(l + " - 3");
            });
            countDownLatch.countDown();
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        long t2 = System.currentTimeMillis();
        System.out.println("All threads finish " + (t2 - t1));
    }
}
