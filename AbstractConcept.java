abstract class Car{
    public abstract void drive();


    public void playMusic(){
        System.out.println("Music is playing");
    }
}

class WagonR extends Car{ //concrete class
    public void drive(){
        System.out.println("Driving...");
    }
}


public class AbstractConcept {
    public static void main(String[] args){

        // you can not create object of a abstract class
        Car w = new WagonR();
        w.drive();
        w.playMusic();
    }
}
