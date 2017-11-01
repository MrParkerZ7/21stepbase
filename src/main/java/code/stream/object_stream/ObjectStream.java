package code.stream.object_stream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Memory implements Serializable {
    private String nickName;
    private String firstName;
    private String lastName;
    private int age;

    Memory() {

    }

    Memory(String nickName, String firstName, String lastName, int age) {
        this.nickName = nickName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "nickName='" + nickName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}

public class ObjectStream {

    public static void main(String[] args) {
//        basicSet(); // Easily to understand
//        complateSet();  // Practical to use
        practicleSet();

    }

    private static void practicleSet() {
        { // write object
            Memory m1 = new Memory("Park", "Promswas", "Pitakmetakul", 23);
            Memory m2 = new Memory("Licking", "Dicker", "Butter", 23);
            Memory m3 = new Memory("Dark", "Darkness", "Black", 99);

            List<Object> myMemory = new ArrayList<>();

            myMemory.add(m1);
            myMemory.add(m2);
            myMemory.add(m3);

            {
                try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("ObjectStateStore3.class"))) {
                    objOut.writeObject(myMemory);
                    System.out.println("write: " + myMemory);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        { // Read Object
            List<Object> myMemory;
            try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("ObjectStateStore3.class"))) {
                myMemory = (List<Object>) objIn.readObject();
                System.out.println("Read: " + myMemory);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private static void basicSet() {
        {  // write object file
            Memory m = new Memory("Licking", "Dicker", "Butter", 23);

            try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("ObjectStateStore2.class"))) {
                objOut.writeObject(m);
                System.out.println("write: " + m);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        {  // Read object file
            Memory m;

            try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("ObjectStateStore2.class"))) {
                m = (Memory) objIn.readObject();
                System.out.println("Read: " + m);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private static void complateSet() {
        Memory m = new Memory("Park", "Promswas", "Pitakmetakul", 23);
        saveObject(m); // Save object into file

        // Load file into object
        Memory m1 = (Memory) getObject();
        System.out.println(m1);
    }

    private static void saveObject(Object obj) {
        File f = new File("ObjectStateStore.class");
        try (FileOutputStream fileOut = new FileOutputStream("ObjectStateStore.class");
             ObjectOutputStream objOut = new ObjectOutputStream(fileOut)) {

            objOut.writeObject(obj);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Object getObject() {
        File f = new File("ObjectStateStore.class");
        try (FileInputStream fileIn = new FileInputStream("ObjectStateStore.class");
             ObjectInputStream objIn = new ObjectInputStream(fileIn)) {
            Object obj = objIn.readObject();
            return obj;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
