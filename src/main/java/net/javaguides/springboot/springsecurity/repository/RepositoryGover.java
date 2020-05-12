package net.javaguides.springboot.springsecurity.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import net.javaguides.springboot.springsecurity.model.Gouvernerat;
@Transactional
@Repository
public interface RepositoryGover extends JpaRepository<Gouvernerat, Long> {
	

}
