package code.collection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GenericSet {

    public static void main(String[] args) {
        { // Not sorted
            Set<Object> personal = new HashSet<>();
            personal.add(23);
            personal.add("Park");
            personal.add(62.3f);
            personal.add(178);
            personal.add("Arena");

            System.out.println(" :HashSet:");
            for (Object i : personal)
                System.out.println("  " + i);
        }

        { // Sorted
            Set<String> personal = new TreeSet<>();
            personal.add("Park");
            personal.add("Arena");
            personal.add("Maria");
            personal.add("Zoyee");
            personal.add("Hon");
            personal.add("Bee");

            System.out.println(" :TreeSet:");
            for (Object i : personal)
                System.out.println("  " + i);
        }
    }
}
