package code.variable;

class Age {

    // Varargs
    void takeAge(int a) {
        System.out.println("Your age : " + a);
    }

    void takeAge(int a, int b) {
        System.out.println("Your both age : " + a);
        System.out.println("Your both age : " + b);
    }

    void takeAge(int... a) {
        for (int i : a) {
            System.out.println("Your group age : " + i);
        }
    }

    void takeAge(String s, boolean b, int... x) {
        System.out.println("Your name: " + s);
        System.out.println("Your fact: " + b);
        for (int i : x) {
            System.out.println("your score: " + i);
        }
    }
}

public class Varargs {

    public static void main(String[] args) {
        Age a = new Age();

        a.takeAge(25);

        System.out.println("");
        a.takeAge(15, 17);

        System.out.println("");
        a.takeAge(15, 28, 18, 30, 21);

        System.out.println("");
        a.takeAge("park", true, 7, 6, 9, 9, 4);
    }
}
