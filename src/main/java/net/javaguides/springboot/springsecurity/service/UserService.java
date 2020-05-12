package net.javaguides.springboot.springsecurity.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.javaguides.springboot.springsecurity.model.Marchand;
import net.javaguides.springboot.springsecurity.model.User;
import net.javaguides.springboot.springsecurity.web.dto.ChangeProfilDto;
import net.javaguides.springboot.springsecurity.web.dto.MarchandRegistrationDto;
import net.javaguides.springboot.springsecurity.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
//L’interface UserDetailsService est utilisée pour récupérer des données relatives à l’utilisateur. 
//Il possède une méthode appelée loadUserByUsername () qui trouve une entité utilisateur en fonction du nom d’utilisateur
//et peut être remplacée pour personnaliser le processus de recherche de l’utilisateur.

	//DaoAuthenticationProvider l’utilise pour charger les détails concernant l’utilisateur au cours de l’authentification.
    User findByEmail(String email);

  //  User save(UserRegistrationDto registration);
    
    Long getId(String email);
    Marchand save(MarchandRegistrationDto register);
   /* public User changeProfile(ChangeProfilDto form) throws Exception;
    public User findById(long id) throws Exception;*/
 
  public User findUserByEmail(String email);
   public Optional<User> findUserByResetToken(String resetToken);
   public void save(User user);
}
