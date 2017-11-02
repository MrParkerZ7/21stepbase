package code.connection.hibernate.table_relation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

    @Override
    public String toString() {
        return "Human{" +
                "humanId=" + humanId +
                ", humanName='" + humanName + '\'' +
                ", humanPhone=" + humanPhone +
                '}';
    }
}
