package code.Enum;

//Manner of enum in class manner
class Vehical {
    final static Vehical ZX10R = new Vehical(679);
    final static Vehical S1000RR = new Vehical(820);
    final static Vehical R1M = new Vehical();

    int price;

    Vehical() {

    }

    Vehical(int i) {
        price = i;

    }
}

public class Enum {

    private enum Motor {
        ZX10R(679), S1000RR(820), R1M();

        int price;

        Motor() {

        }

        Motor(int i) {
            price = i;
        }
    }

    public static void main(String[] args) {
        switch (Motor.S1000RR) {
            case R1M:
                System.out.println("Yamaha");
                System.out.println("Price: " + Motor.R1M.price + "k");
                break;
            case ZX10R:
                System.out.println("Kawasaki");
                System.out.println("Price: " + Motor.ZX10R.price + "k");
                break;
            case S1000RR:
                System.out.println("BMW");
                System.out.println("Price: " + Motor.S1000RR.price + "k");
                break;
            default:
                System.out.println("No name...");
                break;
        }
    }

}
