package code.thread;

public class ThreadObject {

    public static void main(String[] args) {
        Runnable jc = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("jc... Carbon");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable jx = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("jx... XOCS");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread jsc = new Thread(jc);
        Thread jsx = new Thread(jx);

        jsc.start();
        jsx.start();
    }
}
