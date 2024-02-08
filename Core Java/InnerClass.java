class A{
    public int id;
    public void show(){
        System.out.println("In show");
    }

    static class B{
        public void play(){
            System.out.println("Playing..");
        }
    }
}


public class InnerClass {
    public static void main(String[] args) {
        A.B obj = new A.B();
        obj.play();
    }
}
