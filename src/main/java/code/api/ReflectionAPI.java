package code.api;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionAPI {

    public static void main(String[] args) {
        reflectable();
//        changePrivateMethod();
    }

    private static void reflectable() {
        try {

            Class c = Class.forName("My_Resource.reflection.api.Secret");
            System.out.println(c.isInstance(c));
            System.out.println(c.isLocalClass());
            System.out.println(c.getSuperclass());
            System.out.println(c.getName());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void changePrivateMethod() {
        try {

            Class c = Class.forName("My_Resource.reflection.api.Secret");
            Secret s = (Secret) c.newInstance();

            Method m = c.getDeclaredMethod("serect", null);
            m.setAccessible(true);
            m.invoke(s, null);

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}