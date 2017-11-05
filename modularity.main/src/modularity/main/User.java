package modularity.main;

import modularity.util.controller.Calculator;

public class User {

    public static void main(String[] args) throws IllegalAccessException {
        new Calculator().calculate(5.5, 3.2, "divisive");
        new Calculator().calculate(5.5, 3.2, "multi");


    }
}
