package code.pattern;

/**
 * Design Builder Pattern
 *
 */

public class BuilderPattern {

    public static void main(String[] args) {
        MotorBike mb = new MotorBikeBuilder().setBran("ZX10RR").setCc(1000).getMotorbike();
        System.out.println(mb);
    }
}

class MotorBike {
    private String bran;
    private String motor;
    private int cc;
    private int price;

    public MotorBike(String bran, String motor, int cc, int price) {
        this.bran = bran;
        this.motor = motor;
        this.cc = cc;
        this.price = price;
    }

    @Override
    public String toString() {
        return "MotorBike{" +
                "bran='" + bran + '\'' +
                ", motor='" + motor + '\'' +
                ", cc=" + cc +
                ", price=" + price +
                '}';
    }
}

class MotorBikeBuilder {
    private String bran;
    private String motor;
    private int cc;
    private int price;

    public MotorBikeBuilder setBran(String bran) {
        this.bran = bran;
        return this;
    }

    public MotorBikeBuilder setMotor(String motor) {
        this.motor = motor;
        return this;
    }

    public MotorBikeBuilder setCc(int cc) {
        this.cc = cc;
        return this;
    }

    public MotorBikeBuilder setPrice(int price) {
        this.price = price;
        return this;
    }

    public MotorBike getMotorbike() {
        return new MotorBike(bran, motor, cc, price);
    }
}
