package code.connection.hibernate.h_02_table_relation;

import javax.persistence.*;
import java.util.List;

@Entity
public class Human {

    @Id
    @Column(name = "human_id")
    private int humanId;

    @Column(name = "human_name")
    private String humanName;

    @OneToOne
    private Phone humanPhone;

    @OneToMany(mappedBy = "laptopHuman")
    private List<Laptop> humanLaptop;

    // FetchType.EAGER using for fetch all of data not matter we gonna use or not.
    // By default, It's not fetch because humanLaptop was mapped by another table
    // The data still can be fetch. If connection was's close.
    @ManyToMany(fetch = FetchType.EAGER)
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


    @Override
    public String toString() {
        return "Human{" +
                "humanId=" + humanId +
                ", humanName='" + humanName + '\'' +
                ", humanPhone=" + humanPhone +
                ", humanLaptop=" + humanLaptop +
                ", humanCar=" + humanCar +
                '}';
    }
}
