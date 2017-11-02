package code.connection.hibernate.table_embed;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateCode {

    public static void main(String[] args) {
//        insertData();
//        getData();
//        deleteData();
        updateData(); // XxX it's not work
    }

    private static void updateData() {
        Motorcycle moto2 = new Motorcycle("Honda", "CBR1000RR", new Motor(4, 189), "TH&EU", "Sport", 2017, "Reduce horsepower");
        moto2.setNo(20);
        moto2.setStyle("Off Road");
        moto2.setBrand("FakeHonda");
        moto2.setMotor(new Motor(1, 19));

        Configuration con = new Configuration().configure().addAnnotatedClass(Motorcycle.class);

        SessionFactory sf = con.buildSessionFactory();

        Session ss = sf.openSession();

        Transaction ts = ss.beginTransaction();

        ss.update(Motorcycle.class.getName(), moto2.getNo());

        ts.commit();
    }

    private static void deleteData() {
        Motorcycle moto = new Motorcycle("BMW", "S1000RR", new Motor(4, 199), "EU", "Sport", 2015, "Full spec like europe");
        moto.setNo(18); // Delete data from database require no witch is primary key.

        Configuration con = new Configuration().configure().addAnnotatedClass(Motorcycle.class);

        SessionFactory sf = con.buildSessionFactory();

        Session ss = sf.openSession();

        Transaction ts = ss.beginTransaction();

        ss.delete(Motorcycle.class.getName(), moto.getNo());

        ts.commit();


    }

    private static void getData() {
        Motorcycle moto = null;
        Motorcycle moto1 = null;

        Configuration con = new Configuration().configure().addAnnotatedClass(Motorcycle.class);

        SessionFactory sf = con.buildSessionFactory();

        Session ss = sf.openSession();

        Transaction ts = ss.beginTransaction();

        moto = ss.get(Motorcycle.class, 19);
        moto1 = ss.get(Motorcycle.class, 20);

        ts.commit();

        System.out.println("Get: " + moto);
        System.out.println("Get: " + moto1);


    }

    private static void insertData() {
        Motorcycle moto = new Motorcycle("BMW", "S1000RR", new Motor(4, 199), "EU", "Sport", 2015, "Full spec like europe");
        Motorcycle moto1 = new Motorcycle("Kawasaki", "ZX10R", new Motor(4, 170), "TH", "Sport", 2016, "Reduce horsepower");
        Motorcycle moto2 = new Motorcycle("Honda", "CBR1000RR", new Motor(4, 189), "TH&EU", "Sport", 2017, "Reduce horsepower");

        Configuration con = new Configuration().configure().addAnnotatedClass(Motorcycle.class);

        SessionFactory sf = con.buildSessionFactory();

        Session ss = sf.openSession();

        Transaction ts = ss.beginTransaction();

        ss.save(moto);
        ss.save(moto1);
        ss.save(moto2);

        ts.commit();

        System.out.println("Add: " + moto + moto1 + moto2);
    }
}
