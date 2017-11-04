package code.connection.hibernate.h_04_sql_hql;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Sword implements Serializable{

    @Id
    private int id;
    private int version;
    private int price;

    public Sword() {
    }

    public Sword(int id, int version, int price) {
        this.id = id;
        this.version = version;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SwordObj{" +
                "id=" + id +
                ", version=" + version +
                ", price=" + price +
                '}';
    }
}
