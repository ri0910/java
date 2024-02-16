package org.riya.ServeletEx;


import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws LifecycleException
    {
        System.out.println( "Hello World!" );
        Tomcat tomcat = new Tomcat();
        tomcat.getConnector();
        Context context = tomcat.addContext("", null);
        Tomcat.addServlet(context, "HelloServer", new HelloServer());
        context.addServletMappingDecoded("/hello", "HelloServer");
        tomcat.start();
        tomcat.getServer().await();
    }
}
