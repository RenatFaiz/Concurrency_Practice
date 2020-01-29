package annimon;

public class CustomThread extends Thread {

    @Override
    public void run() {
        System.out.println("class CustomThread extends Thread { }");
        try {
            sleep(1000); // пауза в 1000 мс
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        System.out.println(1);
    }

    public static void main(String[] args) {
        CustomThread thread1 = new CustomThread();
        thread1.start();

    }
}


