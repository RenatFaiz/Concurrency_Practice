package annimon;


public class LambdaThread {
    public static void main(String[] args) {
        Thread thread5 = new Thread(() -> {
            System.out.println("new Thread(() -> {})");
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(5);
        });
        thread5.start();

        Thread thread6 = new Thread(LambdaThread::threadMethod);
        Thread thread7 = new Thread(LambdaThread::threadMethod);
        thread6.start();
        thread7.start();
    }

    private static void threadMethod() {
        System.out.println("new Thread(Main::threadMethod)");
        try {
            Thread.sleep(100L);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        System.out.println(6);
    }

}
