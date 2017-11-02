package code.connection.hibernate.table_relation;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Phone {

    @Id
    private int phoneId;
    private String phoneModel;

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }
}
