package code.structure;

import java.util.*;

public class Array {

    public static void main(String[] args) {
//        array();
//        list();
        set();
    }

    private static void set() {
        Set<String> name = new HashSet<>();
        name.add("Park");
        name.add("Json");
        name.add("Hex");
        name.add("Demo");

        for (String s : name) {
            System.out.println(s);
        }

        Set<String> noun = new TreeSet<>();
        name.add("stuff");
        name.add("human");
        name.add("animate");
        name.add("animal");

//        noun.forEach(System.out::println);
    }

    static void list() {
        List<Integer> number = new ArrayList<>();
        number.add(59);
        number.add(69);
        number.add(19);
        number.add(39);
        number.add(99);

        try {
            for (Integer i : number) {
                System.out.println(i);
            }
        } finally {
            System.out.println("==END_LOOP==");
        }

        Collections.sort(number);

        try {
            for (Integer i : number) {
                System.out.println(i);
            }
        } finally {
            System.out.println("==END_LOOP==");
        }

    }

    static void array() {
        int myNumber[] = new int[5];
        myNumber[1] = 5;
        myNumber[0] = 6;
        myNumber[4] = 7;
        myNumber[2] = 8;
        myNumber[3] = 9;

        for (int i : myNumber) {
            System.out.println(i);
        }

        Object myObj[] = new Object[3];
        myObj[0] = "Park";
        myObj[1] = 35.6f;
        myObj[2] = 99;

        for (Object i : myObj) {
            System.out.println(i);
        }
    }
}
