package code.connection.hibernate.table_relation;

import javax.persistence.*;
import java.util.List;

@Entity
public class Car {

    @Id
    @Column(name = "CAR_ID")
    private int carId;

    @Column(name = "CAR_MODEL")
    private String carModel;

    @ManyToMany(mappedBy = "humanCar")
    private List<Human> carHuman;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public List<Human> getCarHuman() {
        return carHuman;
    }

    public void setCarHuman(List<Human> carHuman) {
        this.carHuman = carHuman;
    }
}
