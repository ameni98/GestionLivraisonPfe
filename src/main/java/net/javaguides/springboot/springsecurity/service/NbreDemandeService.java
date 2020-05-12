package net.javaguides.springboot.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.springsecurity.repository.NbreDemandeRepository;
@Service
public class NbreDemandeService {
	@Autowired
	NbreDemandeRepository nbrRep;
	
	public int nbreDemandes()
	{
		int nbre=0;
	 nbre=nbrRep.findById_etat();
		return nbre;
	}
	

}
