package net.javaguides.springboot.springsecurity.web;

import java.text.DateFormat;
import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import net.javaguides.springboot.springsecurity.model.Colis;
import net.javaguides.springboot.springsecurity.model.Commande;
import net.javaguides.springboot.springsecurity.model.EtatCommande;
import net.javaguides.springboot.springsecurity.model.VilleDto;
import net.javaguides.springboot.springsecurity.model.Marchand;
import net.javaguides.springboot.springsecurity.model.Ville;
import net.javaguides.springboot.springsecurity.model.VilleColis;
import net.javaguides.springboot.springsecurity.repository.UserRepository;
import net.javaguides.springboot.springsecurity.service.ColisService;
import net.javaguides.springboot.springsecurity.service.CommandeService;
import net.javaguides.springboot.springsecurity.service.GouverneratService;
import net.javaguides.springboot.springsecurity.service.VilleColisService;
import net.javaguides.springboot.springsecurity.service.VilleService;
import net.javaguides.springboot.springsecurity.web.dto.CommandeRegistrationDto;

@Controller
public class CommandeRegistrationController {

	@Autowired
	private CommandeService commandeService;
	@Autowired
	private ColisService colisSerivce;
	@Autowired
	private UserRepository userRepositry;

	@Autowired
	private VilleColisService villeColiSer;

	@Autowired
	private GouverneratService GouvSer;
	@Autowired
	private VilleService VilleSer;

	@ModelAttribute("colis")
	public CommandeRegistrationDto commandeRegistrationDto() {
		return new CommandeRegistrationDto();
	}

	// affichage formulire pour envoyer une commande
	@GetMapping(value = ("/commande"))
	public String showcommandeColis(Model model) {
		model.addAttribute("gouvernerats", GouvSer.getAllGouvernerat());
		List<Ville> villes = new ArrayList<Ville>();
		model.addAttribute("villes", villes);
		return "commande";
	}

	// afficher tous les villes de gouverneart choisi
	@ResponseBody
	@RequestMapping(value = "/commande/loadStatesByCountry/{id}", method = RequestMethod.GET)
	public String loadCityByCountry(@PathVariable("id") Long id) {

		List<VilleDto> result = VilleSer.getAllVilles(id);
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i).getNom());
		}
		Gson gson = new Gson();
		System.out.print("hello   " + gson.toJson(VilleSer.getAllVilles(id)));
		return gson.toJson(VilleSer.getAllVilles(id));

	}

	@RequestMapping(value = "/commande", method = RequestMethod.POST)

	public String commandeRegistrationDto(@ModelAttribute("colis") @Valid CommandeRegistrationDto cmdDto,
			BindingResult result, Model model) {
		model.addAttribute("gouvernerats", GouvSer.getAllGouvernerat());
		List<Ville> villes = new ArrayList<Ville>();
		model.addAttribute("villes", villes);

		if (result.hasErrors()) {
			System.out.print("c'est faux hferfbhyer");
			return "commande";
		}
		Commande commande = new Commande();
		Colis colis = new Colis();

		// ce qui concerne le client
		colis.setAdresse_client(cmdDto.getAdresse_client());
		colis.setCode_Postale_client(cmdDto.getCode_Postale_client());
		colis.setAdresse_marchand(cmdDto.getAdresse_marchand());
		colis.setCode_Postale_marchand(cmdDto.getCode_Postale_marchand());
		colis.setDesc_Colis(cmdDto.getDesc_Colis());

		colis.setPoids(cmdDto.getPoids());
		colis.setNumTel_client(cmdDto.getNumTel_client());
		colis.setType_destination(cmdDto.getType_destination());
		colis.setNom_client(cmdDto.getNom_client());
		colis.setPrenom_client((cmdDto.getPrenom_client()));
		colis.setRasison_sociale(cmdDto.getRaison_sociale());

		// trouver le marchand authentifié
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		Marchand m = (Marchand) userRepositry.findByEmail(username);

		commande.setMarchandM(m);
		commande.addColisCommande(colis);

		DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		commande.setDateCom(format.format(date));
		
		EtatCommande Ec = new EtatCommande();
		Ec.setId(1);
		commande.setEtatCommandeE(Ec);

	 commandeService.addCommande(commande);
		colisSerivce.addColis(colis);

		VilleColis vc = new VilleColis();
		// setters (colis)pour villeColis
		vc.setColis(colis);
		Ville v = new Ville();
		v.setId_ville(Long.parseLong(cmdDto.getVille_client()));

//setters (ville)pour villeColis    
		vc.setVille(v);
		System.out.print("ville client" + cmdDto.getVille_client());

		vc.setDescription("Adresse de destination");
		if (cmdDto.getVille_client() != null) {
			villeColiSer.enregistrer(vc);
		}

		VilleColis vc1 = new VilleColis();
		vc1.setColis(colis);
		Ville v1 = new Ville();
		v1.setId_ville(Long.parseLong(cmdDto.getVille_marchand()));
		vc1.setVille(v1);
		vc1.setDescription("Adresse d'expedition");
		System.out.print("ville marchand" + cmdDto.getVille_marchand());
		if (cmdDto.getVille_marchand() != null) {
			villeColiSer.enregistrer(vc1);

		}/*
//création de affectation Commande Etat
		AffectationCommandeEtat AffComEt = new AffectationCommandeEtat();
		// setters (commande) pour AffectationCommandeEtat
		AffComEt.setCommande(com);
		AffComEt.setDate(format.format(date));
		EtatCommande Ec = new EtatCommande();
		Ec.setId(1);
		// setters (commande) pour AffectationCommandeEtat
		AffComEt.setEtatCommande(Ec);
		affectationCommandeEtatSer.enregistrer(AffComEt);
*/
		return "redirect:/commande?success";

	}

}
