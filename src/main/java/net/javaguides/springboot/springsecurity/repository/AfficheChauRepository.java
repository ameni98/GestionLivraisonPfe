package net.javaguides.springboot.springsecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import net.javaguides.springboot.springsecurity.model.Chauffeur;
import net.javaguides.springboot.springsecurity.model.EtatDispo;
import net.javaguides.springboot.springsecurity.web.dto.ChauffeurRegistrationDto;



@Repository
public interface AfficheChauRepository extends JpaRepository<Chauffeur, Long> {
	/*@Query(value=" SELECT new net.javaguides.springboot.springsecurity.web.dto.ChauffeurRegistrationDto(c.id,c.nom,c.prenom,c.DateNai,c.NumTel,c.NumPermis,c.cin,etatDis.nom,etatDis.DateDeb,etatDis.DateFin)"
			+ "FROM Chauffeur c,EtatDispo etatDis WHERE (c.etatDispo = etatDis.id)")
	List<ChauffeurRegistrationDto> affichageChauff();
*/
}
