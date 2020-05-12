package net.javaguides.springboot.springsecurity.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/*@Configuration
public class ConfigMailSender {

    @Bean
       public JavaMailSender getMailSender(){
           JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

           //Using gmail
           mailSender.setHost("smtp.xxx.com");
           mailSender.setPort(587);
           mailSender.setUsername("xxxxxx@gmail.com");
           mailSender.setPassword("xxxxxx");

           Properties javaMailProperties = new Properties();
           javaMailProperties.put("mail.smtp.starttls.enable", "true");
           javaMailProperties.put("mail.smtp.auth", "true");
           javaMailProperties.put("mail.transport.protocol", "smtp");
           javaMailProperties.put("mail.debug", "true");//Prints out everything on screen
           javaMailProperties.put("mail.smtp.starttls.required","true");
           mailSender.setJavaMailProperties(javaMailProperties);
           return mailSender;
       }

}*/