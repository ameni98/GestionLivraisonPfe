package net.javaguides.springboot.springsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.springsecurity.model.Marchand;
@Repository
public interface MarchandRepository extends PagingAndSortingRepository<Marchand, Long>
{
	Optional<Marchand> findById(Long id) ;
	@Query(value=" SELECT count(*)  as nbre FROM marchand",nativeQuery = true)
	int findNumberMarch(); 
}
