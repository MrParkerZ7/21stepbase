package code.overrideload;

class OverHere extends OverThere {
    private int x, y;

    OverHere(int x, int y) {
        super(x);
        this.x = x;
        this.y = x / 2;
    }

    @Override
    void print(int x) {
        if (x >= 0) {
            System.out.println("OverHere: " + x);
        } else {
            super.print(x);
        }
    }

}

class OverThere {
    private int x, y;

    OverThere(int x) {
        this.x = x;
        this.y = x / 2;
    }

    OverThere(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void print(int x) {
        System.out.println("OverThere: " + (x * 2));

    }

}

public class OverAll {


    public static void main(String[] args) {
        OverHere oh = new OverHere(5, 8);
        oh.print(-1);
    }
}


