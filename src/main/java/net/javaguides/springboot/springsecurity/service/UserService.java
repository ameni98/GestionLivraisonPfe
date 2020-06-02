package net.javaguides.springboot.springsecurity.service;

import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetailsService;
import net.javaguides.springboot.springsecurity.model.Marchand;
import net.javaguides.springboot.springsecurity.model.User;
import net.javaguides.springboot.springsecurity.web.dto.MarchandRegistrationDto;

public interface UserService extends UserDetailsService {
//L’interface UserDetailsService est utilisée pour récupérer des données relatives à l’utilisateur. 
//Il possède une méthode appelée loadUserByUsername () qui trouve une entité utilisateur en fonction du nom d’utilisateur
//et peut être remplacée pour personnaliser le processus de recherche de l’utilisateur.

	// DaoAuthenticationProvider l’utilise pour charger les détails concernant
	// l’utilisateur au cours de l’authentification.
	User findByEmail(String email);

	Long getId(String email);

	Marchand save(MarchandRegistrationDto register);

	User findUserByEmail(String email);

	Optional<User> findUserByResetToken(String resetToken);

	void save(User user);
}
