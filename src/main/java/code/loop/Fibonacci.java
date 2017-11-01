package code.loop;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci fb = new Fibonacci();
//        fb.loop1();
        fb.loop2();
    }

    void loop1() {
        List<Integer> x = new ArrayList<>();
        x.add(1);
        x.add(1);
        System.out.println(x.get(0));
        System.out.println(x.get(1));

        int a, b, c;
        for (int i = 0; i < 20; i++) {
            a = x.get(i);
            b = x.get(i + 1);
            c = a + b;
            System.out.println(c);
            x.add(c);
        }
    }

    void loop2() {
        int a = 1, b = 1, k = 0;

        System.out.println(a + " ");
        System.out.println(b + " ");

        for (int i = 0; i < 20; i++) {
            k = a + b;
            System.out.println(k + " ");
            a = b;
            b = k;
        }
    }
}
