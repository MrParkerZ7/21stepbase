package code.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GenericComparator {

    public static void main(String[] args) {
//        anonymuseCompare();
//        anonymuseInnerCompare();
//        lambdaCompare();
        shortcutLambdaCompare();


    }

    private static void shortcutLambdaCompare() {
        List<Integer> score = new ArrayList<>();
        score.add(444);
        score.add(678);
        score.add(142);
        score.add(758);
        score.add(245);

        score.sort((Integer o1, Integer o2) -> {
            return o1 % 100 < o2 % 100 ? 1 : -1;
        });

        for (int i : score)
            System.out.println(i);

    }

    private static void lambdaCompare() {
        List<Integer> score = new ArrayList<>();
        score.add(444);
        score.add(678);
        score.add(142);
        score.add(758);
        score.add(245);

        Comparator<Integer> compare = (Integer o1, Integer o2) -> {
            if (o1 % 10 > o2 % 10)
                return 1;
            return -1;
        };
        score.sort(compare);

        for (int i : score)
            System.out.println(i);
    }

    private static void anonymuseInnerCompare() {
        List<Integer> score = new ArrayList<>();
        score.add(444);
        score.add(678);
        score.add(142);
        score.add(758);
        score.add(245);

        Comparator<Integer> compare = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2)
                    return 1;
                return -1;
            }
        };
        score.sort(compare);

        for (int i : score)
            System.out.println(i);
    }

    private static void anonymuseCompare() {
        List<Integer> score = new ArrayList<>();
        score.add(444);
        score.add(678);
        score.add(142);
        score.add(758);
        score.add(245);

        Comparator<Integer> compare = new CustomCompare();
        score.sort(compare);  // Method one
//        Collections.sort(score, compare);  // Method two

        for (int i : score)
            System.out.println(i);
    }
}


class CustomCompare implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 % 100 > o2 % 100)
            return 1;
        return -1;
    }
}