
package net.javaguides.springboot.springsecurity.service;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.springsecurity.model.Chauffeur;
import net.javaguides.springboot.springsecurity.model.Colis;
import net.javaguides.springboot.springsecurity.model.Commande;
import net.javaguides.springboot.springsecurity.model.EtatCommande;
import net.javaguides.springboot.springsecurity.repository.ColisRepositry;
import net.javaguides.springboot.springsecurity.repository.CommandeRepositry;

@Service
public class CommandeService {
	@Autowired
	CommandeRepositry   commandeRepositry;
	@Autowired
	ColisRepositry   colisRepositry;
	
	public Commande addCommande(Commande commande)
	{
		if (commande.getId() == 0) {

			return commandeRepositry.save(commande);

		
		} else {
			// c'est pour le cas de modification récupération des valeurs de l'objet
			// chauffeur à partir de son id
			Optional<Commande> com = commandeRepositry.findById(commande.getId());

			if (com.isPresent()){
		
				Commande newEntity = com.get();
				DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
				Date date = new Date();
				EtatCommande EtCom = new EtatCommande();
				EtCom.setId(2);
				newEntity.setDate_Modif(format.format(date));
				newEntity.setEtatCommandeE(EtCom);
				//newEntity.setMarchandM(commande.getMarchandM().getId());
				//newEntity.setDateCom(commande.getDateCom());
				newEntity.setId(commande.getId());
				System.out.print("hello");
		return commandeRepositry.save(newEntity);
			}
			
		
		}
		return commandeRepositry.save(commande);	
	}
	public Colis addColis(Colis c)
	{
	
		return colisRepositry.save(c);
			
		
	}
	public Commande modifierEtat(Commande commande)
	{if (commande.getId() == 0) {

		return commandeRepositry.save(commande);

	
	} else {
		// c'est pour le cas de modification récupération des valeurs de l'objet
		// chauffeur à partir de son id
		Optional<Commande> com = commandeRepositry.findById(commande.getId());

		if (com.isPresent()){
	
			Commande newEntity = com.get();
			DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			EtatCommande EtCom = new EtatCommande();
			EtCom.setId(3);
			newEntity.setDate_Modif(format.format(date));
			newEntity.setEtatCommandeE(EtCom);
			//newEntity.setMarchandM(commande.getMarchandM().getId());
			//newEntity.setDateCom(commande.getDateCom());
			newEntity.setId(commande.getId());
			System.out.print("hello");
	return commandeRepositry.save(newEntity);
		}
		
	
	}
	return commandeRepositry.save(commande);	
}
	}

