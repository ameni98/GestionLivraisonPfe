package net.javaguides.springboot.springsecurity.web;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.javaguides.springboot.springsecurity.model.Chauffeur;
import net.javaguides.springboot.springsecurity.model.Marchand;
import net.javaguides.springboot.springsecurity.model.User;
import net.javaguides.springboot.springsecurity.model.Vehicule;
import net.javaguides.springboot.springsecurity.repository.MarchandRepository;
import net.javaguides.springboot.springsecurity.repository.UserRepository;
import net.javaguides.springboot.springsecurity.service.ChangeProfilMarchandService;
import net.javaguides.springboot.springsecurity.service.ChangeProfilService;
import net.javaguides.springboot.springsecurity.service.UserService;
import net.javaguides.springboot.springsecurity.web.dto.ChangeProfilDto;
import net.javaguides.springboot.springsecurity.web.dto.ChangeProfilMarchandDto;
import net.javaguides.springboot.springsecurity.web.dto.VehiculeRegistrationDto;
@Controller
public class ChangeProfilMarchandController {
@Autowired
UserService userSer;
@Autowired
UserRepository userRep;
@Autowired
ChangeProfilMarchandService changeProfileSer;
@Autowired
MarchandRepository marchRep;



@GetMapping("/modifierProfilMarchand")
public ModelMap tampilkanForm(Model m ) throws Exception {
Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

String username = ((UserDetails)principal).getUsername();
 User user= userSer.findByEmail(username);
 System.out.print("hh    "+username);
if(user!=null)
{
	long id= user.getId();
	Marchand marchand=(Marchand) userRep.findById(id);
	 System.out.print(id);
	ChangeProfilMarchandDto form=new ChangeProfilMarchandDto();
	form.setEmail(username);

	form.setTel(marchand.getTel());
	form.setAdresse(marchand.getAdresse());
	m.addAttribute("marchand",form);
	return new ModelMap("marchand", form);
}
ChangeProfilMarchandDto form=new ChangeProfilMarchandDto();
return new ModelMap("marchand", form);
//System.out.print("hello    "+changeProfileSer.findById(id)+"     ");

//Optional<Marchand> marchand=changeProfileSer.findById(id);
//System.out.print("hello    "+marchand+"     ");




}  

   @PostMapping("/modifierProfilMarchand")
   public String enregistrer(@Valid @ModelAttribute("marchand") ChangeProfilMarchandDto marchand, BindingResult errors, SessionStatus status,Model model,
    RedirectAttributes redirectAttrs) throws Exception {
   
    if(errors.hasErrors())
    {System.out.print("rani beche nehbel");
     return "modifierProfilMarchand";
    }
    
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    String username = ((UserDetails)principal).getUsername();
     User user= userSer.findByEmail(username);
    // System.out.print(id);
     if(user!=null)
     {
    long id= user.getId();
    System.out.print("hello  "+id+" ");
   Optional<Marchand> ma= marchRep.findById(id);
   Marchand m = ma.get();
    //Marchand m=(Marchand) userRep.findById(id);
  m.setId(id);
   System.out.print("adresse"+marchand.getAdresse()+"\n");
   System.out.print("eamil"+marchand.getEmail()+"\n");
   System.out.print("tel"+marchand.getTel()+"\n");
    m.setAdresse(marchand.getAdresse());
    m.setEmail(marchand.getEmail());
    m.setTel(marchand.getTel());
    System.out.print("hello  "+m.getTel()+" ");
    
   
   
    userRep.save(m); 
    return "redirect:/modifierProfilMarchand?success";
     }
    status.setComplete();
    return "redirect:/modifierProfilMarchand";
     //  return "/modifierProfilMarchand";
 }


 
  }


