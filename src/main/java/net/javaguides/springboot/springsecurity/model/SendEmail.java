package net.javaguides.springboot.springsecurity.model;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class SendEmail {
	private JavaMailSender mailSender;

public void setMailSender(JavaMailSender mailSender) {
    this.mailSender = mailSender;
}

public void send(String to, String subject, String text){

    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(to);
    message.setSubject(subject);
    message.setText(text);
    mailSender.send(message);
  }


}
