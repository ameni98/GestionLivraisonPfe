package net.javaguides.springboot.springsecurity.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.springsecurity.model.Marchand;
import net.javaguides.springboot.springsecurity.model.PasswordResetToken;
import net.javaguides.springboot.springsecurity.model.Role;
import net.javaguides.springboot.springsecurity.model.User;
import net.javaguides.springboot.springsecurity.repository.PasswordTokenRepository;
import net.javaguides.springboot.springsecurity.repository.UserRepository;
import net.javaguides.springboot.springsecurity.web.dto.ChangeProfilDto;
import net.javaguides.springboot.springsecurity.web.dto.MarchandRegistrationDto;
import net.javaguides.springboot.springsecurity.web.dto.UserRegistrationDto;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
   private PasswordTokenRepository passwordTokenRepository;

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

   /* public User save(UserRegistrationDto registration){
    	//Marchand marchand=new Marchand();
        User user = new User();
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }
*/
  //  Dans cette méthode, nous récupérons l’objet User à l’aide de DAO et, s’il existe, encapsulons-le 
    //dans un objet userDetail et le renoie:
    //vérifie la présence de cet user sil existe ou non sinon il affiche un message derreur)
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        else {//HttpSession session = null;
        // addUserInSession(user,session);
        // user.getId();
         
         
         /*userdetails.User utilisateur = new userdetails.User(login);
         
			utilisateur.setPassword(joueur.getPassword());
			utilisateur.setEnabled(joueur.isEnable());
			utilisateur.setIdJoueur(joueur.getIdJoueur());
			for (String role : joueur.getRoles()) {
				utilisateur.addAuthorities(role);
			}*/
         
         
         
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));}
    }
    
    
    
    
    
    
    /*public Long login(String email)  {
    	UserDetails user=loadUserByUsername(email);
    	user.
    	
        User user = userRepository.findByEmail(email);
      Long id=  user.getId();
      return id;
    }*/
   //     UserDetails
  /*      if (user != null){
        	  addUserInSession(user,httpsession);
        	    
        }*/
      
    
   
    
    
    /*private void addUserInSession(User u, HttpSession session) {
	    session.setAttribute("user", u);
	    session.setAttribute("userId", u.getId());
	    session.setAttribute("role", u.getRoles());}*/
    
    

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

	@Override
	public Marchand save(MarchandRegistrationDto register) {
		
		Marchand marchand=new Marchand();
		marchand.setNom(register.getNom());
		marchand.setPrenom(register.getPrenom());
		//marchand.setCodePostale(register.getCodePostale());
		marchand.setTel(register.getNumTel());
		marchand.setEmail(register.getEmail());
		  marchand.setPassword(passwordEncoder.encode(register.getPassword()));
		marchand.setRoles(Arrays.asList(new Role("ROLE_MARCHAND")));
		//marchand.setVille(register.getAdr);;
		
		//return user userRepository.save(user);
		
       /* User user = new User();
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        user.setRoles(Arrays.asList(new Role("ROLE_USER")));*/
        return userRepository.save(marchand);
	}
/*	private void addUserInSession(User u, HttpSession session) {
	    session.setAttribute("user", u);
	    session.setAttribute("userId", u.getId());
	    session.setAttribute("role", u.getRoles());*/

	@Override
	public Long getId(String email) {
		// TODO Auto-generated method stub
		User user=userRepository.findByEmail(email);
		
		return user.getId();
	}
	
	
	

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public Optional<User> findUserByResetToken(String resetToken) {
		return userRepository.findByResetToken(resetToken);
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

}
