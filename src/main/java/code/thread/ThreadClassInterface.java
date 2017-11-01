package code.thread;

class Pub implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Pub... Fly");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Hub implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hub.. Walk");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadClassInterface {


    public static void main(String[] args) {
        Pub pub = new Pub();
        Hub hub = new Hub();

        Thread pu = new Thread(pub);
        Thread hu = new Thread(hub);

        pu.start();
        hu.start();
    }

}
