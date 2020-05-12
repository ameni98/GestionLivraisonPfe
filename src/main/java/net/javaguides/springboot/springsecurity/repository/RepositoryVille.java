package net.javaguides.springboot.springsecurity.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.springsecurity.model.Gouvernerat;
import net.javaguides.springboot.springsecurity.model.Ville;
@Transactional
@Repository
public interface RepositoryVille extends JpaRepository<Ville, Long> {
	//@Query("SELECT new v.nom FROM gouvernerat g INNER JOIN ville v ON g.id_gouvernerat = v.id_gouvernerat;")List<Ville> fetchEmpDeptDataLeftJoin();;
	@Query(" SELECT v FROM Ville v WHERE v.gouverneratG=?1")
	List<Ville> findByGouverneratG(Gouvernerat idGouvernerat);
	
	
	
	
/*@Query(0
	SELECT d.name, e.name, e.email, e.address FROM department d INNER JOIN employee e ON d.id = e.dept_id;)
List<Ville> fetchEmpDeptDataLeftJoin();*/
}
