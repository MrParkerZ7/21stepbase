package code.connection.hibernate.table_relation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {

    @Id
    private int laptopId;
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
