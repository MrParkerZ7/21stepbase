package code.connection.hibernate.table_inside;

import javax.persistence.*;

@Entity
@Table(name = "motor_bike") // Define different name on database.
public class Motorcycle {

    @Id
    @GeneratedValue
    private int no;

    @Transient // Deprecate this column.
    private String brand;

    // Default.
    private String model;

    private Motor motor;

    @Column(name = "type") // Define different name on database.
    private String style;

    @Column(name = "year")
    private int version;

    @Column(name = "information")
    private String detail;

    @Override
    public String toString() {
        return "Motorcycle{" +
                "no=" + no +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", style='" + style + '\'' +
                ", version=" + version +
                ", detail='" + detail + '\'' +
                '}';
    }
}
