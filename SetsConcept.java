import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

public class SetsConcept {
    public static void main(String[] args) {
        Set<Integer> nums = new TreeSet<Integer>();
        nums.add(45);
        nums.add(3);
        nums.add(11);
        nums.add(90);

        Iterator<Integer> values = nums.iterator();
        while(values.hasNext())
            System.out.println(values.next());
    }
}
