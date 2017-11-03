package code.connection.hibernate.table_relation;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;

public class HibernateCode {

    public static void main(String[] args) {
        insertData();
//        getData();
//        updateData();
//        deleteData();
    }

    private static void deleteData() {
        Human h1 = new Human();
        Human h2 = new Human();
        Phone p1 = new Phone();
        Phone p2 = new Phone();
        Laptop lt1 = new Laptop();
        Laptop lt2 = new Laptop();
        Laptop lt3 = new Laptop();
        Laptop lt4 = new Laptop();
        Car c1 = new Car();
        Car c2 = new Car();

        h1.setHumanId(1);
        h1.setHumanName("Park");
        h1.setHumanPhone(p1);
        h1.setHumanLaptop(new ArrayList<>(Arrays.asList(lt1, lt2)));
        h1.setHumanCar(new ArrayList<>(Arrays.asList(c1, c2)));

        h2.setHumanId(2);
        h2.setHumanName("Micro");
        h2.setHumanPhone(p2);
        h2.setHumanLaptop(new ArrayList<>(Arrays.asList(lt3, lt4)));
        h2.setHumanCar(new ArrayList<>(Arrays.asList(c1, c2)));

        p1.setPhoneId(101);
        p1.setPhoneModel("IphoneX");
        p1.setPhoneHuman(h1);

        p2.setPhoneId(102);
        p2.setPhoneModel("Galaxy S8");
        p2.setPhoneHuman(h2);

        lt1.setLaptopId(201);
        lt1.setLaptopModel("Lenovo");
        lt1.setLaptopHuman(h1);

        lt2.setLaptopId(202);
        lt2.setLaptopModel("Mac OS");
        lt2.setLaptopHuman(h1);

        lt3.setLaptopId(203);
        lt3.setLaptopModel("HP");
        lt3.setLaptopHuman(h1);

        lt4.setLaptopId(204);
        lt4.setLaptopModel("Dell");
        lt4.setLaptopHuman(h1);

        c1.setCarId(301);
        c1.setCarModel("BMW i8");
        c1.setCarHuman(new ArrayList<>(Arrays.asList(h1, h2)));

        c2.setCarId(302);
        c2.setCarModel("3B");
        c2.setCarHuman(new ArrayList<>(Arrays.asList(h1, h2)));

        Configuration con = new Configuration().configure().addAnnotatedClass(Human.class).addAnnotatedClass(Phone.class).addAnnotatedClass(Laptop.class).addAnnotatedClass(Car.class);
        SessionFactory sf = con.buildSessionFactory();
        Session ss = sf.openSession();
        ss.beginTransaction();

        // You can write both of way to delete data. You still get the same result
        ss.delete(String.valueOf(Human.class), h1);
        ss.delete(String.valueOf(Phone.class), h2);
        ss.delete(p1);
        ss.delete(p2);
        ss.delete(lt1);
        ss.delete(lt2);
        ss.delete(lt3);
        ss.delete(lt4);
        ss.delete(c1);
        ss.delete(c2);

        ss.getTransaction().commit();

        // You need to make sure the data you want to delete. Because, hibernate will delete if the primary key or foreign key still still related to another table.
    }

    private static void updateData() {
        Human h1 = new Human();
        Phone p1 = new Phone();
        Laptop lt1 = new Laptop();
        Laptop lt2 = new Laptop();
        Car c1 = new Car();
        Car c2 = new Car();

        h1.setHumanId(1);
        h1.setHumanName("FakePark");
        h1.setHumanPhone(p1);
        h1.setHumanLaptop(new ArrayList<>(Arrays.asList(lt1, lt2)));
        h1.setHumanCar(new ArrayList<>(Arrays.asList(c1, c2)));

        p1.setPhoneId(101);
        p1.setPhoneModel("IphoneF");
        p1.setPhoneHuman(h1);

        lt1.setLaptopId(201);
        lt1.setLaptopModel("Lenowow");
        lt1.setLaptopHuman(h1);

        lt2.setLaptopId(202);
        lt2.setLaptopModel("Mac ISO");
        lt2.setLaptopHuman(h1);

        c1.setCarId(301);
        c1.setCarModel("BMW IHateU!!");
        c1.setCarHuman(new ArrayList<>(Arrays.asList(h1)));

        c2.setCarId(302);
        c2.setCarModel("B2");
        c2.setCarHuman(new ArrayList<>(Arrays.asList(h1)));

        Configuration con = new Configuration().configure().addAnnotatedClass(Human.class).addAnnotatedClass(Phone.class).addAnnotatedClass(Laptop.class).addAnnotatedClass(Car.class);
        SessionFactory sf = con.buildSessionFactory();
        Session ss = sf.openSession();
        ss.beginTransaction();

        // You can write both of way to update data. You still get the same result.
        ss.update(String.valueOf(Human.class), h1);
        ss.update(String.valueOf(Phone.class), p1);
        ss.update(lt1);
        ss.update(lt2);
        ss.update(c1);
        ss.update(c2);

        ss.getTransaction().commit();
    }

