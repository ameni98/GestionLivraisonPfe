package net.javaguides.springboot.springsecurity.web;

import java.util.Optional;
import java.util.UUID;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import net.javaguides.springboot.springsecurity.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import net.javaguides.springboot.springsecurity.service.EmailServiceImpl;
import net.javaguides.springboot.springsecurity.service.UserService;
import net.javaguides.springboot.springsecurity.web.dto.ResetPasswordDto;

@Controller
public class PasswordController {
	@Autowired
	private UserService userService;

	@Autowired
	private EmailServiceImpl emailService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	// afficher forgotPassword page
	@RequestMapping(value = "/forgot", method = RequestMethod.GET)
	public ModelAndView displayForgotPasswordPage() {
		return new ModelAndView("forgotPassword");
	}

	// Soumettre le formulaire à partir de la page Mot de passe oublié
	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public ModelAndView processForgotPasswordForm(ModelAndView modelAndView, @RequestParam("email") String userEmail,
			HttpServletRequest request) throws MessagingException {

		// si le champ email est vide on affiche ce message
		if (userEmail.equals("")) {
			modelAndView.addObject("errorMessage", "vous devez saisir votre adresse email !");
			modelAndView.setViewName("forgotPassword");
			return modelAndView;

		} else {

			// Rechercher un utilisateur dans la base de données par e-mail
			User optional = userService.findUserByEmail(userEmail);

			Optional<User> userOptional = Optional.of(optional);
			if (!((Optional<User>) userOptional).isPresent()) {
				// si l'email n'est pas trouvé on affiche ce message
				modelAndView.addObject("errorMessage", "on n'a pas trouvé un utilisateur avec cet email.");
			} else {
				// Generate random 36-character string token for reset password
				User user = userOptional.get();
				user.setResetToken(UUID.randomUUID().toString());

				// enregistrer token dans la base
				userService.save(user);

				// former l'url
				String appUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();

				// Email message
				SimpleMailMessage passwordResetEmail = new SimpleMailMessage();

				// indiquer à quel utilisateur on va envoyer le lien
				passwordResetEmail.setTo(user.getEmail());

				// indiquer le sujet
				passwordResetEmail.setSubject("réinitialisation de mot passe");
				passwordResetEmail.setText("Pour réinitialiser votre mot de passe, cliquez sur le lien ci-dessous:\n"
						+ appUrl + "/reset?token=" + user.getResetToken());

				emailService.sendEmail(passwordResetEmail);

				// ajouter un message de success à la vue
				modelAndView.addObject("successMessage",
						"Un lien de réinitialisation du mot de passe a été envoyé à cet email " + userEmail + " !");
			}

			modelAndView.setViewName("forgotPassword");
			return modelAndView;

		}
	}

	// affichage le form de réinisialisation de mot de passe
	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	public ModelAndView displayResetPasswordPage(ModelAndView modelAndView, @RequestParam("token") String token) {

		Optional<User> user = userService.findUserByResetToken(token);

		if (user.isPresent()) {
			// token trouvé dans la base
			modelAndView.addObject("resetToken", token);

		} else {
			modelAndView.addObject("errorMessage", "Oops! c'est un lien invalide de réinitialisation de mot de passe.");
		}

		modelAndView.setViewName("resetPassword");
		return modelAndView;
	}

	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> afficherMessage(@RequestBody ResetPasswordDto changePassword,
			RedirectAttributes redir, ModelAndView model) {

		String token = changePassword.getToken();
		Optional<User> user = userService.findUserByResetToken(token);

		// si user existe
		if (user.isPresent()) {

			User resetUser = user.get();

			if (!changePassword.getPassword().equals(changePassword.getConfirmPassword())) {
				return new ResponseEntity<>("Mot de passe de confirmation incorrect !", HttpStatus.EXPECTATION_FAILED);
			} else if (changePassword.getPassword() == "") {
				return new ResponseEntity<>("Veillez remplir tous les champs !", HttpStatus.EXPECTATION_FAILED);
			}

			// Set le nouveau mot de passe

			resetUser.setPassword(bCryptPasswordEncoder.encode(changePassword.getPassword()));

			// Set token null et on peut don l'utiliser une autre fois
			resetUser.setResetToken(null);

			// enregistrer le user
			userService.save(resetUser);
			//
			/*
			 * In order to set a model attribute on a redirect, we must use
			 * redir.addFlashAttribute("successMessage",
			 * "You have successfully reset your password.  You may now login.");
			 */

			model.setViewName("redirect:login");

			return new ResponseEntity<>("Hello World!", HttpStatus.OK);
			// RedirectAttributes

		} else

		{
			return new ResponseEntity<>("lien non trouve", HttpStatus.EXPECTATION_FAILED);
		}

	}

	// Going to reset page without a token redirects to login page
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ModelAndView handleMissingParams(MissingServletRequestParameterException ex) {
		return new ModelAndView("redirect:login");
	}
}
