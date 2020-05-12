
package net.javaguides.springboot.springsecurity.service;

import java.sql.Array;import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.springsecurity.model.Marchand;
import net.javaguides.springboot.springsecurity.repository.DemandeJoinRepository;
import net.javaguides.springboot.springsecurity.web.dto.DemandeJoinDto;

@Service
public class DemandeJoinService {
	@Autowired
	private DemandeJoinRepository joinRepository;

	public List<DemandeJoinDto> AffichageDemandeDestination() {
	//	ArrayList<DemandeJoinDto>LisDem=	(ArrayList<DemandeJoinDto>) joinRepository.fetchDataLeftJoin();
		
			
		return joinRepository.AffichageDemandeDestination();
	}
	public List<DemandeJoinDto> AffichageDemandeExpedition() {
	//	ArrayList<DemandeJoinDto>LisDem=	(ArrayList<DemandeJoinDto>) joinRepository.fetchDataLeftJoin();
		
			
		return joinRepository.AffichageDemandeExpedition();
	}


	public List<DemandeJoinDto> AffichageDemandeDestinationMarch() {
		// ArrayList<DemandeJoinDto>LisDem= (ArrayList<DemandeJoinDto>) joinRepository.fetchDataLeftJoin();
			//Marchand marchand = demandeMarchandService.findById(id);
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
				  String username = ((UserDetails)principal).getUsername();
				  System.out.print("the user"+username);
				 Marchand m= joinRepository.findByEmail(username);
				long id= m.getId();
				return joinRepository.AffichageDemandeDestinationMarch(m);
				/*} else {
				  String username = principal.toString();
				  Marchand m= joinRepository.findByNomUtilisateur(username);
					long id= m.getId();
					joinRepository.fetchDataLeftJoin(id);*/
			
			/*Long id = authentication.g;
				    UserServiceImpl userimlp;
				    userimlp.
				    System.out.println( "Id : " + id );*/
		
		
		}

	public List<DemandeJoinDto> AffichageDemandeExpeditionMarch() {
		// ArrayList<DemandeJoinDto>LisDem= (ArrayList<DemandeJoinDto>) joinRepository.fetchDataLeftJoin();
			//Marchand marchand = demandeMarchandService.findById(id);
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
				  String username = ((UserDetails)principal).getUsername();
				  System.out.print("the user"+username);
				 Marchand m= joinRepository.findByEmail(username);
				long id= m.getId();
				return joinRepository.AffichageDemandeExpeditionMarch(m);
	}
	

}
