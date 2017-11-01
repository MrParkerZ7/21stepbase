package code.thread;

import java.util.Random;

public class ThreadInterrupt {

    static class Count implements Runnable {
        @Override
        public void run() {
            Random r = new Random();
            int i;
            while (true) {
                if (!((i = r.nextInt(30)) == 20)) {
                    System.out.println(i + " != " + 20);
                } else {
                    System.out.println(i + " = " + 20 + " Finish!");
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Count().run();
    }
}