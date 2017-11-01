package code.thread;

class Welcome extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Welcome... Buy");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class GetBack extends Thread { // make our class become My_Resource.Thread
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("GetBack... GetOut");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadClassExtends {

    public static void main(String[] args) {
        Welcome welcome = new Welcome(); // Instant object
        GetBack getBack = new GetBack();

        welcome.start(); // call method of our class
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getBack.start();


    }

}
