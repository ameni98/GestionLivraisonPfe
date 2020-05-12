package net.javaguides.springboot.springsecurity.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.springsecurity.model.Chauffeur;

import net.javaguides.springboot.springsecurity.web.dto.ChauffeurRegistrationDto;
;

@Repository
public interface ChauffeurRepository extends  PagingAndSortingRepository<Chauffeur,Long> {
	@Query(value=" SELECT new net.javaguides.springboot.springsecurity.web.dto.ChauffeurRegistrationDto(c.id,c.nom,c.prenom,c.DateNai,c.NumTel,c.NumPermis,c.cin,etatDis.nom,etatDis.DateDeb,etatDis.DateFin,u.nomUtilisateur,u.password,etatDis.id )"
			+ "FROM Chauffeur c,EtatDispo etatDis ,User u WHERE (c.etatDispo = etatDis.id)AND (c.id=u.id)")
	List<ChauffeurRegistrationDto> affichageChauff();
	
	
	 @Query(value="SELECT new net.javaguides.springboot.springsecurity.web.dto.ChauffeurRegistrationDto(c.id,c.nom,c.prenom,etatDis.nom,etatDis.id )" + 
			 "FROM Chauffeur c,EtatDispo etatDis WHERE (c.etatDispo = etatDis.id)AND (etatDis.nom='disponible')")
	 List<ChauffeurRegistrationDto> affichageChauffDispo();
			 
	

	 Page<Chauffeur>findByNomContainingIgnoreCase(String nom, Pageable pageable);
 
	
}
