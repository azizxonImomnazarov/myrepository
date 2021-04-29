import java.util.concurrent.*;

public class Task8 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2,r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        });
        executorService.execute(() -> {
            try {
                while (true) {
                    Thread.sleep(100);
                    System.out.print(".");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Future<String> submit = executorService.submit(() -> {
            Thread.sleep(5000);
            return "Azizxon";
        });
        try {
            System.out.println(submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
