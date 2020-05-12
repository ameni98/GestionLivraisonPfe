package net.javaguides.springboot.springsecurity.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.javaguides.springboot.springsecurity.model.AffectationCommandeEtat;
import net.javaguides.springboot.springsecurity.model.Colis;
import net.javaguides.springboot.springsecurity.model.Commande;
import net.javaguides.springboot.springsecurity.model.EtatCommande;
import net.javaguides.springboot.springsecurity.model.GouverneartCritere;
import net.javaguides.springboot.springsecurity.model.Gouvernerat;
import net.javaguides.springboot.springsecurity.model.Marchand;
import net.javaguides.springboot.springsecurity.model.TypeDestination;
import net.javaguides.springboot.springsecurity.model.User;
import net.javaguides.springboot.springsecurity.model.Ville;
import net.javaguides.springboot.springsecurity.model.VilleColis;
import net.javaguides.springboot.springsecurity.repository.ColisRepositry;
import net.javaguides.springboot.springsecurity.repository.CommandeRepositry;
import net.javaguides.springboot.springsecurity.repository.UserRepository;
import net.javaguides.springboot.springsecurity.service.AffectationCommandeEtatService;
import net.javaguides.springboot.springsecurity.service.ColisService;
import net.javaguides.springboot.springsecurity.service.CommandeService;
import net.javaguides.springboot.springsecurity.service.GouverneratService;
import net.javaguides.springboot.springsecurity.service.UserService;
import net.javaguides.springboot.springsecurity.service.UserServiceImpl;
import net.javaguides.springboot.springsecurity.service.VilleColisService;
import net.javaguides.springboot.springsecurity.service.VilleService;
import net.javaguides.springboot.springsecurity.web.dto.CommandeRegistrationDto;
import net.javaguides.springboot.springsecurity.web.dto.MarchandRegistrationDto;
import net.javaguides.springboot.springsecurity.web.dto.UserRegistrationDto;
@Controller
//@RequestMapping("/index")
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
    @Autowired
    private AffectationCommandeEtatService affectationCommandeEtatSer;
    
    
    @ModelAttribute("colis")
    public CommandeRegistrationDto commandeRegistrationDto() {
        return new CommandeRegistrationDto();
    }
    
    @GetMapping(value= ("/commande"))
    
    public String showcommandeColis(Model model) { 
    model.addAttribute("gouvernerats",GouvSer.getAllGouvernerat());
    List<Ville> villes = new ArrayList<Ville>();
    model.addAttribute("villes",villes);
    return "commande";
    }

