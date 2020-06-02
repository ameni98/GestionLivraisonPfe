package net.javaguides.springboot.springsecurity.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import net.javaguides.springboot.springsecurity.model.SelectLibelle;
import net.javaguides.springboot.springsecurity.service.ChauffeurService;
import net.javaguides.springboot.springsecurity.service.DemandeJoinService;
import net.javaguides.springboot.springsecurity.service.VéhiculeService;
import net.javaguides.springboot.springsecurity.web.dto.AffectationRegisterDto;
import net.javaguides.springboot.springsecurity.web.dto.DemandeJoinDto;
import net.javaguides.springboot.springsecurity.web.dto.ModifierEtatChauffDto;

@Controller
public class DemandeJoinController {
	@Autowired
	private DemandeJoinService demandejoinService;
	@Autowired
	private VéhiculeService vehiSer;
	@Autowired
	private ChauffeurService chauffSer;

	
	@GetMapping("/historique")
	public String gethistoriqueMarch(Model m) {

		List<DemandeJoinDto> dem = demandejoinService.AffichageDemandeDestinationMarchHisto();
		List<DemandeJoinDto> dem1 = demandejoinService.AffichageDemandeExpeditionMarchHisto();

		List<DemandeJoinDto> Demandes = new ArrayList<DemandeJoinDto>();

		int i = 0;
		while (i < dem.size() && (i < dem1.size())) {
			DemandeJoinDto demDT = new DemandeJoinDto(dem.get(i).getDate_modif(),dem.get(i).getDate_com(),dem1.get(i).getDesc_Colis(),dem1.get(i).getNomGouverneratM(),dem.get(i).getNomGouverneratC());
					System.out.print("hello"+dem.get(i).getDesc_Colis());
			// on remplit une liste avec tous les informations et les villes de destination
			// et d'expédition
			Demandes.add(demDT);
			i = i + 1;

		}

		m.addAttribute("demandes", Demandes);
	

		return "historique";
	}
	// affichage de la liste des commandes
		@GetMapping("/SuiviEtatAdmin")
		public String getDemandesTous(Model m) {

			List<DemandeJoinDto> dem = demandejoinService.AffichageDemandeDestinationTous();
			List<DemandeJoinDto> dem1 = demandejoinService.AffichageDemandeExpeditionTous();

			List<DemandeJoinDto> Demandes = new ArrayList<DemandeJoinDto>();

			int i = 0;
			while (i < dem.size() && (i < dem1.size())) {
				System.out.print("hello"+dem.get(i).getDesc_Colis());
				DemandeJoinDto demDT = new DemandeJoinDto(dem.get(i).getDate_com(), dem.get(i).getAdresse_marchand(),
						dem.get(i).getAdresse_client(), dem.get(i).getCode_Postale_marchand(),
						dem.get(i).getCode_Postale_client(), dem.get(i).getDesc_Colis(), dem.get(i).getNom_client(),
						dem.get(i).getPrenom_client(), dem.get(i).getRaison_sociale(), dem.get(i).getNumTel_client(),
						dem.get(i).getPoids(), dem.get(i).getNom(), dem.get(i).getPrenom(), dem.get(i).getTel(),
						dem.get(i).getNomVilleC(), dem.get(i).getNomGouverneratC(), dem1.get(i).getNomVilleM(),
						dem1.get(i).getNomGouverneratM(), dem.get(i).getNomEtat(), dem.get(i).getIdCom());
				// on remplit une liste avec tous les informations et les villes de destination
				// et d'expédition
				Demandes.add(demDT);
				i = i + 1;

			}
			m.addAttribute("demandes", Demandes);
			

			return "SuiviEtatAdmin";
		}
	
	
	
	// affichage de la liste des commandes
	@GetMapping("/list")
	public String getDemandes(Model m) {

		List<DemandeJoinDto> dem = demandejoinService.AffichageDemandeDestination();
		List<DemandeJoinDto> dem1 = demandejoinService.AffichageDemandeExpedition();

		List<DemandeJoinDto> Demandes = new ArrayList<DemandeJoinDto>();

		int i = 0;
		while (i < dem.size() && (i < dem1.size())) {
			DemandeJoinDto demDT = new DemandeJoinDto(dem.get(i).getDate_com(), dem.get(i).getAdresse_marchand(),
					dem.get(i).getAdresse_client(), dem.get(i).getCode_Postale_marchand(),
					dem.get(i).getCode_Postale_client(), dem.get(i).getDesc_Colis(), dem.get(i).getNom_client(),
					dem.get(i).getPrenom_client(), dem.get(i).getRaison_sociale(), dem.get(i).getNumTel_client(),
					dem.get(i).getPoids(), dem.get(i).getNom(), dem.get(i).getPrenom(), dem.get(i).getTel(),
					dem.get(i).getNomVilleC(), dem.get(i).getNomGouverneratC(), dem1.get(i).getNomVilleM(),
					dem1.get(i).getNomGouverneratM(), dem.get(i).getNomEtat(), dem.get(i).getIdCom());
			// on remplit une liste avec tous les informations et les villes de destination
			// et d'expédition
			Demandes.add(demDT);
			i = i + 1;

		}
		m.addAttribute("vehicules", vehiSer.getVehiculeDispo());
	m.addAttribute("chauffeurs", chauffSer.chauffDipo());
		m.addAttribute("demandes", Demandes);
		AffectationRegisterDto affCom = new AffectationRegisterDto();
		m.addAttribute("affectCommande", affCom);

		return "list";
	}

