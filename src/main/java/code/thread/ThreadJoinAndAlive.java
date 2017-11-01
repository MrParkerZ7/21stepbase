package code.thread;

public class ThreadJoinAndAlive {

    public static void main(String[] args) throws InterruptedException {
        Thread godOfWar = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("God of War Count: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread metalGear = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Metal gear Count: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("God of War before Start is... " + godOfWar.isAlive());  // thread .isAlive(); for check status of threading
        System.out.println("Metal gear before is... " + metalGear.isAlive());

        godOfWar.start();
        metalGear.start();

        System.out.println("God of War after start is... " + godOfWar.isAlive());
        System.out.println("Metal gear after start is... " + metalGear.isAlive());

        godOfWar.join();  // waiting for thread execution
        metalGear.join();

        System.out.println("God of War after join is... " + godOfWar.isAlive());
        System.out.println("Metal gear after join is... " + metalGear.isAlive());

        System.out.println("END!");
    }
}
