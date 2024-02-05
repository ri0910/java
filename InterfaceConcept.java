
interface A {
    public int age = 25;
    public String name = "Riya"; // final and static variables

    void show();
    void hide();
}

interface X{
    void run();
}

interface Y extends X{

}

class B implements A, Y {

    public void hide() {
        System.out.println("Hiding...");
        
    }

    public void show() {
        System.out.println("Showing...");
        
    }

    public void run() {
        System.out.println("Running...");
    }
    
}


public class InterfaceConcept {
    
    public static void main(String[] args) {
        A b = new B();
        b.show();
        b.hide();
        B b1 = new B();
        b1.run();
    }

}
