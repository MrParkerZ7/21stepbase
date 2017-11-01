package code.thread;

public class ThreadNamePriority {
    static class Josy implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("Josy has count: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Josy josy = new Josy();

        Thread aJosy = new Thread(josy);

        aJosy.start();

        System.out.println("===Before Set===");
        mannerThread(aJosy);
        System.out.println("===Before Set===");


        aJosy.setName("MyThread");
        aJosy.setPriority(10);
        // and set another

        aJosy.join();

        System.out.println("===After Set===");
        mannerThread(aJosy);
        System.out.println("===After Set===");


    }

    static void mannerThread(Thread aJosy) {
        System.out.println("My_Resource.Thread ID: " + aJosy.getId());
        System.out.println("My_Resource.Thread Name: " + aJosy.getName());
        System.out.println("My_Resource.Thread Priority: " + aJosy.getPriority());
        System.out.println("My_Resource.Thread State: " + aJosy.getState());
        System.out.println("My_Resource.Thread StackkTrace: " + aJosy.getStackTrace());
        // and get another...
    }

}
