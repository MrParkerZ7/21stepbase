package code.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Using concept of prototype pattern
 * and cloning concept
 */

public class PrototypePattern {

    public static void main(String[] args) throws CloneNotSupportedException {
        GroupRaider gr1;
        { // Assume we download data from server.
            Raider r1 = new Raider(101, "Park", "S1000RR", false);
            Raider r2 = new Raider(102, "Macro", "ZX10R", true);
            Raider r3 = new Raider(103, "Hunt", "GSX1000R", false);
            gr1 = new GroupRaider("Prank Raider", r1, r2, r3);
        }

        GroupRaider gr2;
        { // Clone object by using gr1 as prototype.
            gr2 = (GroupRaider) gr1.clone();
        }

        { // Change detail with no reflection.
            gr2.removeRaider(1);
            gr2.setGroupName("Doom Raider");
        }

        System.out.println(gr2);
        System.out.println(gr1);
    }
}

class Raider {
    private int no;
    private String name;
    private String motocycle;
    private boolean couple;

    public Raider(int no, String name, String motocycle, boolean couple) {
        this.no = no;
        this.name = name;
        this.motocycle = motocycle;
        this.couple = couple;
    }

    @Override
    public String toString() {
        return "Raider{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", motocycle='" + motocycle + '\'' +
                ", couple=" + couple +
                '}';
    }
}

class GroupRaider implements Cloneable {
    private String groupName;
    private List<Raider> raiders = new ArrayList<>();

    public GroupRaider() {
    }

    public GroupRaider(String groupName, Raider... raiders) {
        this.groupName = groupName;
        for (Raider r : raiders)
            this.raiders.add(r);
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void addRaider(Raider r) {
        raiders.add(r);
    }

    public void removeRaider(int position) {
        raiders.remove(position);
    }

    @Override
    protected GroupRaider clone() throws CloneNotSupportedException {
        GroupRaider cloneGP = new GroupRaider();
        cloneGP.setGroupName(this.groupName);
        for (Raider r : raiders)
            cloneGP.addRaider(r);
        return cloneGP;
    }

    @Override
    public String toString() {
        return "GroupRaider{" +
                "groupName='" + groupName + '\'' +
                ", raiders=" + raiders +
                '}';
    }
}