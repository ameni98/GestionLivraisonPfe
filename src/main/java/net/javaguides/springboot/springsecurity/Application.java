package net.javaguides.springboot.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.dialect.springdata.SpringDataDialect;


//SpringBootApplication c'est une classe java par déafaut pour la configuaration automatique de spring et automatiquement scanner (Scan)
//le projet intégral afin de découvrir des composants de  Spring (Controller, Bean, Service,...)elle regroupe tous 
//ces annotation(@Configuration,@EnableAutoConfiguration,@ComponentScan)
@SpringBootApplication
public class Application  {
	
	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);	
	}
	//ajouter un dialect spring 
	@Bean
	public SpringDataDialect springDataDialect() {
		return new SpringDataDialect();
	}
	
	//ajouter un dialect spring 
	/*@Bean
	public org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect SpringSecurityDialect() {
		return new org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect();
	}*/
	
	}

