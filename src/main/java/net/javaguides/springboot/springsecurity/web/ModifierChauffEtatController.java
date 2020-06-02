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
import net.javaguides.springboot.springsecurity.model.Commande;
import net.javaguides.springboot.springsecurity.model.EtatCommande;
import net.javaguides.springboot.springsecurity.service.CommandeService;
import net.javaguides.springboot.springsecurity.service.ModifierEatService;
import net.javaguides.springboot.springsecurity.web.dto.ModifierEtatChauffDto;

@Controller
public class ModifierChauffEtatController {
	/*@Autowired
	ModifierEatService modifierEtatChauffSer;*/
	@Autowired
	CommandeService ComService;

	@PostMapping("/ModifierEtatChauffeur")
	public String Ajouteraffectation(@ModelAttribute("ModifierEtat") ModifierEtatChauffDto ModifierEtat,
		 RedirectAttributes redirectAttrs, Model m) {
		//AffectationCommandeEtat AffectComm = new AffectationCommandeEtat();
		EtatCommande EtCom = new EtatCommande();
		EtCom.setId(ModifierEtat.getIdEtat());
		//AffectComm.setEtatCommande(EtCom);
		Commande c = new Commande();
		c.setId(ModifierEtat.getIdComm());
		//c.setEtatCommandeE(EtCom);
		//AffectComm.setCommande(c);
		/*DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		c.setDate_Modif(format.format(date));*/
		//c.setMarchandM(ModifierEtat.ge);
		//AffectComm.setDate(format.format(date));
		//modifierEtatChauffSer.Ajouter(AffectComm);
		ComService.modifierEtat(c);
		if (ComService.modifierEtat(c) != null) {

			// cette ligne signifie qu'on passe le message a javascript mais à la page list
			// donc on fait la redirection
			redirectAttrs.addFlashAttribute("message", "état modifier avec succées");
		} else {
			// sinon on affiche ce message
			redirectAttrs.addFlashAttribute("message", "Oups!Erreur est survenue");
		}

		return "redirect:/ModifierEtatChauffeur";

	}
}