	// intermédiare pour afficher la liste des chauffeurs corresponds aux
	// villes(grand tunis ou tous les gouvernerats)
	@RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
	public ModelAndView getDemandesid(Model m, @PathVariable int id) {
		if (id == 1) {
			m.addAttribute("chauffeurs", chauffSer.chauffDispoTunis());
		} else if (id == 2) {
			m.addAttribute("chauffeurs", chauffSer.chauffDispoGouver());

		}
		return new ModelAndView("subView");
	}

	@GetMapping("/suiviColis")
	public String getDemandesMarchand(Model m)
			throws JsonProcessingException, FileNotFoundException, UnsupportedEncodingException {
		//List<DemandeJoinDto> dem = demandejoinService.AffichageDemandeExpeditionMarch();
		List<DemandeJoinDto> dem1 = demandejoinService.AffichageDemandeDestinationMarch();

	/*	List<DemandeJoinDto> Demandes = new ArrayList<DemandeJoinDto>();

		int i = 0;
		while (i < dem.size() && (i < dem1.size())) {
			System.out.print(dem.get(i).getDate_com() +" "+dem.get(i).getAdresse_marchand()+" "+
					dem.get(i).getAdresse_client()+" "+dem.get(i).getCode_Postale_marchand()+" "+
					dem.get(i).getCode_Postale_client()+" "+ dem.get(i).getDesc_Colis()+" "+dem.get(i).getNom_client()+" "+
					dem.get(i).getPrenom_client()+" "+dem.get(i).getRaison_sociale()+" "+dem.get(i).getNumTel_client()+" "+
					dem.get(i).getPoids());
			DemandeJoinDto demDT = new DemandeJoinDto(dem.get(i).getDate_com(), dem.get(i).getAdresse_marchand(),
					dem.get(i).getAdresse_client(), dem.get(i).getCode_Postale_marchand(),
					dem.get(i).getCode_Postale_client(), dem.get(i).getDesc_Colis(), dem.get(i).getNom_client(),
					dem.get(i).getPrenom_client(), dem.get(i).getRaison_sociale(), dem.get(i).getNumTel_client(),
					dem.get(i).getPoids(), dem.get(i).getNom(), dem.get(i).getPrenom(), dem.get(i).getTel(),
					dem.get(i).getNomVilleC(), dem.get(i).getNomGouverneratC(), dem1.get(i).getNomVilleM(),
					dem1.get(i).getNomGouverneratM(), dem.get(i).getNomEtat(), dem.get(i).getIdCom());
			Demandes.add(demDT);
			i = i + 1;

		}
		  
		
		
		ObjectMapper mapper = new ObjectMapper();
	      //Converting the Object to JSONString
	      String jsonString = mapper.writeValueAsString(Demandes);
	      
	    
	      PrintWriter writer = new PrintWriter("D:/ameni/projet/GestLivraison/src/main/resources/static/texte/data.txt","UTF-8");
	      writer.println("{\"data\":");
	      writer.println(jsonString);
	      writer.println("}");
	   writer.close();
		
		
		
		/* File file = new File("D:/ameni/projet/GestLivraison/src/main/resources/static/texte/data.txt");
			PrintWriter writer = new PrintWriter(file,
					"UTF-8");
ObjectMapper mapper = new ObjectMapper();
	// Converting the Object to JSONString
	
	Gson g = new Gson();
	      String jsonString = g.toJson(Demandes);
	     

				//	writer.print("");
			writer.println("{\"data\":");
			writer.println(jsonString);
			writer.println("}");
			writer.close();
		System.out.println(jsonString);

*/
		
		
		m.addAttribute("demandes", dem1);
		return "suiviColis";
	}

