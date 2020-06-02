package net.javaguides.springboot.springsecurity.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import net.javaguides.springboot.springsecurity.model.Chauffeur;
import net.javaguides.springboot.springsecurity.model.Marchand;
import net.javaguides.springboot.springsecurity.web.dto.ChauffeurRegistrationDto;

@Repository
public interface ChauffeurRepository extends  PagingAndSortingRepository<Chauffeur,Long> {
	
	//requete pour l'affichage de liste des chauffeurs et leurs disponiblités
	@Query(value=" SELECT new net.javaguides.springboot.springsecurity.web.dto.ChauffeurRegistrationDto(c.id,c.nom,c.prenom,c.DateNai,c.NumTel,c.NumPermis,c.cin,etatDis.nom,etatDis.DateDeb,etatDis.DateFin,u.nomUtilisateur,u.password,etatDis.id )"
			+ "FROM Chauffeur c,EtatDispo etatDis ,User u WHERE (c.etatDispo = etatDis.id)AND (c.id=u.id)")
	List<ChauffeurRegistrationDto> affichageChauff();
	
	//requete pour l'affichage des chauffeurs disponibles
	@Query(value="SELECT new net.javaguides.springboot.springsecurity.web.dto.ChauffeurRegistrationDto(c.id,c.nom,c.prenom,etatDis.nom,etatDis.id )" + 
			 "FROM Chauffeur c,EtatDispo etatDis WHERE (c.etatDispo = etatDis.id)AND (etatDis.nom='disponible')")
	 List<ChauffeurRegistrationDto> affichageChauffDispo();
	
	//requete pour l'affichage des chauffeurs disponibles et qui travaillent sur grand Tunis
	 @Query(value="SELECT new net.javaguides.springboot.springsecurity.web.dto.ChauffeurRegistrationDto(c.id,c.nom,c.prenom,etatDis.nom,etatDis.id )" + 
			 "FROM Chauffeur c,EtatDispo etatDis WHERE (c.etatDispo = etatDis.id)AND (etatDis.nom='disponible') AND (c.TypeDeplacement='Grand tunis')")
	 List<ChauffeurRegistrationDto> affichageChauffDispoGrnTun();
			 
	//requete pour l'affichage des chauffeurs disponibles et qui travaillent hors grand Tunis
	 @Query(value="SELECT new net.javaguides.springboot.springsecurity.web.dto.ChauffeurRegistrationDto(c.id,c.nom,c.prenom,etatDis.nom,etatDis.id )" + 
			 "FROM Chauffeur c,EtatDispo etatDis WHERE (c.etatDispo = etatDis.id)AND (etatDis.nom='disponible') AND (c.TypeDeplacement='Tous les gouvernorat')")
	 List<ChauffeurRegistrationDto> affichageChauffDispoHorGrnTun();

	 ////methode pour faire la recherche par nom
	 Page<Chauffeur>findByNomContainingIgnoreCase(String nom, Pageable pageable);
		Chauffeur findByEmail(String username);
	
		//tableau de board
		@Query(value=" SELECT count(*) as nbre FROM chauffeur",nativeQuery = true)
		int findNumberChauff(); 
		
}
