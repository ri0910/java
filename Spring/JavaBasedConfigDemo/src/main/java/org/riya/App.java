package org.riya;

import org.riya.Config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        
        Alien obj = context.getBean(Alien.class);
        obj.code();
        System.out.println(obj.getAge());

//        Desktop dt = context.getBean("desktop", Desktop.class);
//        dt.compile();
//        
//        Desktop dt1 = context.getBean("desktop", Desktop.class);
//        dt1.compile();
    }
}
