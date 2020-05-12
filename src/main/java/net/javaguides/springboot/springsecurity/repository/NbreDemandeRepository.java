package net.javaguides.springboot.springsecurity.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.springsecurity.model.AffectationCommandeEtat;

@Transactional
@Repository
public interface NbreDemandeRepository  extends JpaRepository<AffectationCommandeEtat,Integer>{
	@Query(value=" SELECT count(*) as nbre FROM affectation_commande_etat A WHERE A.id_etat=1",nativeQuery = true)
	int findById_etat(); 
	
	
}
