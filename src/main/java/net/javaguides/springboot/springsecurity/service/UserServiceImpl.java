package net.javaguides.springboot.springsecurity.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import net.javaguides.springboot.springsecurity.model.Marchand;
import net.javaguides.springboot.springsecurity.model.Role;
import net.javaguides.springboot.springsecurity.model.User;
import net.javaguides.springboot.springsecurity.repository.UserRepository;
import net.javaguides.springboot.springsecurity.web.dto.MarchandRegistrationDto;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
 

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
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
        else {
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));}
    }
    
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
		marchand.setTel(register.getNumTel());
		marchand.setEmail(register.getEmail());
		marchand.setAdresse(register.getAdresse());
		  marchand.setPassword(passwordEncoder.encode(register.getPassword()));
		marchand.setRoles(Arrays.asList(new Role("ROLE_MARCHAND")));
        return userRepository.save(marchand);
	}

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
