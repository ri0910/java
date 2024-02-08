class Human{
    int age;
    String name;

    public Human(){
        this.age = 15;
        this.name = "None";
    }

    public Human(String name){
        this.name = name;
    }
    
}


public class DefaultAndParameterizedCons {
    
    public static void main(String[] args){
        Human h1 = new Human();
        System.out.println(h1.age + " " + h1.name);
        Human h2 = new Human("Riya");
        System.out.println(h2.age + " " + h2.name);
    }
}
