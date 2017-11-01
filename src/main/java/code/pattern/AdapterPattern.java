package code.pattern;

public class AdapterPattern {

    public static void main(String[] args) {
        paper("Snack");
        paper("Bear");
    }

    private static void paper(String s) {
        Pen p = new PenAdapter();
        p.write(s);
    }
}

interface Pen {
    void write(String s);
}

class PenAdapter implements Pen {

    FriendPen fp = new FriendPen();

    @Override
    public void write(String s) {
        fp.paint(s);
    }
}

class FriendPen {

    void paint(String s) {
        System.out.println(s);
    }
}