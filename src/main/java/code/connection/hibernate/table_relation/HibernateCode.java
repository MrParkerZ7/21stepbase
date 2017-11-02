package code.connection.hibernate.table_relation;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateCode {

    public static void main(String[] args) {
        Human h1 = new Human();
        h1.setHumanId(1);
        h1.setName("Park");

        Phone p1 = new Phone();
        p1.setPhoneId(101);
        p1.setPhoneModel("IphoneX");

        Configuration con = new Configuration().configure().addAnnotatedClass(Human.class).addAnnotatedClass(Phone.class);
        SessionFactory sf = con.buildSessionFactory();
        Session ss = sf.openSession();
        ss.beginTransaction();
        ss.save(h1);
        ss.save(p1);
        ss.getTransaction().commit();

    }
}
