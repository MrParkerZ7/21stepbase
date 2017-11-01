package code.collection;

import java.util.ArrayList;
import java.util.Collection;

class Student {
    private String name;
    private int no;

    public Student(String name, int no) {
        this.name = name;
        this.no = no;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", no=" + no +
                '}';
    }
}

public class GenericCollection {

    public static void main(String[] args) {

        { // Collection
            Collection<Object> player = new ArrayList<>();
            player.add("Park");
            player.add(23);
            player.add(178);
            player.add(new Student("Paxk", 26413));

            System.out.println(":Nonn Generic:");
            for (Object obj : player) {
                System.out.println("  " + obj);
            }
        }

        { // Collection & Generic
            Collection<Integer> scores = new ArrayList<>();
            scores.add(53);
            scores.add(99);
            scores.add(41);
            scores.add(13);
            scores.add(4);

            System.out.println(":Generic:");
            for (Integer score : scores) {
                System.out.println("  " + score);
            }
        }
    }
}
