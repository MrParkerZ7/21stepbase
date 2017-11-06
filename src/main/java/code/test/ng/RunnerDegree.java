package code.test.ng;

public class RunnerDegree {

    public static String getDegree(Float speed) {
        if (speed >= 50)
            return "S";
        else if (speed >= 40)
            return "A";
        else if (speed >= 30)
            return "B";
        else if (speed >= 20)
            return "C";
        else if (speed >= 10)
            return "D";
        else if (speed < 10)
            return "F";
        else
            throw new IllegalArgumentException("Make sure your data value is corrected");
    }

    public static float upgrade(float speed, String expected) {
        if (expected == "S")
            return 50 - speed;
        else if (expected == "A")
            return 40 - speed;
        else if (expected == "B")
            return 30 - speed;
        else if (expected == "C")
            return 20 - speed;
        else if (expected == "D")
            return 10 - speed;
        else
            throw new IllegalArgumentException("What exactly degree did you want ? ");
    }
}
