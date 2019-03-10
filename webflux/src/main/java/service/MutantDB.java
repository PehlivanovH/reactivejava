package service;

import java.util.HashMap;
import java.util.Map;

public class MutantDB {
    public static Map<String, String> mapping = new HashMap();

    static {
        mapping.put("Erik", "Magneto");
        mapping.put("Logan", "Wolverine");
        mapping.put("Ororo", "Storm");
    }

    public static String get(String name) {
        return mapping.get(name);
    }
}
