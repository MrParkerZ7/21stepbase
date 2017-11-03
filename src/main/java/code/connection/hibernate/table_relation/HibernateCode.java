package code.connection.hibernate.table_relation;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;

public class HibernateCode {

    public static void main(String[] args) {
//        insertData();
    }

    private static void insertData() {
        Human h1 = new Human();
        Phone p1 = new Phone();
        Laptop lt1 = new Laptop();
        Laptop lt2 = new Laptop();
        Car c1 = new Car();

        h1.setHumanId(1);
        h1.setHumanName("Park");
        h1.setHumanPhone(p1);
        h1.setHumanLaptop(new ArrayList<>(Arrays.asList(lt1, lt2)));
        h1.setHumanCar(new ArrayList<>(Arrays.asList(c1)));

        p1.setPhoneId(101);
        p1.setPhoneModel("IphoneX");
        p1.setPhoneHuman(h1);

        lt1.setLaptopId(201);
        lt1.setLaptopModel("Lenovo");
        lt1.setLaptopHuman(h1);

        lt2.setLaptopId(202);
        lt2.setLaptopModel("Mac OS");
        lt2.setLaptopHuman(h1);

        c1.setCarId(301);
        c1.setCarModel("BMW i8");
        c1.setCarHuman(new ArrayList<>(Arrays.asList(h1)));


        { // Execute
            Configuration con = new Configuration().configure().addAnnotatedClass(Human.class).addAnnotatedClass(Phone.class).addAnnotatedClass(Laptop.class).addAnnotatedClass(Car.class);
            SessionFactory sf = con.buildSessionFactory();
            Session ss = sf.openSession();
            ss.beginTransaction();

            ss.save(h1);
            ss.save(p1);
            ss.save(lt1);
            ss.save(lt2);
            ss.save(c1);

            ss.getTransaction().commit();
        }
    }
}
