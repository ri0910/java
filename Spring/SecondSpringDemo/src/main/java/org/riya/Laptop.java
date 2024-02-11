package org.riya;

public class Laptop implements Computer{
    public Laptop() {
    }

    @Override
    public void compile(){
        System.out.println("Compiling using laptop...");
    }
}
