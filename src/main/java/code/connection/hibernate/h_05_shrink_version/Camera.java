package code.connection.hibernate.h_05_shrink_version;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Camera_System")
public class Camera {

    @Id
    private int id;
    private String brand;
    private String version;
    private float censor;

    public Camera() {
    }

    public Camera(int id, String brand, String version, float censor) {
        this.id = id;
        this.brand = brand;
        this.version = version;
        this.censor = censor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public float getCensor() {
        return censor;
    }

    public void setCensor(float censor) {
        this.censor = censor;
    }

    @Override
    public String toString() {
        return "Camera{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", version='" + version + '\'' +
                ", censor=" + censor +
                '}';
    }
}
