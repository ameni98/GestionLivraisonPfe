package net.javaguides.springboot.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import net.javaguides.springboot.springsecurity.model.Commande;
//modification d'etat de cote chauffeur
@Repository
public interface ModifierEatRepository extends JpaRepository<Commande, Integer>{

}
