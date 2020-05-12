package net.javaguides.springboot.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.springsecurity.model.VilleColis;
import net.javaguides.springboot.springsecurity.repository.VilleColisRepository;

@Service
public class VilleColisService {
	@Autowired VilleColisRepository villeColisRep;
	
	public VilleColis enregistrer(VilleColis villeColis)
	{
		return villeColisRep.save(villeColis);
	}
	
	

}