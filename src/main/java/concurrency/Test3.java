package concurrency;

public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        Runnable thread = Test3::increaseCounter;

        Thread thread1 = new Thread(thread);
        Thread thread2 = new Thread(thread);
        System.out.println("Counter " + AtomicCounter.getCounter());

        thread1.start();
        thread2.start();
        System.out.println("Counter after start " + AtomicCounter.getCounter());

        thread1.join();
        thread2.join();
        System.out.println("Counter after join " + AtomicCounter.getCounter());

    }

    public static void increaseCounter() {
        while (AtomicCounter.getCounter() < 5000) {
            for (int i = 0; i < 10; i++) {
                 AtomicCounter.increment();
            }
            try {
                Thread.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
