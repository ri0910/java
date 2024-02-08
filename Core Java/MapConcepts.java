import java.util.*;

public class MapConcepts {
    public static void main(String[] args) {
        // Hashmap and HashTable(synchronized)

        Map<String, Integer> map = new Hashtable<String, Integer>();
        map.put("Riya", 100);
        map.put("Aniket", 100);
        map.put("Raya", 200);

        for(String key : map.keySet()){
            System.out.println(key + " : "+ map.get(key));
        }
    }
}
