package concurrency;

public class ConcurrencyAccess {

    // Первая проблема - доступ к общим ресурсам из нескольких потоков.
    private static int counter;

    public static int getCounter() {
        return counter;
    }

    public static void increment() {
        counter++;
    }
}
