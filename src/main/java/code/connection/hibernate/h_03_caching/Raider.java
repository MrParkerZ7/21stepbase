package code.connection.hibernate.h_03_caching;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name = "Raider_Table")
public class Raider {

    @Id
    @Column(name = "raider_id")
    private int raiderID;

    @Column(name = "raider_name")
    private String raiderName;

    @Column(name = "raider_couple")
    private boolean raiderCouple;

    public Raider() {
    }

    public Raider(int raiderID, String raiderName, boolean raiderCouple) {
        this.raiderID = raiderID;
        this.raiderName = raiderName;
        this.raiderCouple = raiderCouple;
    }

    public int getRaiderID() {
        return raiderID;
    }

    public void setRaiderID(int raiderID) {
        this.raiderID = raiderID;
    }

    public String getRaiderName() {
        return raiderName;
    }

    public void setRaiderName(String raiderName) {
        this.raiderName = raiderName;
    }

    public boolean isRaiderCouple() {
        return raiderCouple;
    }

    public void setRaiderCouple(boolean raiderCouple) {
        this.raiderCouple = raiderCouple;
    }

    @Override
    public String toString() {
        return "Raider{" +
                "raiderID=" + raiderID +
                ", raiderName='" + raiderName + '\'' +
                ", raiderCouple=" + raiderCouple +
                '}';
    }
}
