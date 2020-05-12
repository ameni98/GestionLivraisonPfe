package net.javaguides.springboot.springsecurity.web;

import java.io.InputStream;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.javaguides.springboot.springsecurity.config.SecurityConfiguration;
import net.javaguides.springboot.springsecurity.exception.RecordNotFoundException;
import net.javaguides.springboot.springsecurity.model.GenericResponse;
import net.javaguides.springboot.springsecurity.model.User;
//import net.javaguides.springboot.springsecurity.service.UserService;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

import  net.javaguides.springboot.springsecurity.model.OnRegistrationCompleteEvent;
import net.javaguides.springboot.springsecurity.model.SendEmail;
import net.javaguides.springboot.springsecurity.service.EmailService;
import net.javaguides.springboot.springsecurity.service.EmailServiceImpl;
import net.javaguides.springboot.springsecurity.service.UserService;
import net.javaguides.springboot.springsecurity.web.dto.ChangeProfilDto;
import net.javaguides.springboot.springsecurity.web.dto.PasswordDto;
import net.javaguides.springboot.springsecurity.web.dto.ResetPasswordDto;
@Controller
public class PasswordController {
	@Autowired
	private UserService userService;

	@Autowired
	private  EmailServiceImpl emailService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	// Display forgotPassword page
	@RequestMapping(value = "/forgot", method = RequestMethod.GET)
	public ModelAndView displayForgotPasswordPage() {
		return new ModelAndView("forgotPassword");
    }
    
    // Process form submission from forgotPassword page
	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public ModelAndView processForgotPasswordForm(ModelAndView modelAndView, @RequestParam("email") String userEmail, HttpServletRequest request) throws MessagingException {

		if( userEmail.equals(""))
		{	//System.out.print("azerty);
			modelAndView.addObject("errorMessage", "vous devez saisir votre adresse email !");
		 modelAndView.setViewName("forgotPassword");
		return modelAndView;

		
		}
		else {
		
		
		// Lookup user in database by e-mail
		User optional = userService.findUserByEmail(userEmail);
		
		Optional<User> userOptional = Optional.of(optional);
		if (!((Optional<User>) userOptional).isPresent()) {
			modelAndView.addObject("errorMessage", "We didn't find an account for that e-mail address.");
		} else {
			 StringBuilder requestURL = new StringBuilder(request.getRequestURL().toString());
			    String queryString = request.getQueryString();
			    System.out.print("bonjour"+queryString);
			
			// Generate random 36-character string token for reset password 
						User user = userOptional.get();
						user.setResetToken(UUID.randomUUID().toString());

						// Save token to database
						userService.save(user);

					//	String appUrl = request.getScheme() + "://"+request.getServerPort()+"/" + request.getServerName();
						String scheme = request.getScheme();             // http
					    String serverName = request.getServerName();     // hostname.com
					    int serverPort = request.getServerPort();        // 80
					   /* String contextPath = request.getContextPath();   // /mywebapp
					    String servletPath = request.getServletPath();   // /servlet/MyServlet
					    String pathInfo = request.getPathInfo();         // /a/b;c=123
					    String queryString1 = request.getQueryString();          // d=789*/
						String appUrl = request.getScheme() + "://"+request.getServerName()+":"+request.getServerPort();
						
					    
					    
					    // Reconstruct original requesting URL
					 /*   StringBuilder url = new StringBuilder();
					    url.append(scheme).append("://").append(serverName);

					    if (serverPort != 80 && serverPort != 443) {
					        url.append(":").append(serverPort);
					    }

					    url.append(contextPath).append(servletPath);

					    if (pathInfo != null) {
					        url.append(pathInfo);
					    }
					    if (queryString1 != null) {
					        url.append("?").append(queryString1);
					    }*/
					   
			
						
						// Email message
						SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
						//passwordResetEmail.setFrom("gouja.ameni@gmail.com");
						passwordResetEmail.setTo(user.getEmail());
						
						passwordResetEmail.setSubject("Password Reset Request");
						passwordResetEmail.setText("Pour réinitialiser votre mot de passe, cliquez sur le lien ci-dessous:\n" + appUrl
								+ "/reset?token=" + user.getResetToken());
						System.out.print("hello"+request.getScheme());
						emailService.sendEmail(passwordResetEmail);

						// Add success message to view
						modelAndView.addObject("successMessage", "Un lien de réinitialisation du mot de passe a été envoyé à cet email " + userEmail+" !");
					}

					modelAndView.setViewName("forgotPassword");
					return modelAndView;

				}
	}
				// Display form to reset password
				@RequestMapping(value = "/reset", method = RequestMethod.GET)
				public ModelAndView displayResetPasswordPage(ModelAndView modelAndView, @RequestParam("token") String token) {
					
					
					System.out.print("habelni"+token );
					Optional<User> user = userService.findUserByResetToken(token);

					if (user.isPresent()) { // Token found in DB
						modelAndView.addObject("resetToken", token);
						System.out.print("habelnibarcha");
					//	modelAndView.addObject("", token);
					} else { // Token not found in DB
						modelAndView.addObject("errorMessage", "Oops!  This is an invalid password reset link.");
					}

					modelAndView.setViewName("resetPassword");
					return modelAndView;
				}
				
				
				
				
				
				
				
				
				
				
				
				
				@RequestMapping(value = "/reset", method = RequestMethod.POST )
				    public @ResponseBody ResponseEntity<?>  afficherMessage(@RequestBody  ResetPasswordDto changePassword, RedirectAttributes redir,ModelAndView model) {
						String msg=null;
						 ServiceResponse<String>result = new ServiceResponse<>();
						 System.out.print("hallo"+changePassword.getConfirmPassword()+"\n");
						// System.out.print("pourqueoi"+changePassword.getPassword());
						String token=changePassword.getToken();
						 System.out.print("pourqueoi"+token);
						 Optional<User> user = userService.findUserByResetToken(token);
						// System.out.print("hallo"+user);
						 					// This should always be non-null but we check just in case
		if (user.isPresent()) {
			System.out.print("false");
			User resetUser = user.get();

			if (!changePassword.getPassword().equals(changePassword.getConfirmPassword())) {// System.out.print("false");
				System.out.print("crazy");
				ServiceResponse<String> result1 = new ServiceResponse<>("error", "incorrect");

				// result.setStatus("success");;
				// result.setMsg("votre mot de passe esr changé avec succée");
				// result.setData("votre mot de passe esr changé avec succée");
				System.out.print("crazy");
				return new ResponseEntity<>("Mot de passe de confirmation incorrect !", HttpStatus.EXPECTATION_FAILED);
			} else if (changePassword.getPassword()== "") {
				return new ResponseEntity<>("Veillez remplir tous les champs !", HttpStatus.EXPECTATION_FAILED);
			}

		
			// Set new password
			
			resetUser.setPassword(bCryptPasswordEncoder.encode(changePassword.getPassword()));

			// Set the reset token to null so it cannot be used again
			resetUser.setResetToken(null);

			// Save user
			userService.save(resetUser);
			//
			// In order to set a model attribute on a redirect, we must use
			redir.addFlashAttribute("successMessage", "You have successfully reset your password.  You may now login.");

			model.setViewName("redirect:login");
			//return model.;
			return new ResponseEntity<>("Hello World!", HttpStatus.OK);
		// RedirectAttributes
		

	}else

	{
		return new ResponseEntity<>("lien non trouve", HttpStatus.EXPECTATION_FAILED);
	}

	}
						 			   
			

