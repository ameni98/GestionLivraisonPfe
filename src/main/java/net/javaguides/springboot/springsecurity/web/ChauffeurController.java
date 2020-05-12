package net.javaguides.springboot.springsecurity.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.javaguides.springboot.springsecurity.exception.RecordNotFoundException;
import net.javaguides.springboot.springsecurity.model.Chauffeur;
import net.javaguides.springboot.springsecurity.model.EtatDispo;
import net.javaguides.springboot.springsecurity.service.ChauffeurService;
import net.javaguides.springboot.springsecurity.service.EtatDispoService;
import net.javaguides.springboot.springsecurity.service.VéhiculeService;
import net.javaguides.springboot.springsecurity.web.dto.ChauffeurRegistrationDto;
import net.javaguides.springboot.springsecurity.web.dto.JoinRep;
import net.javaguides.springboot.springsecurity.web.dto.MarchandRegistrationDto;
@Controller
public class ChauffeurController {
	
		 @Autowired
		 ChauffeurService chauffeurService;
		 @Autowired
		 EtatDispoService EtatDispoSer;
		 @Autowired
		    private BCryptPasswordEncoder passwordEncoder;
		 
		  @GetMapping("/chauffeur/list")
		    public ModelMap Chauffeur(@PageableDefault(size = 5) Pageable pageable, @RequestParam(name = "value", required = false) String value, Model model){
		        if (value != null) {
		            model.addAttribute("key", value);
		            return new ModelMap().addAttribute("chauffeurs",chauffeurService.findByNom(value, pageable));
		        } else {
		            return new ModelMap().addAttribute("chauffeurs", chauffeurService.getAllChauffeur(pageable));//addAttribute("ids", chauffeurService.getAllIdchauffeur());
		        }
		    }



		    @GetMapping("/chauffeur/form")
		    public ModelMap AffichageFormChauff(@RequestParam(value = "id", required = false)Chauffeur chauffeur ,Model m) {
		    	// pour l'ajout
		        if (chauffeur == null) {
		        	ChauffeurRegistrationDto chauff= new ChauffeurRegistrationDto();
		        	//passer chauffeur à la vue  pour désactiver l'input disponibilté en cas d'ajout
		        	m.addAttribute("ch", chauffeur);
		        	 m.addAttribute("titre","Ajouter chauffeur");
		        	return new ModelMap("chauffeur", chauff);
		        }
		      //si pour la modification
		        ChauffeurRegistrationDto chauff= new ChauffeurRegistrationDto();
		        
		        //placer les données dans les champs si il'ya modification
		        chauff.setId(chauffeur.getId());
		       chauff.setNom( chauffeur.getNom());
		       chauff.setPrenom(( chauffeur.getPrenom()));
		       chauff.setNumCin(chauffeur.getCin());
		       chauff.setDateNai(( chauffeur.getDateNai()));
		       chauff.setNumPermi( chauffeur.getNumPermis());
		       chauff.setNumTel(chauffeur.getNumTel());
		       chauff.setLogin( chauffeur.getNomUtilisateur());
		       chauff.setMotPasse(chauffeur.getPassword());
		       //récupération de l'etat de disponibilite
		        EtatDispo dispo=  chauffeur.getEtatDispo();
		        Long idEtat= dispo.getId();
		        String   nom= dispo.getNom();
		        System.out.print("le nom est"+nom);
	        	String   date1= dispo.getDateDeb();
	            String date2= dispo.getDateFin();
	         //   placer les données de l'état de disponibliité dans les champs
		       chauff.setIdEtat(idEtat);
		       chauff.setDateFin(date2);
		       chauff.setDateDeb(date1);
		       chauff.setEtatDispo(nom);
		  
		       //passer chauffeur à la vue  pour activer l'input disponibilté en cas de modidfication
		       m.addAttribute("ch", chauffeur.getId());
		       //passer etat disponiblite à la vue  pour afficher deux dates si en conge et une date si absent
		       m.addAttribute("etat",nom);
		       m.addAttribute("date1",date1);
		       m.addAttribute("date2",date2);
		       m.addAttribute("titre","Modifier chauffeur");
		        return new ModelMap("chauffeur", chauff);
		    }


