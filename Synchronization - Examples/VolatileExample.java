
public class VolatileExample {
    private volatile int counter = 0;
    private class CounterIncrementer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                counter++;
                System.out.println(counter);

            }
        }
    }

    public void startThreads() {
        Thread thread1 = new Thread(new CounterIncrementer());
        Thread thread2 = new Thread(new CounterIncrementer());

        thread1.start();
        thread2.start();
        System.out.println("Bye");

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter value: " + counter);
    }

    public static void main(String[] args) {
        VolatileExample example = new VolatileExample();
        example.startThreads();
    }
}