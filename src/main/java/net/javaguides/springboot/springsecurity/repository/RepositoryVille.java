package net.javaguides.springboot.springsecurity.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import net.javaguides.springboot.springsecurity.model.VilleDto;
import net.javaguides.springboot.springsecurity.model.Ville;

@Transactional
@Repository
public interface RepositoryVille extends JpaRepository<Ville, Long> {

//requete pour afficher la liste des villes de son gouvernerat 
@Query("select new net.javaguides.springboot.springsecurity.model.VilleDto(v.id_ville,v.nom) from Ville v where v.gouverneratG.id = :id")
public List<VilleDto> findByGouverneratG(@Param("id") Long id);
	

}
