package code.connection.hibernate.table_relation;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Human {

    @Id
    private int humanId;
    private String name;

    public int getHumanId() {
        return humanId;
    }

    public void setHumanId(int humanId) {
        this.humanId = humanId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
