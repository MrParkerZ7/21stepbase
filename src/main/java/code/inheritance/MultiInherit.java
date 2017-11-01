package code.inheritance;

interface GrandFa {

    default void face() {
        System.out.println("GrandFa Face!");
    }

}

interface GrandMa {

    default void face() {
        System.out.println("GrandMa Face!");
    }

}

interface Father extends GrandFa, GrandMa {

    @Override
    default void face() {
        //Fa + Ma
        System.out.println("Father Face!");
    }

    default void tall() {
        System.out.println("Father tall!");
    }

    default void hair() {
        System.out.println("Father hair!");
    }


}

class Mather {

    void face() {
        System.out.println("Mather face!");
    }

    void body() {
        System.out.println("Mather body!");
    }

    void hair() {
        System.out.println("Mather hair!");
    }
}


class Me extends Mather implements Father {

    @Override
    public void face() {
        // This method need to override.
        // Because, we extends Mather class and implements Father interface
        // which is, it had the same method void face(){...};
        System.out.println("My Face!!");
    }

    @Override
    public void hair() {
        // Actually this method need to override
        // But, in this case we choose another way.
        // This is call the super(); and we got hair() method from Mather.
        // Because, Mather is class Father is interface.
        // And class is height priority than interface
        // And we can't use super(); to call method from parent interface
        super.hair();
    }


}

public class MultiInherit {

    public static void main(String[] args) {
        Me me = new Me();
        me.face();
        me.body();
        me.tall();
        me.hair();
    }
}
