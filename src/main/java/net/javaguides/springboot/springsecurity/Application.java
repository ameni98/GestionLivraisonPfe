package net.javaguides.springboot.springsecurity;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.dialect.springdata.SpringDataDialect;

//import net.javaguides.springboot.springsecurity.config.ConfigMailSender;
import net.javaguides.springboot.springsecurity.model.Gouvernerat;
import net.javaguides.springboot.springsecurity.repository.RepositoryGover;
//import org.springframework.test.context.jdbc.Sql;


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
	
	}

