package code.st_atic;

class CaseA {
    private static String name = "";

    static {
        name = "Park";
    }

    static void run() {
        System.out.println("A: " + name);
    }

}

public class SequenceStatic {

    public static void main(String[] args) {
        CaseA.run();
        System.out.println(
                System.getProperty("park")
        );
    }
}