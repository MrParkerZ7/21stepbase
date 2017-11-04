package code.connection.hibernate.h_03_caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HibernateCaching {

    public static void main(String[] args) {
        insertOrUpdateData();
//        getData();
//        getDataQuery(); // TODO: It's does't work. Try to fix it.
    }

    private static void getDataQuery() {
        Raider r1 = null;
        Raider r2 = null;
        Raider r3 = null;

        Configuration con = new Configuration().configure().addAnnotatedClass(Raider.class);
        try (SessionFactory sf = con.buildSessionFactory()) {
            Session ss1 = sf.openSession();

            ss1.beginTransaction();
            Query q1 = ss1.createQuery("from Raider where raiderId=1");
            q1.setCacheable(true);

            r1 = (Raider) q1.uniqueResult();
            System.out.println(r1);

            ss1.getTransaction().commit();
            ss1.close();

            sf.close();
        }
    }

    private static void getData() {
        Raider r1 = null;
        Raider r2 = null;
        Raider r3 = null;

        Configuration con = new Configuration().configure().addAnnotatedClass(Raider.class);
        try (SessionFactory sf = con.buildSessionFactory()) {
            Session ss1 = sf.openSession();
            ss1.beginTransaction();

            r1 = ss1.get(Raider.class, 1);
            r2 = ss1.get(Raider.class, 2);
            r3 = ss1.get(Raider.class, 3);

            ss1.getTransaction().commit();
            ss1.close();

            System.out.println(r1);
            System.out.println(r2);
            System.out.println(r3);


            Session ss2 = sf.openSession();
            ss2.beginTransaction();

            r1 = ss2.get(Raider.class, 1);
            r2 = ss2.get(Raider.class, 2);
            r3 = ss2.get(Raider.class, 3);

            ss2.getTransaction().commit();
            ss2.close();

            System.out.println(r1);
            System.out.println(r2);
            System.out.println(r3);

            sf.close();
        }
    }

    private static void insertOrUpdateData() {
        Raider r1 = new Raider(1, "Park", false);
        Raider r2 = new Raider(2, "Micro", true);
        Raider r3 = new Raider(3, "Macro", true);

        Configuration con = new Configuration().configure().addAnnotatedClass(Raider.class);
        try (SessionFactory sf = con.buildSessionFactory();
             Session ss = sf.openSession()) {

            ss.beginTransaction();

            ss.saveOrUpdate(r1);
            ss.saveOrUpdate(r2);
            ss.saveOrUpdate(r3);

            ss.getTransaction().commit();
            sf.close();
        }
    }
}