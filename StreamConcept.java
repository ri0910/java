import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamConcept {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        
        // Stream<Integer> stream = l.stream();
        // Stream<Integer> s1 = stream.filter(n -> n%2 ==0);
        // Stream<Integer> s2 = s1.map(n -> n*2);
        // int result = s2.reduce(0, (c,e) -> c+e);

        //filter -> predicate -> test method -> boolean
        // map -> Function -> apply method -> integer


        int result = l.stream().filter(n -> n%2==0).map(n -> n*2).reduce(0, (c,e) -> c+e);
        System.out.println(result);

        List<Integer> l1 = Arrays.asList(23, 44, 65, 12, 0, 22, 26, 54, 9, 8);

        Stream<Integer> stream = l1.stream().filter(n -> n%2 == 0).sorted();
        stream.forEach(System.out::println);

    }
}
