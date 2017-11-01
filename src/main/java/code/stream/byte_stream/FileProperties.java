package code.stream.byte_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileProperties {
    private static int saveState = 0;
    private static String path = "MaxProper.properties";

    public static void main(String[] args) {
        FileProperties fp = new FileProperties();
        fp.createProp();
        fp.showInfo();
        fp.addProp("MotorBike,Kawasaki", "Phone,Apple", "Laptop,Lenovo"); // It's still replace all old properties
    }

    void createProp() { // Initial information
        Properties p = new Properties();
        p.setProperty("User", "Park");
        p.setProperty("Pass", "1234");
        saveProp(p);
    }

    void addProp(String... props) {
        Properties p = new Properties(getProp());
        String[] keyValue;
        for (String prop : props) {
            keyValue = prop.split(",");
            p.setProperty(keyValue[0], keyValue[1]);
        }
        saveProp(p);
    }

    void showInfo() {
        Properties p = new Properties(getProp());
        p.list(System.out);
    }

    Properties getProp() {
        try (FileInputStream fileIn = new FileInputStream(this.path)) {
            Properties p = new Properties();
            p.load(fileIn);
            return p;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    void saveProp(Properties p) {
        try (FileOutputStream fileOut = new FileOutputStream(this.path)) {
            p.store(fileOut, "Save: " + (++this.saveState) + "th");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
