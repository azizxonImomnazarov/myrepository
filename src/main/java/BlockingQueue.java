import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
    private Queue<Runnable> blockingQueue = new LinkedList<>();
    private final Object monitor = new Object();

    public void add(Runnable runnable) {
        synchronized (monitor) {
            blockingQueue.add(runnable);
            monitor.notify();
        }
    }

    public Runnable take() {
        synchronized (monitor) {
            if (blockingQueue.isEmpty())
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            return blockingQueue.poll();
        }
    }
}