    private static void getData() {
        Configuration con = new Configuration().configure().addAnnotatedClass(Human.class).addAnnotatedClass(Phone.class).addAnnotatedClass(Laptop.class).addAnnotatedClass(Car.class);
        SessionFactory sf = con.buildSessionFactory();
        Session ss = sf.openSession();
        ss.beginTransaction();

        Human h1 = ss.get(Human.class, 1);

        ss.getTransaction().commit();

        System.out.println(h1);

        System.out.println("ObjCar: " + h1.getHumanCar());

        System.out.println("ObjLaptop: " + h1.getHumanLaptop());
    }

    private static void insertData() {
        Human h1 = new Human();
        Human h2 = new Human();
        Phone p1 = new Phone();
        Phone p2 = new Phone();
        Laptop lt1 = new Laptop();
        Laptop lt2 = new Laptop();
        Laptop lt3 = new Laptop();
        Laptop lt4 = new Laptop();
        Car c1 = new Car();
        Car c2 = new Car();

        h1.setHumanId(1);
        h1.setHumanName("Park");
        h1.setHumanPhone(p1);
        h1.setHumanLaptop(new ArrayList<>(Arrays.asList(lt1, lt2)));
        h1.setHumanCar(new ArrayList<>(Arrays.asList(c1, c2)));

        h2.setHumanId(2);
        h2.setHumanName("Micro");
        h2.setHumanPhone(p2);
        h2.setHumanLaptop(new ArrayList<>(Arrays.asList(lt3, lt4)));
        h2.setHumanCar(new ArrayList<>(Arrays.asList(c1, c2)));

        p1.setPhoneId(101);
        p1.setPhoneModel("IphoneX");
        p1.setPhoneHuman(h1);

        p2.setPhoneId(102);
        p2.setPhoneModel("Galaxy S8");
        p2.setPhoneHuman(h2);

        lt1.setLaptopId(201);
        lt1.setLaptopModel("Lenovo");
        lt1.setLaptopHuman(h1);

        lt2.setLaptopId(202);
        lt2.setLaptopModel("Mac OS");
        lt2.setLaptopHuman(h1);

        lt3.setLaptopId(203);
        lt3.setLaptopModel("HP");
        lt3.setLaptopHuman(h1);

        lt4.setLaptopId(204);
        lt4.setLaptopModel("Dell");
        lt4.setLaptopHuman(h1);

        c1.setCarId(301);
        c1.setCarModel("BMW i8");
        c1.setCarHuman(new ArrayList<>(Arrays.asList(h1, h2)));

        c2.setCarId(302);
        c2.setCarModel("3B");
        c2.setCarHuman(new ArrayList<>(Arrays.asList(h1, h2)));


        { // Execute
            Configuration con = new Configuration().configure().addAnnotatedClass(Human.class).addAnnotatedClass(Phone.class).addAnnotatedClass(Laptop.class).addAnnotatedClass(Car.class);
            SessionFactory sf = con.buildSessionFactory();
            Session ss = sf.openSession();
            ss.beginTransaction();

            ss.save(h1);
            ss.save(h2);
            ss.save(p1);
            ss.save(p2);
            ss.save(lt1);
            ss.save(lt2);
            ss.save(lt3);
            ss.save(lt4);
            ss.save(c1);
            ss.save(c2);

            ss.getTransaction().commit();
        }
    }
}
