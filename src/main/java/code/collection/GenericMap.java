package code.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GenericMap {

    public static void main(String[] args) {
        Map<String, Object> personal = new HashMap<>();
        personal.put("Name", "Park");
        personal.put("No", 5);
        personal.put("Location", 105.2354);
        personal.put("Vehicla", "S1000RR");
        personal.put("Job", "empty");

        { // Method one
            Set<String> keys = personal.keySet();
            for (Object i : keys)
                System.out.println(i + " " + personal.get(i));
        }

        System.out.println();

        { // Method two
            Set<Map.Entry<String, Object>> values = personal.entrySet();
            for (Map.Entry<String, Object> e : values) {
                System.out.println(e.getKey() + " " + e.getValue());
                e.setValue("Park");
                System.out.println(e.getKey() + " " + e.getValue());
            }
        }
    }
}
