package code.thread;

public class ThreadLambdaExpression {

    public static void main(String[] args) {
//        lambdaExpression();
        lambdaExpression2();

    }

    private static void lambdaExpression2() {
        Thread z1000 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("City Way...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Z1000Thread"); // set name of thread

        Thread gs1200 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("OffRoad Way...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println(z1000.getName()); // name we set
        System.out.println(gs1200.getName()); // name by default start from 0.. .

        z1000.start();
        gs1200.start();
    }

    static void lambdaExpression() {
        Runnable zx10r = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Kawasaki");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable s1000rr = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("BMW");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread zxr = new Thread(zx10r);
        Thread srr = new Thread(s1000rr);

        zxr.start();
        srr.start();
    }
}
