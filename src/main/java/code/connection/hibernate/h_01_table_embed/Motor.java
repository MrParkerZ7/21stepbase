package code.connection.hibernate.h_01_table_embed;

import javax.persistence.Embeddable;

@Embeddable
public class Motor {

    private int piston;

    private int horsepower;

    public Motor(int piston, int horsepower) {
        this.piston = piston;
        this.horsepower = horsepower;
    }

    public Motor() {
    }

    public int getPiston() {
        return piston;
    }

    public void setPiston(int piston) {
        this.piston = piston;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "piston=" + piston +
                ", horsepower=" + horsepower +
                '}';
    }
}
