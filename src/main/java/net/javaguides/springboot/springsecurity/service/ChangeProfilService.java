package net.javaguides.springboot.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import net.javaguides.springboot.springsecurity.model.User;
import net.javaguides.springboot.springsecurity.repository.UserRepository;
import net.javaguides.springboot.springsecurity.web.dto.ChangeProfilDto;

//service changer profile pour l'admin
@Service
public class ChangeProfilService {

	@Autowired
	private UserRepository UserRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public User changePassword(ChangeProfilDto form) throws Throwable {
		
		//récupérer l'utilisateur connecté 
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails) principal).getUsername();
		
		//récupérer son email
		User user = UserRepository.findByEmail(username);

		//remplir le champ de formulaire avec email de cet utilisateur
		form.setEmail(user.getEmail());

		//récupérer le mot de passe sisie dans le formulaire
		String password = form.getPwdActuel();
		
		//récupérer le mot de passe de l'utilisateur à partir de la base mais qu'il est crypté
		String encodedPassword = user.getPassword();
		
		//on peut par cet méthode comparer un mot de passe saisie et un mot de passe crypté
		boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
		System.out.print(encodedPassword);
		
		//cette condition pour vérifier si les champs sont vides donc on affiche ce message 
		if ((form.getNewPassword() == "") && (form.getConfirmPassword() == "")) {
			throw new Exception("veuillez remplir le reste des champs");
		}

		//cette condition pour vérifier si le mot de passe saisie n'est pas conforme au mot de passe de la base 
		//donc on affiche ce message 
		if (isPasswordMatch == false) {
			throw new Exception("Mot de passe actuel inccorect");
		}
		
		//cette condition pour vérifier si le mot de passe actuel est conforme  au nouveau mot de passe saisie
		//donc on affiche ce message 		
		if (form.getPwdActuel().equals(form.getNewPassword())) {
			throw new Exception("le nouveau mot de passe et le mot passe actuel doivent etre différents ");
		}

		//cette condition pour vérifier si le mot de passe de confirmation n'est pas conforme au nouveau mot de passe saisie
		//donc on affiche ce message 				
		if (!form.getNewPassword().equals(form.getConfirmPassword())) {
			throw new Exception("Mot de passe de confirmation incorrect!");
		}

		user.setEmail(form.getEmail());

		user.setPassword(passwordEncoder.encode(form.getNewPassword()));
		return UserRepository.save(user);
	}
}
