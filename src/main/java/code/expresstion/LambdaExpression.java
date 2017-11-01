package code.expresstion;

interface SayMyName {
    default void myName() {
        System.out.println("Java!!");
    }

    void yourName();
}

public class LambdaExpression {

    public static void main(String[] args) {
        LambdaExpression le = new LambdaExpression();
        le.lambdaThread();
        le.lambdaInterface();
    }

    private void lambdaInterface() {
        SayMyName smn = new SayMyName() {

            @Override
            public void yourName() {
                System.out.println("Parker!!");
                itName();
            }

            public void itName() {
                System.out.println("Dicker!!");
            }
        };
        smn.myName();
        smn.yourName();
    }

    private void lambdaThread() {

        // Lambda with anonymous class
        Thread t1 = new Thread(() -> {
            int j = 0, k = 0;
            for (int i = 0; i < 20; System.out.println((i++) + " " + (j = j + 2) + " " + (k = k + 3))) ;
        });

        // Lambda with single statement
        Thread t2 = new Thread(() -> System.out.println("Who am I ?"));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
