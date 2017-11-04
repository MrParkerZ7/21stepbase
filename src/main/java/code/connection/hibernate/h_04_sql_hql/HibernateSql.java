package code.connection.hibernate.h_04_sql_hql;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Map;

public class HibernateSql {

    public static void main(String[] args) {
        Configuration con = new Configuration().configure().addAnnotatedClass(Sword.class);
        try (SessionFactory sf = con.buildSessionFactory();
             Session ss = sf.openSession()) {
            ss.beginTransaction();

            queryByObj(ss);
            queryByEntity(ss);
            queryByMap(ss);

            ss.getTransaction().commit();
        }
    }

    private static void queryByMap(Session ss) {
        SQLQuery q = ss.createSQLQuery("select * from sword where version>=2010");
        q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List swords = q.list();

        Map m;
        for (Object o : swords) {
            m = (Map) o;
            System.out.println(m.get("id") + " : " + m.get("brand") + " : " + m.get("sensor") + " : " + m.get("price"));
        }
    }

    private static void queryByEntity(Session ss) {
        SQLQuery q = ss.createSQLQuery("select * from sword where version>=2010");
        q.addEntity(Sword.class);
        List<Sword> swords = q.list();

        for (Sword s : swords)
            System.out.println(s);
    }

    private static void queryByObj(Session ss) {
        SQLQuery q = ss.createSQLQuery("select * from sword where version>=2010");
        List<Object[]> swords = q.list();

        for (Object[] o : swords)
            System.out.println(o[0] + " : " + o[1] + " : " + o[2]);
    }
}
