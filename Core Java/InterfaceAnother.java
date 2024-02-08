interface Computer{
    void code();
}

class Desktop implements Computer{
    public void code() {
        System.out.println("This is a desktop...");
    }
}

class Laptop implements Computer{
    public void code() {
        System.out.println("This is a laptop...");
    }
}

class Developer {
    public void devApp(Computer comp){
        comp.code();
    }
}


public class InterfaceAnother {
    
    public static void main(String[] args) {
        Computer comp = new Desktop();
        Computer comp2 = new Laptop();
        Developer dev = new Developer();

        dev.devApp(comp);
        dev.devApp(comp2);
    }

}
