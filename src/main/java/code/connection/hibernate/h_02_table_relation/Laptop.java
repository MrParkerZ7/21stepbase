package code.connection.hibernate.h_02_table_relation;

import javax.persistence.*;

@Entity
public class Laptop {

    @Id
    @Column(name = "laptop_id")
    private int laptopId;

    @Column(name = "laptop_model")
    private String laptopModel;

    @ManyToOne
    private Human laptopHuman;

    public int getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(int laptopId) {
        this.laptopId = laptopId;
    }

    public String getLaptopModel() {
        return laptopModel;
    }

    public void setLaptopModel(String laptopModel) {
        this.laptopModel = laptopModel;
    }

    public Human getLaptopHuman() {
        return laptopHuman;
    }

    public void setLaptopHuman(Human laptopHuman) {
        this.laptopHuman = laptopHuman;
    }


}
