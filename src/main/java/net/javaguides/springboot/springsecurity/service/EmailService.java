package net.javaguides.springboot.springsecurity.service;

import javax.mail.MessagingException;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {	
	public void sendEmail(SimpleMailMessage email);

}
