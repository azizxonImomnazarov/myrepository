public class Task9 {
    public static void main(String[] args) {
        BlockingQueue blockingQueue = new BlockingQueue();
        Thread thread = new Thread(() -> {
            int i = 0;
            while (true) {
                System.out.println(i++);
                Runnable take = blockingQueue.take();
                if (take != null) {
                    new Thread(take).start();
                }
            }
        });
        thread.start();

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            final int index = i;
            blockingQueue.add(() -> System.out.println(index));
        }
    }
}
