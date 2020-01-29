package concurrency;

public class ConcurrencyAccessAdv {

    // Первая проблема - доступ к общим ресурсам из нескольких потоков.
    private static int counter;

    public static synchronized int getCounter() {
        return counter;
    }

    public static synchronized void increment() {
        counter++;
    }
}
