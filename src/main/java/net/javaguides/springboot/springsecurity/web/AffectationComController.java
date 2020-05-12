package net.javaguides.springboot.springsecurity.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.springboot.springsecurity.model.AffectationCommande;
import net.javaguides.springboot.springsecurity.model.AffectationCommandeEtat;
import net.javaguides.springboot.springsecurity.model.Chauffeur;
import net.javaguides.springboot.springsecurity.model.Commande;
import net.javaguides.springboot.springsecurity.model.EtatCommande;
import net.javaguides.springboot.springsecurity.model.Vehicule;
import net.javaguides.springboot.springsecurity.service.AffectationCommService;
import net.javaguides.springboot.springsecurity.service.AffectationCommandeEtatService;
import net.javaguides.springboot.springsecurity.web.dto.AffectationRegisterDto;

@Controller
public class AffectationComController {
	@Autowired
AffectationCommService affectComServ;
	@Autowired
	AffectationCommandeEtatService affectComEtServ;
	
    @PostMapping("/list")
	public String Ajouteraffectation(@ModelAttribute("affectCommande")AffectationRegisterDto affectCom,Model m)
	{
	String ids=affectCom.getIdCommande();
	 String[] result=ids.split(",");
	 for (String i :result) 
	 { 
		 AffectationCommande AffectComm=new AffectationCommande();
		 Chauffeur ch=new Chauffeur();
		 ch.setId(affectCom.getIdChauffeur());
		 AffectComm.setChauffeurC(ch);
		 Vehicule v=new Vehicule();
		 System.out.print("vehicule"+ affectCom.getIdVehicule());
		 v.setId(affectCom.getIdVehicule());
AffectComm.setVehiculeV(v);
		 	AffectComm.setDate_departColis(affectCom.getDate_departColis());
		 	Commande c=new Commande();
		 	int idcom=Integer.parseInt(i);
			c.setId(idcom);
			AffectComm.setCommandeC(c);
			AffectComm.setId_affectCommande(affectCom.getId_affectCommande());
			affectComServ.Ajouter(AffectComm);
			AffectationCommandeEtat affCommEtat=new AffectationCommandeEtat();
			EtatCommande EtCom=new EtatCommande(); 
			EtCom.setId(2);
			affCommEtat.setEtatCommande(EtCom);
			affCommEtat.setCommande(c);
			affCommEtat.setAffectationCommandeC(AffectComm);
			affectComEtServ.enregistrer(affCommEtat);
			
			
	 }
	
	//c.setId();

    	
    	
		return "list";
		
	}

}
