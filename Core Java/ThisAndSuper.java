class A{
    public A(){
        System.out.println("In A");
    }

    public A(int n){
        System.out.println("In A int");
    }
}


class B extends A{

    public B(){

        super(6);

        System.out.println("In B");
    }

    public B(int n){
        
        this();
        System.out.println("In B int");
    }
}



public class ThisAndSuper {
    public static void main(String[] args){
        B b = new B();
        B b1 = new B(10);
    }
}
