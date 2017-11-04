package code.connection.hibernate.h_02_table_relation;

import javax.persistence.*;

@Entity
public class Phone {

    @Id
    @Column(name = "phone_id")
    private int phoneId;

    @Column(name = "phone_model")
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