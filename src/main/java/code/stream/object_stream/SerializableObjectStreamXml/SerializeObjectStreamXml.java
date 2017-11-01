package code.stream.object_stream.SerializableObjectStreamXml;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializeObjectStreamXml {

    public static void main(String[] args) {
        basicSet();
//        complateSet();
    }

    private static void basicSet() {
        { // write
            Student s1 = new Student(5, "Suck");
            Student s2 = new Student(6, "Rapes");
            List<Student> students = new ArrayList<>();
            students.add(s1);
            students.add(s2);
            CollectionStudent cs = new CollectionStudent(students);

            try (XMLEncoder xmlEn = new XMLEncoder(new FileOutputStream("ObjectStateStoreXml2.xml"))) {
                xmlEn.writeObject(cs);
                System.out.println("write: " + cs);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        { // Read
            CollectionStudent cs;
            try (XMLDecoder xmlDe = new XMLDecoder(new FileInputStream("ObjectStateStoreXml2.xml"))) {
                cs = (CollectionStudent) xmlDe.readObject();
                System.out.println("Read: " + cs);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private static void complateSet() {
        SerializeObjectStreamXml osx = new SerializeObjectStreamXml();
        Student s1 = new Student(101, "Park");
        Student s2 = new Student(102, "Mark");

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);

        CollectionStudent cs = new CollectionStudent(students);

        serializeXml(cs); // write
        deserializeXml(); // Read
    }

    private static void deserializeXml() {
        try (XMLDecoder x = new XMLDecoder(new FileInputStream("ObjectStateStoreXml.xml"))) {
            CollectionStudent cs = (CollectionStudent) x.readObject();
            System.out.println("Read: " + cs);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void serializeXml(CollectionStudent cs) {
        try (XMLEncoder x = new XMLEncoder(new FileOutputStream("ObjectStateStoreXml.xml"))) {
            x.writeObject(cs);  //Can't writeObject(); with inner class or class local in the same file
            System.out.println("write: " + cs);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}