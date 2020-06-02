package net.javaguides.springboot.springsecurity.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import net.javaguides.springboot.springsecurity.model.AffectationCommande;
import net.javaguides.springboot.springsecurity.model.Chauffeur;
import net.javaguides.springboot.springsecurity.model.Commande;
import net.javaguides.springboot.springsecurity.model.EtatCommande;
import net.javaguides.springboot.springsecurity.model.Vehicule;
import net.javaguides.springboot.springsecurity.service.AffectationCommService;
import net.javaguides.springboot.springsecurity.service.CommandeService;
import net.javaguides.springboot.springsecurity.web.dto.AffectationRegisterDto;

@Controller
public class AffectationComController {
	@Autowired
	AffectationCommService affectComServ;
	@Autowired
	CommandeService comServ;

	// controlleur pour faire l'affectation commande->chauufeur,vehicule
	@PostMapping("/list")
	public String Ajouteraffectation(@ModelAttribute("affectCommande") AffectationRegisterDto affectCom,
			RedirectAttributes redirectAttrs, Model m) {

		// récupérer les ids des commandes cocher
		String ids = affectCom.getIdCommande();

		// les mettre dans un tableau string
		String[] result = ids.split(",");

		// on parcoure ce tableau
		for (String i : result) {
			AffectationCommande AffectComm = new AffectationCommande();
			Chauffeur ch = new Chauffeur();
			ch.setId(affectCom.getIdChauffeur());
			AffectComm.setChauffeurC(ch);
			Vehicule v = new Vehicule();
			System.out.print("vehicule" + affectCom.getIdVehicule());
			v.setId(affectCom.getIdVehicule());
			AffectComm.setVehiculeV(v);
			AffectComm.setDate_departColis(affectCom.getDate_departColis());
			Commande c = new Commande();
			int idcom = Integer.parseInt(i);
			c.setId(idcom);
			DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			AffectComm.setDate_affect(format.format(date));
			AffectComm.setCommandeC(c);
			AffectComm.setId_affectCommande(affectCom.getId_affectCommande());

			// on enregistre dans la base tous les informations
			// nécessaires(idvehicule,idchauffeur,date,idcomm) dans la table
			// affectation commande
			affectComServ.Ajouter(AffectComm);

		//	AffectationCommandeEtat affCommEtat = new AffectationCommandeEtat();
			/*EtatCommande EtCom = new EtatCommande();
			EtCom.setId(2);
			DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			c.setDate_Modif(format.format(date));
			AffectComm.setDate_affect(format.format(date));
			c.setEtatCommandeE(EtCom);*/
			comServ.addCommande(c);
			//affCommEtat.setEtatCommande(EtCom);
			//affCommEtat.setCommande(c);
			//affCommEtat.setAffectationCommandeC(AffectComm);
			// on enregistre dans la base tous les informations
			// nécessaires(idetat,idcomm,idaffectComm) dans la table
			// affectation commande etat
			//affectComEtServ.enregistrer(affCommEtat);
			
			if (comServ.addCommande(c) != null) {

				// cette ligne signifie qu'on passe le message a javascript mais à la page list
				// donc on fait la redirection
				redirectAttrs.addFlashAttribute("message", "affectation avec succées");
			} else {
				// sinon on affiche ce message
				redirectAttrs.addFlashAttribute("message", "Oups!Erreur est survenue");
			}

		}

		return "redirect:/list";

	}

}
