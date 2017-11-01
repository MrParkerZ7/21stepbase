package code.thread;

public class ThreadSynchronized {
    private static class Count {
        int inCount;

        // synchronized make method stable but slow down
        public synchronized void increment() {
            inCount++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSynchronized.Count c1 = new ThreadSynchronized.Count();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                c1.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                c1.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(c1.inCount);
    }
}