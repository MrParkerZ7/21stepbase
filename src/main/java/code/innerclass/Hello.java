package code.innerclass;


public class Hello {
    class InnerHello {
        InnerHello() {
            System.out.println(
                    "The method call is coming from inside the class !"
            );
        }
    }

    public Hello() {
        // empty constructor
        System.out.println("Hello!!");
    }

    public static void main(String[] arguments) {
        Hello program = new Hello();
        Hello.InnerHello inner = program.new InnerHello();
    }
}