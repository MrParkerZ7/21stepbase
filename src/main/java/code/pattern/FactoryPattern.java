package code.pattern;

/**
 * Factory Design Pattern
 * this concept use the object or something to design
 * what we should give for requisition
 */

public class FactoryPattern {

    public static void main(String[] args) {
        BikeStyle bs = new BikeStyle().setMyStyle("Race");
        System.out.println(bs.getYourBikeStyle());
    }
}

class BikeStyle {
    private String myStyle;

    public BikeStyle setMyStyle(String myStyle) {
        this.myStyle = myStyle;
        return this;
    }

    String getYourBikeStyle() {
        if (myStyle == "Race")
            return new Sport().bikeStyle();
        else if (myStyle == "Chill")
            return new Touring().bikeStyle();
        else if (myStyle == "Extreme")
            return new MotorCross().bikeStyle();
        else if (myStyle == null)
            return "Please specify..";
        else
            return "Go to hell man!!";
    }
}

interface MotorBikeable {
    String bikeStyle();
}

class Sport implements MotorBikeable {

    @Override
    public String bikeStyle() {
        return "s1000rrr";
    }
}

class Touring implements MotorBikeable {

    @Override
    public String bikeStyle() {
        return "Ninja 1000";
    }
}

class MotorCross implements MotorBikeable {

    @Override
    public String bikeStyle() {
        return "CRF450";
    }
}
