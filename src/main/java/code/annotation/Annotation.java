package code.annotation;

class Motor {
    @Deprecated
    public void dynamo600cc() {

    }

    public void dynamo1000cc() {

    }
}

class NewMotor extends Motor {
    @Override
    public void dynamo600cc() {
        super.dynamo600cc();
    }

    @Override
    public void dynamo1000cc() {
        super.dynamo1000cc();
    }
}

class Bigbike {
    public static void main(String[] args) {
        Motor motor = new Motor();
        motor.dynamo600cc();
        motor.dynamo1000cc();
    }
}

public class Annotation {

    public static void main(String[] args) {

    }
}
