class A{
    public void show(){
        System.out.println("In A show");
    }
}

public class AnonymousClass {
    public static void main(String[] args) {
        A obj = new A(){
            public void show(){
                System.out.println("In New Show");
            }
        };
        obj.show();
    }
}
