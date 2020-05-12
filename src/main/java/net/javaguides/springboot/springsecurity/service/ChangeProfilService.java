package net.javaguides.springboot.springsecurity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import net.javaguides.springboot.springsecurity.model.User;
import net.javaguides.springboot.springsecurity.repository.UserRepository;
import net.javaguides.springboot.springsecurity.web.dto.ChangeProfilDto;

@Service
public class ChangeProfilService {

@Autowired
private UserRepository UserRepository;
@Autowired
private BCryptPasswordEncoder passwordEncoder;

public User changePassword(ChangeProfilDto form) throws Throwable{
/*User storedUser = UserRepository
.findById( form.getId() )
.orElseThrow(() -> new Exception("UsernotFound in ChangePassword -"+this.getClass().getName()));*/
	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	   String username = ((UserDetails)principal).getUsername();  
	  User user= UserRepository.findByEmail(username);
		long id= user.getId();	
form.setEmail(user.getEmail());
System.out.print("aaaa    "+form.getPwdActuel());		
//System.out.print("bbbb        "+passwordEncoder.(user.getPassword()));
String password=form.getPwdActuel();
String encodedPassword=user.getPassword();
boolean isPasswordMatch = passwordEncoder.matches(password,encodedPassword);
	
if((form.getNewPassword()=="")&&(form.getConfirmPassword()==""))
{
	throw new Exception("veuillez remplir le reste des champs");
}

if(isPasswordMatch==false) {
throw new Exception("Mot de passe actuel inccorect");
}

//if(form.getPwdActuel().equ)


if (form.getPwdActuel().equals(form.getNewPassword())) {
throw new Exception("le nouveau mot de passe et le mot passe actuel doivent etre différents ");
}

if( !form.getNewPassword().equals(form.getConfirmPassword())) {
throw new Exception("Mot de passe de confirmation incorrect!");
}

user.setEmail(form.getEmail());
System.out.print("hello"+form.getEmail());
user.setPassword(passwordEncoder.encode(form.getNewPassword()));
return UserRepository.save(user);
}
}


