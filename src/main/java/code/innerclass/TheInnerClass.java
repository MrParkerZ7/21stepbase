package code.innerclass;

public class TheInnerClass {
    //Inner Class
    static class StaticInner {

    }

    class Inner {
        class InnerOfInner {

        }
    }


    public static void main(String[] args) {
        TheInnerClass inn = new TheInnerClass();

        inn.localInnerClass();
        inn.anonyMousClass();

    }

    //Local Inner Class
    void localInnerClass() {
        class LocalInner {
            class innerOfLocalInner {
                void showYourSelf() {
                    System.out.println("I'm inner of local inner class!!");
                }
            }

            void showYourSelf() {
                System.out.println("I'm local inner class!!");
            }
        }
    }

    //Anonymous Inner Class
    void anonyMousClass() {
        Innoper innoper = new Innoper();
        innoper.showYourSelf(); // call

        NoperInner noperInner = new NoperInner() {
            @Override
            public void showYourSelf() {
                System.out.println("I'm anonymous class!!");
            }
        };
        noperInner.showYourSelf(); // call

        NoperInner noperInnerLambda = () -> System.out.println("I'm anonymous class with lambda expression");
        noperInnerLambda.showYourSelf(); // call
    }

}
