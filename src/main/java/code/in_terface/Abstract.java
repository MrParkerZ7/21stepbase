package code.in_terface;

interface Gear {
    void gear();
}

interface Motor {
    void motor();
}

abstract class MotorBike implements Gear, Motor {

    public abstract void motor();

    public abstract void gear();
}

abstract class SuperBikeV1 extends MotorBike {

    @Override
    public void motor() {
        System.out.println("1,000cc");
    }

    @Override
    public abstract void gear();

    public abstract void body();

}

class SuperBikeV2 extends SuperBikeV1 {

    @Override
    public void gear() {
        System.out.println("6 Gear!");
    }

    @Override
    public void body() {
        System.out.println("Carbon fiber!!");
    }

    public void band() {
        System.out.println("zx10r");
    }

}


public class Abstract {

    public static void main(String[] args) {
        SuperBikeV2 sb = new SuperBikeV2();
        sb.body();
        sb.gear();
        sb.motor();
        sb.band();
    }
}