				// Process reset password form
			/*	@RequestMapping(value = "/reset", method = RequestMethod.POST)
				public ModelAndView setNewPassword(ModelAndView modelAndView, @RequestParam Map<String,String> requestParams,@RequestParam String confirm, RedirectAttributes redir) {
					System.out.print("hallo"+requestParams);
					System.out.print("hallo"+requestParams.get("token"));
					// Find the user associated with the reset token
					Optional<User> user = userService.findUserByResetToken(requestParams.get("token"));
System.out.print("hallo"+user);
					// This should always be non-null but we check just in case
					if (user.isPresent()) {
						
						User resetUser = user.get(); 
			            
						if(requestParams.get("password")!=confirm)
						{System.out.print("false");
							modelAndView.addObject("errorMessageConfirm", "invalide mot de passe de confirmation!");
							 modelAndView.setViewName("resetPassword?token"+requestParams.get("token"));
							return modelAndView;
						}
						
						
						// Set new password    
			            resetUser.setPassword(bCryptPasswordEncoder.encode(requestParams.get("password")));
			            
						// Set the reset token to null so it cannot be used again
						resetUser.setResetToken(null);

						// Save user
						userService.save(resetUser);

						// In order to set a model attribute on a redirect, we must use
						// RedirectAttributes
						redir.addFlashAttribute("successMessage", "You have successfully reset your password.  You may now login.");

						modelAndView.setViewName("redirect:login");
						return modelAndView;
						
					} else {
						modelAndView.addObject("errorMessage", "Oops!  This is an invalid password reset link.");
						modelAndView.setViewName("resetPassword");	
					}
					
					return modelAndView;
			   }
			   */
			    // Going to reset page without a token redirects to login page
				@ExceptionHandler(MissingServletRequestParameterException.class)
				public ModelAndView handleMissingParams(MissingServletRequestParameterException ex) {
					return new ModelAndView("redirect:login");
				}
}
