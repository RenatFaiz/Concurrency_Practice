package annimon;

public class InterruptThreadAdv implements Runnable {

    private volatile boolean isRunning;

    public void stop() {
        isRunning = false;
    }

    @Override
    public void run() {
        isRunning = true;
        String name = Thread.currentThread().getName();
        System.out.printf("Thread %s started\n", name);

        int counter = 0;
        try {
            while (!Thread.interrupted() & counter < 6) {
                System.out.printf("Thread %s with counter = %d\n", name, counter);
                counter++;
                Thread.sleep(1L);
            }
        } catch (InterruptedException e) {
            System.out.printf("Thread %s interrupted\n", name);
            Thread.currentThread().interrupt();
        }
//        stop();
//        System.out.printf("Thread %s stopped\n", name);
    }


    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new InterruptThreadAdv());
        Thread thread2 = new Thread(new InterruptThreadAdv());
        Thread thread3 = new Thread(new InterruptThreadAdv());

        thread1.start();
        thread2.start();
        thread3.start();

        Thread.sleep(1000L);

        thread1.interrupt();
        thread2.interrupt();
        thread3.interrupt();

    }
}
