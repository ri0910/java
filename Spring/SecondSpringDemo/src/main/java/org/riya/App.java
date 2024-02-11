package org.riya;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Creating a container for objects. This is xml config way to create a spring project without spring boot.
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        Alien obj1 = (Alien) context.getBean("alien");
        Alien obj1 = context.getBean("alien", Alien.class);
        //obj1.age = 21;
        //System.out.println(obj1.getAge());
        obj1.code();


        //Alien obj2 = (Alien) context.getBean("alien");
        //System.out.println(obj2.getAge());
        //obj2.code();

        // By lazy initialization, constructor of desktop will be called when it is required.
        Desktop obj2 = (Desktop) context.getBean("des");


    }
}
