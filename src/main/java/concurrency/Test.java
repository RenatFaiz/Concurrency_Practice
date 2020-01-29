package concurrency;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = Test::printCounter;

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        System.out.println("Counter: " + ConcurrencyAccess.getCounter());

        thread1.start();
        thread2.start();
        System.out.println("Counter: " + ConcurrencyAccess.getCounter());

        thread1.join();
        thread2.join();
        System.out.println("Counter: " + ConcurrencyAccess.getCounter());

    }

    private static void printCounter() {
        while (ConcurrencyAccess.getCounter() < 5000) {
            synchronized (ConcurrencyAccess.class) {
                for (int i = 0; i < 10; i++) {
                    ConcurrencyAccess.increment();
                }
            }
            try {
                Thread.sleep(1L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
