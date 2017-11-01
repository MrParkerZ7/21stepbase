package code.loop;

import java.util.Random;

public class LebeledLoop {
    public static void main(String[] args) {
        LebeledLoop ll = new LebeledLoop();
        ll.lebeledLoop();
    }

    void lebeledLoop() {
        first:
        while (true) {
            Random r = new Random();
            int r1 = r.nextInt(11);
            int r2 = r.nextInt(11);

            System.out.println("L1:");
            second:
            for (int i = 0; i < r1; i++) {
                System.out.print(i + "/" + r1 + " ");
                if(r1==10){
                    System.out.println("L1: End Second Loop!!");
                    break second;
                }
            }

            System.out.println("L2:");
            Thrid:
            for (int i = 0; i < r2; i++) {
                System.out.print(i + "/" + r1 + " ");
                if(r2==10){
                    System.out.println("L2: End All Loop!!");
                    break first;
                }
            }
        }
    }
}
