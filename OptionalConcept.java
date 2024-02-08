import java.util.*;

public class OptionalConcept {
    // Optional class avoid nullpointerexception for string
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Riya", "Rohan", "Ranbir", "Don");

        Optional<String> name = names.stream().filter(str -> str.contains("c")).findFirst();

        // avoid NoSuchElementException
        System.out.println(name.orElse("Not Found"));
    }
}
