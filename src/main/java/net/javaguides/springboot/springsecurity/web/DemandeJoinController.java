package net.javaguides.springboot.springsecurity.web;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.javaguides.springboot.springsecurity.service.ChauffeurService;
import net.javaguides.springboot.springsecurity.service.DemandeJoinService;
import net.javaguides.springboot.springsecurity.service.VéhiculeService;
import net.javaguides.springboot.springsecurity.web.dto.AffectationRegisterDto;
import net.javaguides.springboot.springsecurity.web.dto.DemandeJoinDto;

@Controller
public class DemandeJoinController {
	@Autowired
	private DemandeJoinService demandejoinService;
	@Autowired
	private VéhiculeService vehiSer;
	@Autowired
	private ChauffeurService chauffSer;
	@GetMapping("/list")
	public String  getDemandes(Model m) {
		List<DemandeJoinDto> dem=demandejoinService.AffichageDemandeDestination();
		List<DemandeJoinDto> dem1=demandejoinService.AffichageDemandeExpedition();
		
		List<DemandeJoinDto> Demandes=new ArrayList<DemandeJoinDto>();
		//for(int i=0;i<dem.size();i+=2)
		int i=0;
			while(i<dem.size()&&(i<dem1.size()))
				//i=0;
		{//DemandeJoinDto demDT=new DemandeJoinDto(dem.get(i).getDate_com(),dem.get(i).getAdresse_marchand(),dem.get(i).getAdresse_client() ,dem.get(i).getCode_Postale_marchand(),dem.get(i).getCode_Postale_client(),dem.get(i).getDesc_Colis(),dem.get(i).getNom_client(),dem.get(i).getPrenom_client(),dem.get(i).getRaison_sociale(),dem.get(i).getNumTel_client(),dem.get(i).getPoids(),dem.get(i).getNom(),dem.get(i).getPrenom(),dem.get(i).getTel(), dem.get(i).getNomVilleC(),dem.get(i).getNomGouverneratC(), dem.get(i+1).getNomVilleM(),dem.get(i+1).getNomGouverneratM(),dem.get(i).getNomEtat(),dem.get(i).getIdCom());
		DemandeJoinDto demDT=new DemandeJoinDto(dem.get(i).getDate_com(),dem.get(i).getAdresse_marchand(),dem.get(i).getAdresse_client() ,dem.get(i).getCode_Postale_marchand(),dem.get(i).getCode_Postale_client(),dem.get(i).getDesc_Colis(),dem.get(i).getNom_client(),dem.get(i).getPrenom_client(),dem.get(i).getRaison_sociale(),dem.get(i).getNumTel_client(),dem.get(i).getPoids(),dem.get(i).getNom(),dem.get(i).getPrenom(),dem.get(i).getTel(), dem.get(i).getNomVilleC(),dem.get(i).getNomGouverneratC(), dem1.get(i).getNomVilleM(),dem1.get(i).getNomGouverneratM(),dem.get(i).getNomEtat(),dem.get(i).getIdCom());
				
				Demandes.add(demDT );
		i=i+1;
			
		}
		//vehiSer.getVehiculeDispo();
		m.addAttribute("vehicules",vehiSer.getVehiculeDispo());
		m.addAttribute("chauffeurs",chauffSer.chauffDispo());
		m.addAttribute("demandes", Demandes);
		AffectationRegisterDto affCom=new AffectationRegisterDto();
		m.addAttribute("affectCommande",affCom);
		return "list";
	}
	@GetMapping("/suiviColis")
	public String  getDemandesMarchand(Model m) throws JsonProcessingException, FileNotFoundException, UnsupportedEncodingException {
		List<DemandeJoinDto> dem=demandejoinService.AffichageDemandeExpeditionMarch();
		List<DemandeJoinDto> dem1=demandejoinService.AffichageDemandeDestinationMarch();
		
		List<DemandeJoinDto> Demandes=new ArrayList<DemandeJoinDto>();
		//for(int i=0;i<dem.size();i+=2)
		int i=0;
			while(i<dem.size()&&(i<dem1.size()))
				//i=0;
		{//DemandeJoinDto demDT=new DemandeJoinDto(dem.get(i).getDate_com(),dem.get(i).getAdresse_marchand(),dem.get(i).getAdresse_client() ,dem.get(i).getCode_Postale_marchand(),dem.get(i).getCode_Postale_client(),dem.get(i).getDesc_Colis(),dem.get(i).getNom_client(),dem.get(i).getPrenom_client(),dem.get(i).getRaison_sociale(),dem.get(i).getNumTel_client(),dem.get(i).getPoids(),dem.get(i).getNom(),dem.get(i).getPrenom(),dem.get(i).getTel(), dem.get(i).getNomVilleC(),dem.get(i).getNomGouverneratC(), dem.get(i+1).getNomVilleM(),dem.get(i+1).getNomGouverneratM(),dem.get(i).getNomEtat(),dem.get(i).getIdCom());
		DemandeJoinDto demDT=new DemandeJoinDto(dem.get(i).getDate_com(),dem.get(i).getAdresse_marchand(),dem.get(i).getAdresse_client() ,dem.get(i).getCode_Postale_marchand(),dem.get(i).getCode_Postale_client(),dem.get(i).getDesc_Colis(),dem.get(i).getNom_client(),dem.get(i).getPrenom_client(),dem.get(i).getRaison_sociale(),dem.get(i).getNumTel_client(),dem.get(i).getPoids(),dem.get(i).getNom(),dem.get(i).getPrenom(),dem.get(i).getTel(), dem.get(i).getNomVilleC(),dem.get(i).getNomGouverneratC(), dem1.get(i).getNomVilleM(),dem1.get(i).getNomGouverneratM(),dem.get(i).getNomEtat(),dem.get(i).getIdCom());
				
				Demandes.add(demDT );
		i=i+1;
			
		}
		//vehiSer.getVehiculeDispo();
		//Demandes.toJson();
		m.addAttribute("demandes", Demandes);
		   ObjectMapper mapper = new ObjectMapper();
		      //Converting the Object to JSONString
		      String jsonString = mapper.writeValueAsString(Demandes);
		      PrintWriter writer = new PrintWriter("C:/Users/lenovo/Desktop/pfe/vDer/Liv3/LivraisonPfe/Liv3/src/main/resources/static/texte/data.txt","UTF-8");
		      writer.println("{\"data\":");
		      writer.println(jsonString);
		      writer.println("}");
		   writer.close();
		      System.out.println(jsonString);
		return "suiviColis";
	}

	


}
