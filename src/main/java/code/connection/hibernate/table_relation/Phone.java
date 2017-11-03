package code.connection.hibernate.table_relation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Phone {

    @Id
    @Column(name = "PHONE_ID")
    private int phoneId;

    @Column(name = "PHONE_MODEL")
    private String phoneModel;

    @OneToOne
    private Human phoneHuman;

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

    public Human getPhoneHuman() {
        return phoneHuman;
    }

    public void setPhoneHuman(Human phoneHuman) {
        this.phoneHuman = phoneHuman;
    }


}