		    @PostMapping("/chauffeur/form")
		    public String enregistrer(@Valid @ModelAttribute("chauffeur") ChauffeurRegistrationDto Chauffeurdto , BindingResult errors, SessionStatus status,RedirectAttributes redirectAttrs) {
		    	Chauffeur c=new Chauffeur();
		    	if(errors.hasErrors())
		    	{ System.out.print(Chauffeurdto.getEtatDispo());
		    	//c.setEtatDispo("disponible");
		    		  return "/chauffeur/form";
		    	}
		    		//récupération des valeurs saisit et création d'un objet chauffeur avec ses données   
		    		c.setNom(Chauffeurdto.getNom());
		    		c.setPrenom(Chauffeurdto.getPrenom());
		    		c.setCin(Chauffeurdto.getNumCin());
		    		c.setDateNai(Chauffeurdto.getDateNai());
		    		c.setNumPermis(Chauffeurdto.getNumPermi());
		    		c.setNumTel((Chauffeurdto.getNumTel()));
		    		c.setNomUtilisateur((Chauffeurdto.getLogin()));
		    		 c.setPassword(passwordEncoder.encode(Chauffeurdto.getMotPasse()));
c.setTypeDeplacement(Chauffeurdto.getTypeDeplacement());
				    	
		    	//	c.setPassword((Chauffeurdto.getMotPasse()));
		    	  	System.out.print(	Chauffeurdto.getDateDeb());
		    	//	
		    	//	c.set
		 /*  	System.out.print(Chauffeurdto.getId());
		   	System.out.print(Chauffeurdto.getIdEtat());
		    	if(Chauffeurdto.getIdEtat()!=null)
		    	{
		    		
		    	}*/
		    		EtatDispo etD=new EtatDispo();
		    		etD.setId(Chauffeurdto.getIdEtat());
		    		etD.setNom(Chauffeurdto.getEtatDispo());
		    		etD.setDateDeb(Chauffeurdto.getDateDeb());
		    		etD.setDateFin(Chauffeurdto.getDateFin());
		    		EtatDispoSer.addEtat(etD);
		    		c.setEtatDispo(etD);
		    		//c.setEtDispo(etD);
		    		//c.set
		    		
		    		c.setId(Chauffeurdto.getId());
		    	
		    	
		    	
		    	//passer cet objet chauffeur en paramétre à la méthode addchauffeur
		    	chauffeurService.addChauffeur(c);
		    	String message=null;
	    		
		    	 //s'il s'agit de modification message prend la valeur Modification réussite
		    		 if(Chauffeurdto.getId()!=null)
		    		 {message="Modification réussite";
		    			 
		    		 }
		    		 //s'il s'agit de modification message prend la valeur Enregistrement réussite
		    		 else {message="Enregistrement réussite";
		    			 
		    		 }
		    		 //si l'ajout ou la modification est bien faite on passe le message a javascript  
		    		if(chauffeurService.addChauffeur(c)!=null)
		    		{
		    			  status.setComplete();
		    		//cette ligne signifie qu'on passe le message a javascript mais à la page list donc on fait la redirection
		   	 	       redirectAttrs.addFlashAttribute("message",message);
		    		}
		    		else {
		    			//sinon on affiche ce message
		    			message="Oups!Erreur est survenue";
		    			 redirectAttrs.addFlashAttribute("message",message);
		    		}
		    		 
		 	      
		        status.setComplete();
		        return "redirect:/chauffeur/list";
		    }




		 /*   @GetMapping("/vehicule/delete/{id}")
		    public String deleteConfirm(@PathVariable("id") Long id ,ModelMap map) throws RecordNotFoundException {
		    	
		    Optional<net.javaguides.springboot.springsecurity.model.Véhicule> v=	véhiculeservice.findById(id);
		    	map.addAttribute("vehicule",v);
		    	
		        //return new ModelMap("vehicule", vehicule);
		    	return "vehicule/delete";
		    }*/
		
		   
		   
