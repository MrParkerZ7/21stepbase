package code.thread;

class Item {
    private int gear;
    boolean setState = false;

    public synchronized void setItem(int gear) {

        while (setState) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Set gear: " + gear);
        this.gear = gear;
        setState = true;
        notify();
    }

    public synchronized int getGear() {
        while (!setState) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("FileOutputStream gear: " + gear);
        setState = false;
        notify();
        return gear;
    }
}


public class ThreadCommunication {
    static class PutGear implements Runnable {
        Item item;

        public PutGear(Item item) {
            this.item = item;
            Thread t1 = new Thread(this, "SetGear");
            t1.start();
        }

        @Override
        public void run() {
            int i = 0;
            while (true) {
                item.setItem(i++);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i == 10) {
                    break;
                }
            }
        }
    }

    static class GetGear implements Runnable {
        Item item;

        public GetGear(Item item) {
            this.item = item;
            Thread t2 = new Thread(this, "OutputGear");
            t2.start();
        }

        @Override
        public void run() {
            int j = 0;
            int getGear;
            while (true) {
                getGear = item.getGear();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                j++;
                if (j == 10) {
                    break;
                }
            }
        }
    }


    public static void main(String[] args) {
        Item item = new Item();
        new PutGear(item);
        new GetGear(item);

    }

}
