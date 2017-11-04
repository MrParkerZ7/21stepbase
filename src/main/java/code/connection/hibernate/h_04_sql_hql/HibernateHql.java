package code.connection.hibernate.h_04_sql_hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateHql {

    public static void main(String[] args) {

        fetchValue();

    }

    private static void fetchValue() {
        Configuration con = new Configuration().configure().addAnnotatedClass(Sword.class);
        try (SessionFactory sf = con.buildSessionFactory();
             Session ss = sf.openSession()) {
            ss.beginTransaction();

            queryAll(ss);
            queryMore(ss);
            queryById(ss);
            queryInObj(ss);
            queryListObj(ss);
            queryInComplexCondition(ss);
            querySumCondition(ss);

            ss.getTransaction().commit();
        }
    }

    private static void querySumCondition(Session ss) {
        Query q = ss.createQuery("select sum(price) from Sword s where s.version>=2010");
        long result = (long) q.uniqueResult();

        System.out.println(result);
    }

    private static void queryInComplexCondition(Session ss) {
        Query q = ss.createQuery("select id,version,price from Sword s where s.price<15000");
        List<Object[]> swords = q.list();

        for (Object[] obj : swords)
            System.out.println(obj[0] + " : " + obj[1] + " : " + obj[2]);
    }

    private static void queryListObj(Session ss) {
        Query q = ss.createQuery("select id,version,price from Sword");
        List<Object[]> students = (List<Object[]>) q.list();  // Get multiple value which is object and information which we selected.

        for (Object[] i : students)
            System.out.println(i[0] + " : " + i[1] + " : " + i[2]);
    }

    private static void queryInObj(Session ss) {
        Query q = ss.createQuery("select id,price from Sword where id=10");
        Object[] sword = (Object[]) q.uniqueResult(); // Get single value which is object and information which we selected.

        for (Object i : sword)
            System.out.println("Get: " + i);
    }

    private static void queryById(Session ss) {
        Query q = ss.createQuery("from Sword where id=7");
        Sword sword = (Sword) q.uniqueResult(); // q.uniqueResult for return a single value.

        System.out.println(sword);
    }

    private static void queryMore(Session ss) {
        Query q = ss.createQuery("from Sword where version >2010");
        List<Sword> swords = q.list(); // Get List<Object> in turn.

        for (Sword s : swords)
            System.out.println(s);
    }


    private static void queryAll(Session ss) { //
        Query q = ss.createQuery("from Sword");
        List<Sword> swords = q.list(); // Get List<Object> in turn.

        for (Sword s : swords)
            System.out.println(s);
    }
}
