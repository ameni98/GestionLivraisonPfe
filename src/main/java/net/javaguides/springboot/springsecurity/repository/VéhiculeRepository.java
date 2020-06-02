package net.javaguides.springboot.springsecurity.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.springsecurity.model.Vehicule;


@Repository
public interface VéhiculeRepository extends  PagingAndSortingRepository<Vehicule,Long> {
	
	//requete pour afficher les véhicules disponibles
	 @Query(value="SELECT * FROM véhicule v WHERE v.dispo='Disponible'", 
			 nativeQuery = true )
	 List<Vehicule>vehiculeDispo();
	
	 //méthode pour rechercher vehicule par matricule
	 Page<Vehicule>findByMatriculeContainingIgnoreCase(String maricule, Pageable pageable);
	
	 //tableau de board
	 @Query(value=" SELECT count(*)  as nbre FROM véhicule",nativeQuery = true)
		int findNumberVehi(); 
}
