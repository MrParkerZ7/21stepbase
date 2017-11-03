package code.connection.hibernate.table_relation;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

public class Car {

    @Id
    private int carId;
    private String carModel;
    @ManyToMany
    private List<Human> carHuman;


    public Car() {
    }

    public Car(int carId, String carModel, List<Human> carHuman) {
        this.carId = carId;
        this.carModel = carModel;
        this.carHuman = carHuman;
    }

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
