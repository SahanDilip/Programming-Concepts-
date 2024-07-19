public class VolatileExample2 {
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        Thread writerThread = new WriterThread();
        Thread readerThread = new ReaderThread();

        writerThread.start();
        readerThread.start();
    }

    static class WriterThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1000); // Simulating some work
                flag = true; // Writing to the volatile variable
                System.out.println("Writer thread has updated the flag.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!flag) { // Reading the volatile variable
                System.out.println("Reader thread is waiting for the flag update.");
            }
            System.out.println("Reader thread detected the flag update.");
        }
    }
}