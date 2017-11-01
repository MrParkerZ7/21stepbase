package code.pattern;

import java.util.ArrayList;
import java.util.List;

public class CompositePattern {

    public static void main(String[] args) {
        // Controller
        Component mouse = new Leaf("Mouse", "Click!");
        Component keyboard = new Leaf("KeyBord", "Pass literal");
        Component monitor = new Leaf("Monitor", "Show screen");

        Composite controller = new Composite("Controller");
        controller.setComponent(mouse);
        controller.setComponent(keyboard);
        controller.setComponent(monitor);

        // Hard ware
        Component hdd = new Leaf("HDD", "Store data");
        Component ram = new Leaf("Ram", "Memories");
        Component cpu = new Leaf("CPU", "Process");
        Component vga = new Leaf("VGA", "Display");

        Composite mainBoard = new Composite("MainBoard");
        mainBoard.setComponent(ram);
        mainBoard.setComponent(cpu);
        mainBoard.setComponent(vga);

        Composite hardWare = new Composite("Machine");
        hardWare.setComponent(mainBoard);
        hardWare.setComponent(hdd);

        // Computer
        Composite computer = new Composite("Computer");
        computer.setComponent(hardWare);
        computer.setComponent(mainBoard);
        computer.setComponent(controller);

        { // Show system
            computer.showJob();
        }
    }
}

interface Component {

    void showJob();

}

class Leaf implements Component {
    private String system;
    private String execute;

    public Leaf(String system, String execute) {
        this.system = system;
        this.execute = execute;
    }

    @Override
    public void showJob() {
        System.out.println("-" + system + ": " + execute);
    }
}

class Composite implements Component {
    private String system;
    private List<Component> consist = new ArrayList<>();

    public Composite(String system) {
        this.system = system;
    }

    public void setComponent(Component c) {
        this.consist.add(c);
    }

    @Override
    public void showJob() {
        System.out.println(system);
        for (Component c : consist)
            c.showJob();
    }
}