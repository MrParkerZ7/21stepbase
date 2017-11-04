package code.connection.hibernate.h_01_table_embed;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateTableEmbed {

    public static void main(String[] args) {
//        insertData();
//        insertOrUpdateData();
        getData();
//        updateData();
//        deleteData();

    }

    private static void insertOrUpdateData() {
        Motorcycle moto = new Motorcycle(1, "BMW", "S1000RR", new Motor(4, 205), "EU", "Sport", 2015, "Full spec like europe");
        Motorcycle moto1 = new Motorcycle(2, "Kawasaki", "ZX10R", new Motor(4, 207), "EU", "Sport", 2017, "Winter Season Pass");
        Motorcycle moto2 = new Motorcycle(3, "Honda", "CBR1000RR", new Motor(4, 189), "TH&EU", "Sport", 2017, "Reduce horsepower");

        Configuration con = new Configuration().configure().addAnnotatedClass(Motorcycle.class);
        try (SessionFactory sf = con.buildSessionFactory();
             Session ss = sf.openSession()) {

            Transaction ts = ss.beginTransaction();

            ss.saveOrUpdate(moto);
            ss.saveOrUpdate(moto1);
            ss.saveOrUpdate(moto2);

            ts.commit();

            System.out.println("Add: " + moto + moto1 + moto2);
        }
    }

    private static void updateData() {
        Motorcycle moto2 = new Motorcycle(3, "FakeHonda", "CBR1000rr", new Motor(1, 19), "TH&EU", "Off Road", 2017, "Reduce horsepower");

        Configuration con = new Configuration().configure().addAnnotatedClass(Motorcycle.class);
        try (SessionFactory sf = con.buildSessionFactory();
             Session ss = sf.openSession()) {

            Transaction ts = ss.beginTransaction();

            ss.update(moto2);

            ts.commit();
        }
    }

    private static void deleteData() {
        Motorcycle moto = new Motorcycle(1, "BMW", "S1000RR", new Motor(4, 199), "EU", "Sport", 2015, "Full spec like europe");
        Motorcycle moto1 = new Motorcycle(2, "Kawasaki", "ZX10R", new Motor(4, 170), "TH", "Sport", 2016, "Reduce horsepower");
        Motorcycle moto2 = new Motorcycle(3, "Honda", "CBR1000RR", new Motor(4, 189), "TH&EU", "Sport", 2017, "Reduce horsepower");

        Configuration con = new Configuration().configure().addAnnotatedClass(Motorcycle.class);
        try (SessionFactory sf = con.buildSessionFactory();
             Session ss = sf.openSession()) {

            Transaction ts = ss.beginTransaction();

            ss.delete(moto);
            ss.delete(moto1);
            ss.delete(moto2);

            ts.commit();
        }
    }

    private static void getData() {
        Motorcycle moto = null;
        Motorcycle moto1 = null;

        Configuration con = new Configuration().configure().addAnnotatedClass(Motorcycle.class);
        try (SessionFactory sf = con.buildSessionFactory();
             Session ss = sf.openSession()) {

            Transaction ts = ss.beginTransaction();

            moto = ss.get(Motorcycle.class, 1);
            moto1 = ss.get(Motorcycle.class, 2);

            ts.commit();

            System.out.println("Get: " + moto);
            System.out.println("Get: " + moto1);
        }
    }

    private static void insertData() {
        Motorcycle moto = new Motorcycle(1, "Bmw", "s1000rr", new Motor(4, 199), "EU", "Sport", 2015, "Full spec like europe");
        Motorcycle moto1 = new Motorcycle(2, "Kawasaki", "zx10r", new Motor(4, 170), "TH", "Sport", 2016, "Reduce horsepower");
        Motorcycle moto2 = new Motorcycle(3, "Honda", "cbr1000rr", new Motor(4, 189), "TH&EU", "Sport", 2017, "Reduce horsepower");

        Configuration con = new Configuration().configure().addAnnotatedClass(Motorcycle.class);
        try (SessionFactory sf = con.buildSessionFactory();
             Session ss = sf.openSession()) {

            Transaction ts = ss.beginTransaction();

            ss.save(moto);
            ss.save(moto1);
            ss.save(moto2);

            ts.commit();

            System.out.println("Add: " + moto + moto1 + moto2);
        }
    }
}
