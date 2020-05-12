package net.javaguides.springboot.springsecurity.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.springsecurity.model.Marchand;
import net.javaguides.springboot.springsecurity.model.Role;
import net.javaguides.springboot.springsecurity.model.User;
import net.javaguides.springboot.springsecurity.repository.UserRepository;
import net.javaguides.springboot.springsecurity.web.dto.MarchandRegistrationDto;
import net.javaguides.springboot.springsecurity.web.dto.UserRegistrationDto;

/*@Service
public class MarchandService implements UserService {

	 @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private BCryptPasswordEncoder passwordEncoder;

	    public User findByEmail(String email){
	        return userRepository.findByEmail(email);
	    }

	    public User save(UserRegistrationDto registration){
	    	Marchand marchand=new Marchand();
	    	
	    	
	    	//marchand.setFirstName(registration.getNom());
	    	
	    	
	       /* user.setFirstName(registration.getFirstName());
	        user.setLastName(registration.getLastName());
	        user.setEmail(registration.getEmail());
	        user.setPassword(passwordEncoder.encode(registration.getPassword()));
	        user.setRoles(Arrays.asList(new Role("ROLE_USER")));*/
	      /*  return userRepository.save(marchand);
	    }
	  //  Dans cette méthode, nous récupérons l’objet User à l’aide de DAO et, s’il existe, encapsulons-le 
	    //dans un objet userDetail et le renoie:
	    //vérifie la présence de cet user sil existe ou non sinon il affiche un message derreur)
	    @Override
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	        User user = userRepository.findByEmail(email);
	        if (user == null){
	            throw new UsernameNotFoundException("Invalid username or password.");
	        }
	        return new org.springframework.security.core.userdetails.User(user.getEmail(),
	                user.getPassword(),
	                mapRolesToAuthorities(user.getRoles()));
	    }

	    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
	        return roles.stream()
	                .map(role -> new SimpleGrantedAuthority(role.getName()))
	                .collect(Collectors.toList());
	    }

	/*	@Override
		public User save(UserRegistrationDto registration) {
			// TODO Auto-generated method stub
			return null;
		}
	
}*/