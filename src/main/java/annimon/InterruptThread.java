package annimon;

public class InterruptThread implements Runnable {

    private boolean isRunning;

    public void stop() {
        isRunning = false;
    }

    @Override
    public void run() {
        isRunning = true;
        String name = Thread.currentThread().getName();
        System.out.printf("Thread %s started\n", name);

        int counter = 0;
        while (isRunning) {
            System.out.printf("Thread %s with counter = %d\n", name, counter);
            counter++;

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                System.out.printf("Thread %s interrupted\n", name);
                Thread.currentThread().interrupt();
            }
            stop();
            System.out.printf("Thread %s stopped\n", name);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        // first Thread
        Thread threadInt = new Thread(new InterruptThread(), "first");
        threadInt.start();



        // second Thread
        Thread threadInt2 = new Thread() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                System.out.printf("Thread %s started\n", name);

                int counter = 0;
                while (!Thread.interrupted()) {
                    System.out.printf("Thread %s with counter = %d\n", name, counter);
                    counter++;
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        System.out.printf("Thread %s interrupted\n", name);
                        Thread.currentThread().interrupt();
                    }
                }
            }
        };

        threadInt2.setName("second");
        threadInt2.start();
        Thread.sleep(10000L);
        threadInt2.interrupt();
    }
}
