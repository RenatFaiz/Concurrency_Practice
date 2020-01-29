package concurrency;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = Test2::increaseCounter;

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        System.out.println("Counter: " + ConcurrencyAccessAdv.getCounter());

//        thread1.start();
        thread1.start();
        thread2.start();
        System.out.println("Counter: " + ConcurrencyAccessAdv.getCounter());

        thread1.join();
        thread2.join();
        System.out.println("Counter: " + ConcurrencyAccessAdv.getCounter());
    }

    private static void increaseCounter() {
        while (ConcurrencyAccessAdv.getCounter() < 5000) {
            for (int i = 0; i < 10; i++) {
                ConcurrencyAccessAdv.increment();
            }
            try {
                Thread.sleep(1L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
