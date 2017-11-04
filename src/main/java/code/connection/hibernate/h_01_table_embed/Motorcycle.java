package code.connection.hibernate.h_01_table_embed;

import javax.persistence.*;

@Entity
@Table(name = "Motor_Bike") // Define different name on database.
public class Motorcycle {

    @Id
    private int no;

    private String brand;

    // Default.
    private String model;

    private Motor motor;

    private String spec;

    @Column(name = "type") // Define different name on database.
    private String style;

    @Column(name = "year")
    private int version;

    @Transient // Deprecate this column.
    @Column(name = "information")
    private String detail;

    public Motorcycle() {

    }

    public Motorcycle(int no, String brand, String model, Motor motor, String spec, String style, int version, String detail) {
        this.no = no;
        this.brand = brand;
        this.model = model;
        this.motor = motor;
        this.spec = spec;
        this.style = style;
        this.version = version;
        this.detail = detail;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "MotorBike{" +
                "no=" + no +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", motor=" + motor +
                ", style='" + style + '\'' +
                ", version=" + version +
                ", detail='" + detail + '\'' +
                '}';
    }
}
