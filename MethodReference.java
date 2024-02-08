import java.util.*;

public class MethodReference {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Riya", "Raja", "Rehan");

        List<String> uNames = names.stream().map(String::toUpperCase).toList();

        
        uNames.forEach(System.out::println);
    }
}
