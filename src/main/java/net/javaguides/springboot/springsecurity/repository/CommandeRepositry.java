package net.javaguides.springboot.springsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.springsecurity.model.Commande;


@Repository
public interface CommandeRepositry  extends JpaRepository<Commande, Integer> {
	Optional<Commande> findById(Integer id);
	
	
	
}
