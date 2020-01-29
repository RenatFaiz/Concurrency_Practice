package annimon;

public class CustomRunnable implements Runnable {


    @Override
    public void run() {

        System.out.println("class CustomRunnable implements Runnable { }");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(2);
    }


    public static void main(String[] args) {
        Thread thread2 = new Thread(new CustomRunnable());
        thread2.start();

        Thread thread3 = new Thread() {
            @Override
            public void run() {
                System.out.println("new Thread() {} anonim ");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(3);
            }
        };
        thread3.start();

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("new Thread(new Runnable() { })");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(4);
            }
        });
        thread4.start();
    }
}
