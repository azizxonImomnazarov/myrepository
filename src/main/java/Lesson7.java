import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lesson7 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            final int index = i;
            executorService.execute(() -> {
                System.out.println("Stated " + index);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished " + index);
                countDownLatch.countDown();
            });
        }
        executorService.shutdown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All threads finished");
    }
}
