
class Human{
    private int age;
    private String name;
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    
}


public class Encapsulation {
    
    public static void main(String[] args){
        Human h1 = new Human();
        h1.setAge(18);
        h1.setName("Riya");
        System.out.println(h1.getAge() + " " + h1.getName());
    }
    
}