@RequestMapping(value = "/loadCityByCountry", method = RequestMethod.POST ,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody  List<Ville> loadCityByCountry(@RequestBody GouverneartCritere gouverneartCritere) {
    	Long id =gouverneartCritere.getGouverneratId();
    	System.out.print("xcvbn             "+id);
   Gouvernerat g=new Gouvernerat();
    	g.setId(id);
    	  List<Ville> villes =VilleSer.getAllVilles(g);
    /*	 for(int i=0;i<villes.size();i++)
  	    {
  	    	System.out.print(villes.get(i).getId_ville());	
  	    }*/
    	//  List<Ville> villes=new ArrayList<Ville>();
    	  return villes;
    }
 /*@RequestMapping(value = "/typdes", method = RequestMethod.POST ,)
public @ResponseBody String typedes(@RequestBody TypeDestination typedestination) { 
 // System.out.print("le nom est" + typedestination.getInputNomclient());produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE
 // System.out.print("le prenom est" + typedestination.getInputPrenomclient());
Colis colis =new Colis();
  colis.setNom_client(typedestination.getInputNomclient());
  
  colisSerivce.addColis(colis);
  CommandeRegistrationDto cmdDto=new CommandeRegistrationDto();
  cmdDto.setNom_client(typedestination.getInputNomclient());
 // colis.setPrenom_client(typedestination.getInputPrenomclient());
  return "commande";
  
	
}*/


    @RequestMapping( value="/commande",method = RequestMethod.POST)
    
public String commandeRegistrationDto(  @ModelAttribute("colis") @Valid CommandeRegistrationDto cmdDto,BindingResult result,Model model
  // MarchandRegistrationDto marchandRegister
    ) {
    	/*  model.addAttribute("gouvernerats",GouvSer.getAllGouvernerat());
    	    List<Ville> villes = new ArrayList<Ville>();
    	    model.addAttribute("villes",villes);*/
    	    	
    	  if(result.hasErrors())
    		{
    			 System.out.print("c'est faux hferfbhyer");
    			 return "commande";
    		}
    		
    	
    	  
    //	System.out.print("le nom est" + typedestination.getInputNomclient());
    	 System.out.print("le adresse est" + cmdDto.getAdresse_client());
   
   // Long idGouv=	cmdDto.getId_Gouvernerat();
    // model.addAttribute("colis",new Colis());
  //String email=marchandRegister.getEmail();
//  Long id=getId(email);
   
  
    Commande commande=new Commande();
    Colis colis=new Colis();
    
    //ce qui concerne le client
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
  
  
    
    //System.out.print("le nom est "+cmdDto.getNom_client());
    
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String username = authentication.getName();
    Marchand m=(Marchand) userRepositry.findByEmail(username);

    commande.setMarchandM(m);
    commande.addColisCommande(colis);
    
    
    DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
    Date date = new Date();
    commande.setDateCom(format.format(date));
  //  model.addAttribute("commande",commande);
   
    
  Commande com=  commandeService.addCommande(commande);
  Colis col=  colisSerivce.addColis(colis);
     
    VilleColis vc=new VilleColis(); 
 //setters (colis)pour villeColis    
  vc.setColis(colis);
  Ville v=new Ville();
  v.setId_ville(Long.parseLong(cmdDto.getVille_client()));
  
//setters (ville)pour villeColis    
    vc.setVille(v);

 
    vc.setDescription("Adresse de destination");
  if(cmdDto.getVille_client()!=null)
   {
	   villeColiSer.enregistrer(vc);
  }
    	 
    
 
    
  VilleColis vc1=new VilleColis(); 
  vc1.setColis(colis);
Ville v1=new Ville();
v1.setId_ville(Long.parseLong(cmdDto.getVille_marchand()));
  vc1.setVille(v1);
    vc1.setDescription("Adresse d'expedition");

   if(cmdDto.getVille_marchand()!=null)
    {
   villeColiSer.enregistrer(vc1);
    }
//création de affectation Commande Etat
   AffectationCommandeEtat AffComEt=new AffectationCommandeEtat();
   //setters (commande) pour AffectationCommandeEtat
   AffComEt.setCommande(com); 
   AffComEt.setDate(format.format(date));
   EtatCommande Ec=new EtatCommande();
   Ec.setId(1);
   //setters (commande) pour AffectationCommandeEtat
   AffComEt.setEtatCommande(Ec);
   affectationCommandeEtatSer.enregistrer(AffComEt);
   
   
   return "redirect:/commande?success";
    	  
//  villeColiSer.enregistrer(vc1);
  
  
  
   /*
    colis.setVille_client(cmdDto.getVille_client());
    colis.setVille_marchand(cmdDto.getVille_marchand());*/
//  TypeDestination Tys =typedes(); 

  
  
 
  
  //colis.setVillesColis(new VilleColis(cmdDto.getVille_client(), "Adresse client")); 
 
 //Colis col=   colisRepositry.save(colis,);
   
   
    // c.setId_colis(id_colis);
   
 /*Marchand m=new Marchand();
 m.setId(id);
    commande.setMarchandM( userRepositry.findById(id));*/
    
 //Commande com=commandeRepositry.save(commande);
   
 //Colis col=   colisRepositry.save(colis);
 
	
 /*if(col!=null&&com!=null)
 {
	 model.addAttribute("message","demande envoyé avec succée");
 }*/
        
    }
    
    }

