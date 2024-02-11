package org.riya.Config;


import org.riya.Desktop;
import org.riya.Laptop;
import org.riya.Alien;
import org.riya.Computer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("org.riya")
public class AppConfig {
	
//	@Bean
//	public Alien alien( Computer com){//@Qualifier("desktop")
//		
//		Alien al = new Alien();
//		al.setAge(25);
//		al.setCom(com);
//		return al;
//		
//	}
//
//	//@Bean(name="com")
//    @Bean
//    //@Scope("prototype")
//    public Desktop desktop(){
//        return new Desktop();
//    }
//    
//    @Bean
//    @Primary
//    public Laptop laptop(){
//        return new Laptop();
//    }
}
