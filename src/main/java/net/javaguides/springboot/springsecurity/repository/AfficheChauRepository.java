package net.javaguides.springboot.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.javaguides.springboot.springsecurity.model.Chauffeur;


@Repository
public interface AfficheChauRepository extends JpaRepository<Chauffeur, Long> {
	
}
