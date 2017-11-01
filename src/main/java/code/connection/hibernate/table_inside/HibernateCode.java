package code.connection.hibernate.table_inside;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateCode {

    public static void main(String[] args) {

        Motorcycle moto = new Motorcycle("BMW", "S1000RR", new Motor(4,  199),"EU", "Sport", 2015, "Full spec like europe");
        Motorcycle moto1 = new Motorcycle("Kawasaki", "ZX10R", new Motor(4,  170),"TH", "Sport", 2016, "Reduce horsepower");
        Motorcycle moto2 = new Motorcycle("Honda", "CBR1000RR", new Motor(4,  189),"TH&EU", "Sport", 2017, "Reduce horsepower");

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
