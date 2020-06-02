package net.javaguides.springboot.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.javaguides.springboot.springsecurity.model.Commande;
import net.javaguides.springboot.springsecurity.repository.ModifierEatRepository;
//modifier etat service coté chauffeur
@Service
public class ModifierEatService {
	@Autowired
	ModifierEatRepository ModifierEatRep;

	public Commande Ajouter (Commande modifierDto)
	{
	return	ModifierEatRep.save(modifierDto);
	}
}
