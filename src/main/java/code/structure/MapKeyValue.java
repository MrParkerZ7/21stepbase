package code.structure;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapKeyValue {

    public static void main(String[] args) {
        map();

    }

    private static void map() {
        Map<String, Integer> member = new HashMap<>();
        member.put("Park", 23);
        member.put("Mark", 24);
        member.put("Rark", 27);

        Set<String> keys = member.keySet();

        for (String key : keys) {
            System.out.println(key + " " + member.get(key)); }

    }

}
