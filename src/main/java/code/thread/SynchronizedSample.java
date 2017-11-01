package code.thread;

/**
 * Usually use with thread
 */

public class SynchronizedSample {

    private static int no;

    private static int time;

    static synchronized void syncStatic() {
        no++;
        synchronized (SynchronizedSample.class) { // code block of static
            time++;
        }
    }

    synchronized void syncInstant() {  // synchronized method
        no++;
        synchronized (this) { // code block of instant
            time++;
        }
    }
}
