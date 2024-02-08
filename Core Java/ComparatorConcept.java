import java.util.*;

public class ComparatorConcept {
    public static void main(String[] args) {

        Comparator<String> comp = (String i, String j) -> {
            if(i.length()>j.length()){
                return 1;
            }
            else{
                return -1;
            }
        };


        List<String> l = new ArrayList<String>();
        l.add("owl");
        l.add("elephant");
        l.add("tiger");
        l.add("peacock");
        l.add("mammal");

        Collections.sort(l, comp);
        System.out.println(l);
    }
}
