package modularity.util.controller;

import modularity.util.tool.Division;
import modularity.util.tool.Multiple;

public class Calculator {

    public double calculate(double a, double b, String mehtod) throws IllegalAccessException {

        if (mehtod == "multi")
            return new Multiple().multi(a, b);
        else if (mehtod == "divisive")
            return new Division().divisive(a, b);
        else
            throw new IllegalArgumentException("Illegal Argument Exception: " + mehtod);
    }
}
