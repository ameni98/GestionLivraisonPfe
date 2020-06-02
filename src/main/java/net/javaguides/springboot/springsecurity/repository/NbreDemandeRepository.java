package net.javaguides.springboot.springsecurity.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import net.javaguides.springboot.springsecurity.model.Commande;

//afficher le nombre des nouveaux commandes sous formes notification
@Transactional
@Repository
public interface NbreDemandeRepository  extends JpaRepository<Commande,Integer>{
	@Query(value=" SELECT count(*) as nbre FROM commande A WHERE A.id_etat=1",nativeQuery = true)
	int findById_etat(); 
	//tableau de board
	@Query(value=" SELECT count(*) as nbre FROM commande",nativeQuery = true)
	int findNumberCom(); 
	
}
