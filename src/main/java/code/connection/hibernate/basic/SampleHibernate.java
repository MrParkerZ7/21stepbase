package code.connection.hibernate.basic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SampleHibernate {

    public static void main(String[] args) {
//        insertData();
        fetchData();

    }

    private static void fetchData() {
        Student student = null;

        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        student = session.get(Student.class, 5);

        tx.commit();

        System.out.println(student);
    }

    private static void insertData() {
        Student student = new Student();
        student.setNo(6);
        student.setName("Macro");
        student.setColor("Light");

        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.save(student);

        tx.commit();
    }
}
