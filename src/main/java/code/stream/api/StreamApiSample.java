package code.stream.api;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StreamApiSample {

    private static class thowItOut {

        private static void thowIt(Integer i) {
            System.out.println("ForEach Method Referent x1: " + i);
            System.out.println("ForEach Method Referent x5: " + i * 5);
            System.out.println("ForEach Method Referent x10: " + i * 10);
        }
    }

    public static void main(String[] args) {

        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);

        { // for loop
            for (int i = 0; i < 2; i++) {
                System.out.println("For Loop: " + values.get(i));
            }
        }

        { // Iterator
            Iterator<Integer> i = values.iterator();
            while (i.hasNext()) {
                System.out.println("Iterator: " + i.next());
            }
        }

        { // External loop
            for (Integer i : values) {
                System.out.println("External Iteration: " + i);
            }
        }

        { // Internal loop

            { // single commander
                values.forEach(i -> System.out.println("ForEach SingleCommand: " + i));
            }

            { // multiple commander
                values.forEach(i -> {
                    System.out.println("ForEach MultiCommand" + i);
                    System.out.println("ForEach MultiCommand" + ++i);
                });
            }

            { // method referent
                values.forEach(StreamApiSample.thowItOut::thowIt);
            }
        }
    }
}
