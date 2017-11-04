package code.connection.hibernate.h_04_sql_hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Random;

public class InsertSwords {

    public static void main(String[] args) {

        initialValue();

    }

    private static void initialValue() {
        Configuration con = new Configuration().configure().addAnnotatedClass(Sword.class);
        try (SessionFactory sf = con.buildSessionFactory();
             Session ss = sf.openSession()) {

            ss.beginTransaction();

            Sword s;
            Random r = new Random();

            int version;
            int price;

            for (int id = 1; id <= 30; id++) {
                price = (r.nextInt(25) + 5) * 1000;
                version = r.nextInt(17) + 2000;
                s = new Sword(id, version, price);
                ss.saveOrUpdate(s);
            }

            ss.getTransaction().commit();
        }
    }
}
