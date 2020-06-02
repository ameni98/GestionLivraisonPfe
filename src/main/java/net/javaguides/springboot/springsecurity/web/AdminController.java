package net.javaguides.springboot.springsecurity.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.javaguides.springboot.springsecurity.service.ChauffeurService;
import net.javaguides.springboot.springsecurity.service.NbreDemandeService;
import net.javaguides.springboot.springsecurity.service.MarchandService;
import net.javaguides.springboot.springsecurity.service.VéhiculeService;
@Controller
public class AdminController {
	@Autowired
	NbreDemandeService nbrSer;
	@Autowired
	MarchandService nbrMarch;
	@Autowired
	ChauffeurService nbrChauff;
	@Autowired
	VéhiculeService nbrVehicule;
	 @Autowired
	 MarchandService marchandService;
	  @GetMapping(value="/admin")
	 public String admin(Model m) {
		  m.addAttribute("nbreDemandes",nbrSer.nbreDemandes());
		  m.addAttribute("nbreMarchands",nbrMarch.nbreMarchands());
		  m.addAttribute("nbreChauffeurs",nbrChauff.nbreTotalC());
		  m.addAttribute("nbreVahicules",nbrVehicule.nbreTotalV());
	     return "admin";
	  }
	 //affichage de list de marchand
			 @GetMapping(value = "/marchand/list")
			 public String allParachiot(Model model) {
			      
			     model.addAttribute("marchands", marchandService.getAllMarchand());
			      
			     return "/marchand/list";
			 }


}
