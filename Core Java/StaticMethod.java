class Mobile{
    int id;
    String name;
    static String type = "Telephone";

    public Mobile(){
        id = -1;
        name = "Mobile";
        System.out.println("In constructor");
    }

    static{
        int price = 50000;
        System.out.println("In static block");
    }


    void show(){
        System.out.println(id + " : " + name + " : " + type);
    }

    static void show1(Mobile mobile){
        System.out.println(mobile.id + " : " + mobile.name + " : " + type);
    }
}

public class StaticMethod {
    
    public static void main(String[] args){
        Mobile m1 = new Mobile();
        m1.id = 1;
        m1.name = "Apple";

        m1.show();
        Mobile.show1(m1);

        Mobile m2 = new Mobile();
        m2.id = 2;
        m2.name = "Samsung";

        m2.type = "Smartphone";

        m2.show();
        m2.show1(m2);
        m1.show1(m1);

    }

}
