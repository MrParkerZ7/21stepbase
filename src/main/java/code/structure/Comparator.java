package code.structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Comparator {

    public static void main(String[] args) {
//        comparatorClass();
        comparatorLambda();


    }

    private static void comparatorClass() {
        List<Integer> var = new ArrayList<>();
        var.add(156);
        var.add(123);
        var.add(521);
        var.add(902);
        var.add(452);
        var.add(252);
        var.add(752);

        for (Integer i : var) {
            System.out.println(i);
        }

        System.out.println("==sort==");

        ComparCustom par = new ComparCustom();
        Collections.sort(var, par);

        for (Integer i : var) {
            System.out.println(i);
        }

    }

    private static void comparatorLambda() {
        List<Integer> var = new ArrayList<>();
        var.add(156);
        var.add(123);
        var.add(521);
        var.add(902);
        var.add(452);
        var.add(252);
        var.add(752);

        for (Integer i : var) {
            System.out.println(i);
        }

        System.out.println("==sort==");

        Collections.sort(var, ((o1, o2) -> {
            return o1 % 10 > o2 % 10 ? 1 : -1;
        }));

        for (Integer i : var) {
            System.out.println(i);
        }

        System.out.println("==sort revers==");

        Collections.sort(var, (((o1, o2) -> {
            if (o1 % 10 > o1 % 10) {
                return 1;
            } else {

            }
            return 0;
        })));

        for (Integer i : var) {
            System.out.println(i);
        }
    }

}

class ComparCustom implements java.util.Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 > o2 ? 1 : -1;
    }

}
