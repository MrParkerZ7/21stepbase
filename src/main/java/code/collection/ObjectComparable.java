package code.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DeadNote implements Comparable<DeadNote> {
    private int no;
    private String name;
    private int age;

    public DeadNote() {
    }

    public DeadNote(int no, String name, int age) {
        this.no = no;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "DeadNote{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(DeadNote d) {
        return this.no > d.no ? 1 : -1;
    }
}

public class ObjectComparable {

    public static void main(String[] args) {
        List<DeadNote> deadNotes = new ArrayList<>();
        deadNotes.add(new DeadNote(5, "Jiro", 53));
        deadNotes.add(new DeadNote(2, "Micro", 45));
        deadNotes.add(new DeadNote(1, "Bark", 24));
        deadNotes.add(new DeadNote(4, "Park", 23));
        deadNotes.add(new DeadNote(3, "Miku", 27));

        Collections.sort(deadNotes);
        for (DeadNote i : deadNotes)
            System.out.println(i);


    }
}
