package net.javaguides.springboot.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.springsecurity.model.Colis;
@Repository
public interface ColisRepositry extends  JpaRepository<Colis, Integer>{

}