	// affichage des commandes trier par site(grandtunis,tous les gouvernerat)
	@RequestMapping(value = "/afficherCommandeTrier", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<DemandeJoinDto> AfficherCommandeParSite(@RequestBody SelectLibelle selectLibelle,
			Model m) {

		// si on sélectionne grand tunis
		if (selectLibelle.getId() == 1) {
			m.addAttribute("value", selectLibelle.getId());
			List<DemandeJoinDto> dem = demandejoinService.AffichageDemandeDestinationGrTunis();
			List<DemandeJoinDto> dem1 = demandejoinService.AffichageDemandeExpeditionGrTunis();

			List<DemandeJoinDto> Demandes = new ArrayList<DemandeJoinDto>();

			// i compteur pour dem(destination)
			// j compteur pour dem1(expediteur)
			int j = 0;
			int i = 0;
			//si les deux listes ne sont pas vides
			if((dem.size()>0)&&(dem1.size()>0))
			{
			while (i < dem.size()) {// si l'ids colis sont égaux
				if (dem.get(i).getId_colis().getId_colis() == dem1.get(j).getId_colis().getId_colis()) {
					DemandeJoinDto demDT = new DemandeJoinDto(dem.get(i).getDate_com(),
							dem.get(i).getAdresse_marchand(), dem.get(i).getAdresse_client(),
							dem.get(i).getCode_Postale_marchand(), dem.get(i).getCode_Postale_client(),
							dem.get(i).getDesc_Colis(), dem.get(i).getNom_client(), dem.get(i).getPrenom_client(),
							dem.get(i).getRaison_sociale(), dem.get(i).getNumTel_client(), dem.get(i).getPoids(),
							dem.get(i).getNom(), dem.get(i).getPrenom(), dem.get(i).getTel(), dem.get(i).getNomVilleC(),
							dem.get(i).getNomGouverneratC(), dem1.get(j).getNomVilleM(),
							dem1.get(j).getNomGouverneratM(), dem.get(i).getNomEtat(), dem.get(i).getIdCom());

					// alors on remplit la liste et incrémente i
					Demandes.add(demDT);
					j = 0;
					;
					i++;
				} else {// sinon on incrémente j
					j++;
				}
				// si dem1 est terminé on incrémente i et on initialise i à zero
				if (j >= dem1.size()) {
					i++;
					j = 0;
				}
			}
			return Demandes;
			}
			//sinon on retourne la liste vide
			else {

			return Demandes;
			}

		}
		// sinon on sélectionne hors grand tunis
		// on fait les trois combinaison (grand tunis,hors grand tunis) (hors grand
		// tunis,grand tunis) (hors grand tunis,
		// hors grand tunis)
		else if (selectLibelle.getId() == 2) {

			List<DemandeJoinDto> demh = demandejoinService.AffichageDemandeDestinationHorsGrTunis();
			List<DemandeJoinDto> demh1 = demandejoinService.AffichageDemandeExpeditionHorsGrTunis();
			;
			List<DemandeJoinDto> Demandes = new ArrayList<DemandeJoinDto>();

			int j = 0;
			int i = 0;
			
			if((demh.size()>0)&&(demh1.size()>0))
			{
			while (i < demh.size()) {

				if (demh.get(i).getId_colis().getId_colis() == demh1.get(j).getId_colis().getId_colis()) {
					DemandeJoinDto demDT = new DemandeJoinDto(demh.get(i).getDate_com(),
							demh.get(i).getAdresse_marchand(), demh.get(i).getAdresse_client(),
							demh.get(i).getCode_Postale_marchand(), demh.get(i).getCode_Postale_client(),
							demh.get(i).getDesc_Colis(), demh.get(i).getNom_client(), demh.get(i).getPrenom_client(),
							demh.get(i).getRaison_sociale(), demh.get(i).getNumTel_client(), demh.get(i).getPoids(),
							demh.get(i).getNom(), demh.get(i).getPrenom(), demh.get(i).getTel(), demh.get(i).getNomVilleC(),
							demh.get(i).getNomGouverneratC(), demh1.get(j).getNomVilleM(),
							demh1.get(j).getNomGouverneratM(), demh.get(i).getNomEtat(), demh.get(i).getIdCom());

					Demandes.add(demDT);
					j = 0;
					
					i++;
				} else {
					j++;
				}
				if (j >= demh1.size()) {
					i++;
					j = 0;
				}
			}
		

			}
			
			List<DemandeJoinDto> dema = demandejoinService.AffichageDemandeDestinationHorsGrTunis();
			List<DemandeJoinDto> dema1 = demandejoinService.AffichageDemandeExpeditionGrTunis();
			int a = 0;
			int b = 0;
			
			if((dema.size()>0)&&(dema1.size()>0))
			{
			while (a < dema.size()) {
				if (dema.get(a).getId_colis().getId_colis() == dema1.get(b).getId_colis().getId_colis()) {
					DemandeJoinDto demDT = new DemandeJoinDto(dema.get(a).getDate_com(),
							dema.get(a).getAdresse_marchand(), dema.get(a).getAdresse_client(),
							dema.get(a).getCode_Postale_marchand(), dema.get(a).getCode_Postale_client(),
							dema.get(a).getDesc_Colis(), dema.get(a).getNom_client(), dema.get(a).getPrenom_client(),
							dema.get(a).getRaison_sociale(), dema.get(a).getNumTel_client(), dema.get(a).getPoids(),
							dema.get(a).getNom(), dema.get(a).getPrenom(), dema.get(a).getTel(),
							dema.get(a).getNomVilleC(), dema.get(a).getNomGouverneratC(), dema1.get(b).getNomVilleM(),
							dema1.get(b).getNomGouverneratM(), dema.get(a).getNomEtat(), dema.get(a).getIdCom());

					Demandes.add(demDT);
					b = 0;
					a++;
				} else {
					b++;
				}
				if (b >= dema1.size()) {
					a++;
					b = 0;
				}
				
			}
			
			}
			
			int c = 0;
			int d = 0;
			List<DemandeJoinDto> deman = demandejoinService.AffichageDemandeDestinationGrTunis();
			List<DemandeJoinDto> deman1 = demandejoinService.AffichageDemandeExpeditionHorsGrTunis();
			if((deman.size()>0)&&(deman1.size()>0))
			{
			while (c < deman.size()) {
				if (deman.get(c).getId_colis().getId_colis() == deman1.get(d).getId_colis().getId_colis()) {
					DemandeJoinDto demDT = new DemandeJoinDto(deman.get(c).getDate_com(),
							deman.get(c).getAdresse_marchand(), deman.get(c).getAdresse_client(),
							deman.get(c).getCode_Postale_marchand(), deman.get(c).getCode_Postale_client(),
							deman.get(c).getDesc_Colis(), deman.get(c).getNom_client(), deman.get(c).getPrenom_client(),
							deman.get(c).getRaison_sociale(), deman.get(c).getNumTel_client(), deman.get(c).getPoids(),
							deman.get(c).getNom(), deman.get(c).getPrenom(), deman.get(c).getTel(),
							deman.get(c).getNomVilleC(), deman.get(c).getNomGouverneratC(),
							deman1.get(d).getNomVilleM(), deman1.get(d).getNomGouverneratM(), deman.get(c).getNomEtat(),
							deman.get(c).getIdCom());

					Demandes.add(demDT);
					d = 0;
					;
					c++;
				} else {
					d++;
				}
				if (d >= deman1.size()) {
					c++;
					d = 0;
				}

			}
			

		}
			return Demandes;
		}

		List<DemandeJoinDto> DemandesVide = new ArrayList<DemandeJoinDto>();
		return DemandesVide;
	}

	@GetMapping("/ModifierEtatChauffeur")
	public String getDemandes1(Model m) {
		List<DemandeJoinDto> dem = demandejoinService.AffichageDemandeDestinationChauffeur();
		List<DemandeJoinDto> dem1 = demandejoinService.AffichageDemandeExpeditionChauffeur();

		List<DemandeJoinDto> Demandes = new ArrayList<DemandeJoinDto>();
		int i = 0;
		while (i < dem.size() && (i < dem1.size()))
		{
			DemandeJoinDto demDT = new DemandeJoinDto(dem.get(i).getMatricule(),dem.get(i).getDate_com(), dem.get(i).getAdresse_marchand(),
					dem.get(i).getAdresse_client(), dem.get(i).getCode_Postale_marchand(),
					dem.get(i).getCode_Postale_client(), dem.get(i).getDesc_Colis(), dem.get(i).getNom_client(),
					dem.get(i).getPrenom_client(), dem.get(i).getRaison_sociale(), dem.get(i).getNumTel_client(),
					dem.get(i).getPoids(), dem.get(i).getNom(), dem.get(i).getPrenom(), dem.get(i).getTel(),
					dem.get(i).getNomVilleC(), dem.get(i).getNomGouverneratC(), dem1.get(i).getNomVilleM(),
					dem1.get(i).getNomGouverneratM(), dem.get(i).getNomEtat(), dem.get(i).getIdCom());

			Demandes.add(demDT);
			i = i + 1;

		}

		m.addAttribute("demandes", Demandes);
		ModifierEtatChauffDto ModiEtat = new ModifierEtatChauffDto();
		m.addAttribute("ModifierEtat", ModiEtat);
		return "ModifierEtatChauffeur";
	}

}
