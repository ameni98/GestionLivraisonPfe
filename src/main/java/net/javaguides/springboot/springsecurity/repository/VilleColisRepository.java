package net.javaguides.springboot.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.springsecurity.model.VilleColis;
import net.javaguides.springboot.springsecurity.model.VilleColisId;
@Repository
public interface VilleColisRepository extends JpaRepository<VilleColis, VilleColisId>{
	

}
