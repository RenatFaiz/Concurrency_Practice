package concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    private static final AtomicInteger counter = new AtomicInteger();

    public static int getCounter() {
        return counter.get();
    }

    public static void increment() {
        counter.incrementAndGet();
    }

}
