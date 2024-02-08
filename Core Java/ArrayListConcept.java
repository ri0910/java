import java.util.ArrayList;
import java.util.List;

public class ArrayListConcept {
   public static void main(String[] args) {
        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        System.out.println(l.get(2));
        System.out.println(l);
        System.out.println(l.set(0, 11));
        System.out.println(l);
   }
}
