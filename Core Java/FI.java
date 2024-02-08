
@FunctionalInterface
interface A{
    void show(int i);
}


public class FI {
   public static void main(String[] args) {
        A obj = i -> System.out.println("Show " + i);
        obj.show(5);
   }
}
