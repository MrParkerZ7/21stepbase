package code.connection.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class SampleHibernate {

    public static void main(String[] args) {
        Student park = new Student();
        park.setNo(5);
        park.setName("Park");
        park.setColor("Dark");

        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.save(park);

        tx.commit();
    }
}
