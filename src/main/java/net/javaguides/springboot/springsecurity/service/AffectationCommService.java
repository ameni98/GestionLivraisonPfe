package net.javaguides.springboot.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.springsecurity.model.AffectationCommande;
import net.javaguides.springboot.springsecurity.repository.AffectationCommRepository;

@Service
public class AffectationCommService {
	@Autowired
	AffectationCommRepository affectComRep;

	
	public AffectationCommande Ajouter(AffectationCommande affCom)
	{
		return affectComRep.save(affCom);
	}
}
