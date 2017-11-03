package code.connection.hibernate.table_relation;

import javax.persistence.*;
import java.util.List;

@Entity
public class Human {

    @Id
    private int humanId;
    private String humanName;
    @OneToOne
    private Phone humanPhone;
    @OneToMany (mappedBy = "laptopHuman")
    private List<Laptop> humanLaptop;
    @ManyToMany
    private List<Car> humanCar;

    public int getHumanId() {
        return humanId;
    }

    public void setHumanId(int humanId) {
        this.humanId = humanId;
    }

    public String getHumanName() {
        return humanName;
    }

    public void setHumanName(String humanName) {
        this.humanName = humanName;
    }

    public Phone getHumanPhone() {
        return humanPhone;
    }

    public void setHumanPhone(Phone humanPhone) {
        this.humanPhone = humanPhone;
    }

    public List<Laptop> getHumanLaptop() {
        return humanLaptop;
    }

    public void setHumanLaptop(List<Laptop> humanLaptop) {
        this.humanLaptop = humanLaptop;
    }

    public List<Car> getHumanCar() {
        return humanCar;
    }

    public void setHumanCar(List<Car> humanCar) {
        this.humanCar = humanCar;
    }
}
