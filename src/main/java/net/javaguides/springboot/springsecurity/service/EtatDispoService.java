package net.javaguides.springboot.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.springsecurity.model.EtatDispo;
import net.javaguides.springboot.springsecurity.repository.EtatDispoRepository;

@Service
public class EtatDispoService {
	@Autowired
	EtatDispoRepository etatRep;
	
	public EtatDispo addEtat( EtatDispo ED)
	{
	return	etatRep.save(ED);
	
	}
	public void deleteEtat( EtatDispo ED)
	{
		etatRep.delete(ED);
	
	}

}
