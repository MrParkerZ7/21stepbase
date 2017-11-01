package code.inheritance;

abstract class Vehicle {
    abstract void motor(int cc);

    abstract void wheel();

    abstract void body();

}

class MotorBike extends Vehicle {

    @Override
    void motor(int cc) {
        System.out.println("This bike: " + cc + " cc");
    }

    @Override
    void wheel() {
        System.out.println("This bike had 2 wheel");
    }

    @Override
    void body() {
        System.out.println("This bike carbon fiber");
    }
}

class Car extends Vehicle {

    @Override
    void motor(int cc) {
        System.out.println("This car: " + (cc*3) + " cc");
    }

    @Override
    void wheel() {
        System.out.println("This car had 4 wheel");
    }

    @Override
    void body() {
        System.out.println("This car metal body");
    }

}

public class Abstract {
    public static void main(String[] args) {
        Abstract at = new Abstract();

        MotorBike mb = new MotorBike();
        Car c = new Car();

        at.change(c);
        at.change(mb);
    }

    private void change(Vehicle v) {
        v.motor(1000);
        v.body();
        v.wheel();
    }


}
