package net.javaguides.springboot.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.springsecurity.model.EtatDispo;

@Repository
//etat dispo pour chauffeur
public interface EtatDispoRepository extends JpaRepository<EtatDispo, Long> {

}
