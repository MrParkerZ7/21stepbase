package code.connection.hibernate.h_05_shrink_version;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateShrink {

    public static void main(String[] args) {
        Configuration con = new Configuration().configure().addAnnotatedClass(Camera.class);
        try (SessionFactory sf = con.buildSessionFactory();
             Session ss = sf.openSession()) {

            ss.beginTransaction();

//            insertOrUpdateData(ss);
            fetchData(ss);

            ss.getTransaction().commit();
        }

    }

    private static void fetchData(Session ss) {
        System.out.println(ss.get(Camera.class, 1));
        System.out.println(ss.get(Camera.class, 2));
        System.out.println(ss.get(Camera.class, 3));
        System.out.println(ss.get(Camera.class, 4));
    }

    private static void insertOrUpdateData(Session ss) {
        ss.saveOrUpdate(new Camera(1, "Cannon", "70D", 1f));
        ss.saveOrUpdate(new Camera(2, "Nikon", "D5300", 1f));
        ss.saveOrUpdate(new Camera(3, "Cannon", "5D3", 1.6f));
        ss.saveOrUpdate(new Camera(4, "Cannon", "1D3", 1.3f));
    }
}
