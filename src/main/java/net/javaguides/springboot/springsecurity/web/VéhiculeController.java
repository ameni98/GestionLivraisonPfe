package net.javaguides.springboot.springsecurity.web;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import net.javaguides.springboot.springsecurity.service.VéhiculeService;
import net.javaguides.springboot.springsecurity.web.dto.VehiculeRegistrationDto;
import net.javaguides.springboot.springsecurity.exception.RecordNotFoundException;
import net.javaguides.springboot.springsecurity.model.Vehicule;


@Controller
@ControllerAdvice
public class VéhiculeController {

	 @Autowired
	 VéhiculeService véhiculeservice;
	 
	  @GetMapping("/vehicule/list")
	    public ModelMap Véhicule(@PageableDefault(size = 7) Pageable pageable, @RequestParam(name = "value", required = false) String value, Model model){
	      //si la valeur passée en argument est different de null c'est à dire on va faire la recherche 
		  //on doit afficher les véhicules avec cette matricule 
		  if (value != null) {
	         //   model.addAttribute("valeur", value);
	            
	            return new ModelMap().addAttribute("vehicules",véhiculeservice.findByMatricule(value, pageable));
	        } else {
	        	//sinon on affiche tous les véhicules
	            return new ModelMap().addAttribute("vehicules", véhiculeservice.getAllVéhicule(pageable));
	        }
	    }



	    @GetMapping("/vehicule/form")
	    public ModelMap AfficherForm(@RequestParam(value = "id", required = false)Vehicule vehicule ,Model m) {
	    	//pour l'ajout
	    	 if (vehicule == null) {
	    		
		        	VehiculeRegistrationDto vehi= new VehiculeRegistrationDto();
		        	//c'est pour ajouter un attribut pour la liste de séléction disponible
		        m.addAttribute("vehi", vehicule);
		        m.addAttribute("titre","Ajouter véhicule");
		        	return new ModelMap("vehicule", vehi);
		        }
	    
	    	 VehiculeRegistrationDto v= new VehiculeRegistrationDto();
	    	 
	    	 v.setMarque(vehicule.getMarque());
	    	 v.setCapacite(String.valueOf(vehicule.getCapacite()));
	    	 v.setDispo(vehicule.getDispo());
	    	 v.setMatricule(vehicule.getMatricule());
	    	 v.setId(vehicule.getId());
	    	  m.addAttribute("vehi", vehicule.getId());
	    	  m.addAttribute("titre","Modifier véhicule");
		        return new ModelMap("vehicule", v);
		    }
	       
	    @PostMapping("/vehicule/form")
	    public String enregistrer(@Valid @ModelAttribute("vehicule") VehiculeRegistrationDto vehiculedto , BindingResult errors, SessionStatus status,Model model,
	    		RedirectAttributes redirectAttrs) {
	    
	    	if(errors.hasErrors())
	    	{
	    		  return "/vehicule/form";
	    	}
	    		Vehicule v=new Vehicule();
	    		v.setCapacite(Float.parseFloat(vehiculedto.getCapacite()));
	    		v.setMarque(vehiculedto.getMarque());
	    		v.setMatricule(vehiculedto.getMatricule());
	    		v.setId(vehiculedto.getId());
	    		
	    		v.setDispo(vehiculedto.getDispo());
	    		véhiculeservice.addVéhicule(v);
	    	  	String message=null;
	    		
	    	 //s'il s'agit de modification message prend la valeur Modification réussite
	    		 if(vehiculedto.getId()!=null)
	    		 {message="Modification réussite";
	    			 
	    		 }
	    		 //s'il s'agit de modification message prend la valeur Enregistrement réussite
	    		 else {message="Enregistrement réussite";
	    			 
	    		 }
	    		 //si l'ajout ou la modification est bien faite on passe le message a javascript  
	    		if(véhiculeservice.addVéhicule(v)!=null)
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
	    		 
	 	      
	 	      
	 	        return "redirect:/vehicule/list";
	    }
	   
	   
	    @GetMapping("/vehicule/delete")
	    public ModelMap deleteConfirm(@RequestParam(value = "id", required = true) Vehicule vehicule,Model m) {
	 Long    id=	vehicule.getId();
	 
	 m.addAttribute("id", id);
	    	return new ModelMap("vehicule", vehicule);
	    }
	    
	 
	   
	   
	@PostMapping("/vehicule/delete")
	    public String delete( @ModelAttribute ("vehicule") Vehicule vehicule,    BindingResult result,ModelMap m) throws RecordNotFoundException  {
	    //String m=	v.getMatricule();
	    Long i=vehicule.getId();
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
	    	m.addAttribute("vehicule", vehicule);
	   	véhiculeservice.deleteVehicule(vehicule);;
	        return "redirect:/vehicule/list";
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
	    
	  
	 
	 
	    