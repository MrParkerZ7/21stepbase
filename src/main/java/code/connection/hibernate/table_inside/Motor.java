package code.connection.hibernate.table_inside;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Motor {

    private int piston;

    @Column(name = "HighPerformanceCycle")
    private String performanceCycle;

    private int horsepower;

}
