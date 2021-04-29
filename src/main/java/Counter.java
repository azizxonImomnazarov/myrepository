import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

    private AtomicInteger count1 = new AtomicInteger();

    public void inc1() {
        count1.incrementAndGet();
    }

    public void dec1() {
        count1.decrementAndGet();
    }

    public int getValue1() {
        return count1.get();
    }
}