		    @GetMapping("/chauffeur/delete")
		    public ModelMap deleteConfirm(@RequestParam(value = "id", required = true) Chauffeur chauffeur,Model m) {
		 Long    id=	chauffeur.getId();
		 
		 m.addAttribute("id", id);
		 
		 
		 
		 chauffeur.getEtatDispo().getNom();
		  ChauffeurRegistrationDto chauff= new ChauffeurRegistrationDto();
	        
	        //placer les données dans les champs si il'ya modification
	        chauff.setId(chauffeur.getId());
	       chauff.setNom( chauffeur.getNom());
	       chauff.setPrenom(( chauffeur.getPrenom()));
	       chauff.setNumCin(chauffeur.getCin());
	       chauff.setDateNai(( chauffeur.getDateNai()));
	       chauff.setNumPermi( chauffeur.getNumPermis());
	       chauff.setNumTel(chauffeur.getNumTel());
	       chauff.setLogin( chauffeur.getNomUtilisateur());
	       chauff.setMotPasse(chauffeur.getPassword());
	       //récupération de l'etat de disponibilite
	        EtatDispo dispo=  chauffeur.getEtatDispo();
	        Long idEtat= dispo.getId();
	        String   nom= dispo.getNom();
      	String   date1= dispo.getDateDeb();
          String date2= dispo.getDateFin();
       //   placer les données de l'état de disponibliité dans les champs
	       chauff.setIdEtat(idEtat);
	       chauff.setEtatDispo(nom);
	  
		    	return new ModelMap("chauffeur", chauff);
		    }
		    
		 
		   
		   
		@PostMapping("/chauffeur/delete")
		    public String delete( @ModelAttribute ("chauffeur") ChauffeurRegistrationDto Chauffeurdto,    BindingResult result,ModelMap m) throws RecordNotFoundException  {
		    //String m=	v.getMatricule();
		  //  Long i=chauffeur.getId();
		    Chauffeur c=new Chauffeur();
		  //  véhiculeservice.deleteVéhiculeById(i);;
		    //v.setId(id);
		    //System.out.print(id);
		    /*	if(v==null)
		    	{
		    		m.addAttribute("msg","ooooo");
		    	}
		    	else { m.addAttribute("msg","eyyyy");}*/
			//m.addAttribute("matricule", vehicule.getMatricule());
	       // m.addAttribute("id", employee.getId());
		    c.setNom(Chauffeurdto.getNom());
    		c.setPrenom(Chauffeurdto.getPrenom());
    		c.setCin(Chauffeurdto.getNumCin());
    		c.setDateNai(Chauffeurdto.getDateNai());
    		c.setNumPermis(Chauffeurdto.getNumPermi());
    		c.setNumTel((Chauffeurdto.getNumTel()));
    		c.setNomUtilisateur((Chauffeurdto.getLogin()));
    		c.setPassword((Chauffeurdto.getMotPasse()));
    	  	System.out.print(	Chauffeurdto.getDateDeb());
    	//	
    	//	c.set
 /*  	System.out.print(Chauffeurdto.getId());
   	System.out.print(Chauffeurdto.getIdEtat());
    	if(Chauffeurdto.getIdEtat()!=null)
    	{
    		
    	}*/
    		EtatDispo etD=new EtatDispo();
    		etD.setId(Chauffeurdto.getIdEtat());
    		etD.setNom(Chauffeurdto.getEtatDispo());
    		etD.setDateDeb(Chauffeurdto.getDateDeb());
    		etD.setDateFin(Chauffeurdto.getDateFin());
    		EtatDispoSer.addEtat(etD);
    		c.setEtatDispo(etD);
    		//c.setEtDispo(etD);
    		//c.set
    		
    		c.setId(Chauffeurdto.getId());
    
		    
		    	m.addAttribute("chauffeur", c);
		    	
		    	chauffeurService.deleteChauffeur(
		    			c);
		    	EtatDispoSer.deleteEtat(etD);
		        return "redirect:/chauffeur/list";
		        //return "redirect:/vehicule/list";
		    }
		   /* @RequestMapping("/vehicule/delete")
		    public String hapus (@RequestParam("id") Long id) throws RecordNotFoundException{
		    	véhiculeservice.deleteVéhiculeById(id);;
		        return "redirect:list";
		    }*/
		    
		    
	}

		    /*@PostMapping("/vehicule/delete/{id}")
		    public String  delete(@RequestParam("id") Long id , SessionStatus status) throws RecordNotFoundException 
		    	{ 	 //véhiculeservice.deleteVéhiculeById(id);
		    	Optional<net.javaguides.springboot.springsecurity.model.Véhicule> v=	véhiculeservice.findById(id);
		    		       
		 véhiculeservice.deleteVehicule(v);
		    status.setComplete();
	        return "redirect:/vehicule/list";}
		    }*/
		    
		    
		    	//catch (DataIntegrityViolationException exception) {
		          //  status.setComplete();
		         /*   return new ModelAndView("error/errorHapus")
		                    .addObject("entityId", vehicule.getMatricule())
		                    .addObject("entityName", "Vehicule")
		                    .addObject("errorCause", exception.getRootCause().getMessage())
		                    .addObject("backLink","/karyawan/list");
		        }*/
		     //   status.setComplete();
		     //   return "redirect:/vehicule/list";
		 
		    	
		    /*catch (DataIntegrityViolationException exception) {
		    	status.setComplete();
	}
	status.setComplete();
	return "redirect:/karyawan/list";

		        
		       return "redirect:/vehicule/list";*/
		    
		  
		 


