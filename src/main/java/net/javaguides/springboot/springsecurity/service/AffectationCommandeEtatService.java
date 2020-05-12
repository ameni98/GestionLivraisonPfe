package net.javaguides.springboot.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.springsecurity.model.AffectationCommandeEtat;
import net.javaguides.springboot.springsecurity.repository.AffectattionCommandeEtatRepository;

@Service
public class AffectationCommandeEtatService {
	@Autowired
	AffectattionCommandeEtatRepository AffectationCommandeEtatRepositoryRep;
	
	public AffectationCommandeEtat enregistrer(AffectationCommandeEtat affectationCommandeEtat)
	{
		return AffectationCommandeEtatRepositoryRep.save(affectationCommandeEtat);
	}
	

}
