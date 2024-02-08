// An enum is a special "class" that represents a group of constants (unchangeable variables, like final variables).

enum Status{
    Running, Succeeded, Failed
}

enum Laptop{

    // Objects
    Macbook(2000), XPS(1500), Surface, ThinkPad(1800);

    private int price;

    

    private Laptop() {
        price = 500;
    }



    private Laptop(int price) {
        this.price = price;
    }



    public int getPrice() {
        return price;
    }



    public void setPrice(int price) {
        this.price = price;
    }

    
}


public class EnumConcept {
    public static void main(String[] args) {
        Status s = Status.Running;
        System.out.println(s);
        Status ss = Status.Succeeded;
        System.out.println(ss.ordinal());
        Status[] ss2 = Status.values();

        for(Status st : ss2){
            System.out.println(st + ": " + st.ordinal());
        }

        Status status = Status.Succeeded;

        switch (status) {
            case Running:
                System.out.println("All Good!");
                break;
            case Succeeded:
                System.out.println("Done!");
                break;
            case Failed:
                System.out.println("Failed!");
                break;
            default:
                System.out.println("Nothing to do!");
                break;
        }


        for(Laptop lap: Laptop.values()){
            System.out.println(lap + " : " + lap.getPrice());
        }
    }
}
