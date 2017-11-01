package code.collection;

import java.util.ArrayList;
import java.util.List;

public class GenericList {

    public static void main(String[] args) {
        // We had ArrayList LinkedList Vector and Stack
        List<Integer> age = new ArrayList<>();
        age.add(45);
        age.add(1, 76);
        age.add(23);
        age.add(0, 52);

        for (Integer i : age) {
            System.out.println(" " + i);
        }
    }
}
