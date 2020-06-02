
package net.javaguides.springboot.springsecurity.service;

import org.springframework.security.core.userdetails.UserDetails;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.springsecurity.model.Chauffeur;
import net.javaguides.springboot.springsecurity.model.Marchand;
import net.javaguides.springboot.springsecurity.repository.ChauffeurRepository;
import net.javaguides.springboot.springsecurity.repository.DemandeJoinRepository;
import net.javaguides.springboot.springsecurity.web.dto.DemandeJoinDto;

@Service
public class DemandeJoinService {
	@Autowired
	private DemandeJoinRepository joinRepository;
	@Autowired
	private ChauffeurRepository chauffRep;
	//affichage des commandes des marchands historique
		public List<DemandeJoinDto> AffichageDemandeExpeditionMarchHisto() {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			String username = ((UserDetails) principal).getUsername();
			Marchand m = joinRepository.findByEmail(username);
				return joinRepository.AffichageDemandeExpeditionMarchHisto(m);
			}
			//affichage des commandes  des marchands coté admin historique
			public List<DemandeJoinDto> AffichageDemandeDestinationMarchHisto() {
				Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

				String username = ((UserDetails) principal).getUsername();
				Marchand m = joinRepository.findByEmail(username);
				return joinRepository.AffichageDemandeDestinationMarchHisto(m);
			}
			
	
	//affichage des commandes des marchands coté admin 
	public List<DemandeJoinDto> AffichageDemandeDestinationTous() {

			return joinRepository.AffichageDemandeDestinationTous();
		}
		//affichage des commandes  des marchands coté admin 
		public List<DemandeJoinDto> AffichageDemandeExpeditionTous() {

			return joinRepository.AffichageDemandeExpeditionTous();
		}
		
	//affichage des commandes des marchands coté admin qui sont en attente 
public List<DemandeJoinDto> AffichageDemandeDestination() {

		return joinRepository.AffichageDemandeDestination();
	}
	//affichage des commandes  des marchands coté admin qui sont en attente 
	public List<DemandeJoinDto> AffichageDemandeExpedition() {

		return joinRepository.AffichageDemandeExpedition();
	}
	//affichage des commandes  des marchands coté admin triés (grand tunis) 
	public List<DemandeJoinDto> AffichageDemandeDestinationGrTunis() {

		return joinRepository.AffichageDemandeDestinationGrTunis();
	}
	//affichage des commandes  des marchands coté admin triés (grand tunis) 
	public List<DemandeJoinDto> AffichageDemandeExpeditionGrTunis() {

		return joinRepository.AffichageDemandeExpeditionGrTunis();
	}
	//affichage des commandes  des marchands coté admin triés (tous les gouvernerat) 
	public List<DemandeJoinDto> AffichageDemandeDestinationHorsGrTunis() {

		return joinRepository.AffichageDemandeDestinationHorsGrTunis();
	}
	//affichage des commandes  des marchands coté admin triés (tous les gouvernerat) 
	public List<DemandeJoinDto> AffichageDemandeExpeditionHorsGrTunis() {

		return joinRepository.AffichageDemandeExpeditionHorsGrTunis();
	}
	//affichage des commandes d'un marchand spécifique
	public List<DemandeJoinDto> AffichageDemandeDestinationMarch() {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String username = ((UserDetails) principal).getUsername();
		Marchand m = joinRepository.findByEmail(username);
		return joinRepository.AffichageDemandeMarch(m);

	}
	//affichage des commandes d'un marchand spécifique
	/*public List<DemandeJoinDto> AffichageDemandeExpeditionMarch() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String username = ((UserDetails) principal).getUsername();
		Marchand m = joinRepository.findByEmail(username);
		return joinRepository.AffichageDemandeExpeditionMarch(m);
	}*/
	//affichage des commandes  des marchands coté chauffeurs  
	public List<DemandeJoinDto> AffichageDemandeExpeditionChauffeur() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String username = ((UserDetails) principal).getUsername();
		Chauffeur c = chauffRep.findByEmail(username);
		System.out.print("bonsoir   "+c);
		return joinRepository.AffichageDemandeExpeditionChauffeur(c);
	}
	//affichage des commandes  des marchands coté chauffeurs 
	public List<DemandeJoinDto> AffichageDemandeDestinationChauffeur() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String username = ((UserDetails) principal).getUsername();
		Chauffeur c = chauffRep.findByEmail(username);
	
		return joinRepository.AffichageDemandeDestinationChauffeur(c);
	}

}
