package net.javaguides.springboot.springsecurity.web;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.hibernate.validator.internal.util.logging.Log;
//import org.hibernate.validator.internal.util.logging.Log_.logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.security.core.userdetails.UserDetails;
import net.javaguides.springboot.springsecurity.model.User;
import net.javaguides.springboot.springsecurity.repository.UserRepository;
import net.javaguides.springboot.springsecurity.service.ChangeProfilService;
import net.javaguides.springboot.springsecurity.service.UserService;
import net.javaguides.springboot.springsecurity.web.dto.ChangeProfilDto;

@Controller
public class ChangeProfilController {
	@Autowired 
	UserService userSer;
	@Autowired 
	UserRepository userRep;
	
	@Autowired 
	ChangeProfilService changeProfileSer;
	@GetMapping("/modifierProfil")
	
	   public String tampilkanForm(Model m ) throws Exception {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	String	 username = ((UserDetails)principal).getUsername();
		  User user= userSer.findByEmail(username);
		  System.out.print(username);
			long id= user.getId();
			  System.out.print(id);
			ChangeProfilDto form=new ChangeProfilDto();
			form.setEmail(username);	
		
		
		//User user=userSerIml.findById(id);
	/*String email=user.getEmail();
	String pwd=user.getPassword();
	ChangeProfilDto changeProfilDto=new ChangeProfilDto();
	changeProfilDto.setId(user.getId());
	changeProfilDto.setLogin(email);
	changeProfilDto.setPwdActuel(pwd);
	*/
	m.addAttribute("user",form);
		return "modifierProfil";
		
	}
	     //  if (user == null) {
	     //   ChangeProfilDto p= new ChangeProfilDto();
	       // return new ModelMap("user", p);
	       
	     //  ChangeProfilDto p= new ChangeProfilDto();
	      /* Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	 String username = ((UserDetails)principal).getUsername();      

	      p.setLogin(username);
	     p.setId(user.getId());
	 
	     */
	  //   return "modifierProfil";
	      // return new ModelMap("user", p);
	  // }
	
	
	/*
	 * 
	 * 
	@PostMapping("/modifierProfil")
	public ResponseEntity<?> postEditUserForm(@Valid  @RequestBody SearchCriteria search, Errors errors) {
		  if(result.hasErrors())
		    { System.out.print("ffff11");
		   //  return "/modifierProfil";
		     
		    }
		  else {
		
		try {
			//If error, just return a 400 bad request, along with the error message
			   changeProfileSer.changePassword(profildto);
			  System.out.print("ffff");
	        }
			//userService.changePassword(form);
		 catch (Exception e) {
			 System.out.print("ffff2");
			   model.addAttribute("user",profildto);
               return   model.addAttribute("ErrorMeesage",e.getMessage());
                 
		} 
		//  return "modifierProfil";
		  }
		return model;
}	*/	
/*	@RequestMapping(value="/afficherMessage",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody ResponseEntity<?> getSearchResultViaAjax(
	           @RequestBody @Valid ChangeProfilDto profildto) {

		 ServiceResponse<String>result = new ServiceResponse<>();
		
	       //If error, just return a 400 bad request, along with the error message
	   /*     if (errors.hasErrors()) {

	            result.setMsg(errors.getAllErrors()
	                        .stream().map(x -> x.getDefaultMessage())
	                        .collect(Collectors.joining(",")));

	            return ResponseEntity.badRequest().body(result);
	            

	        }*/
	        //result.setMsg("3HHH");
	     /*  try {
	 	   changeProfileSer.changePassword(profildto);
	        }
	        catch (Exception e) {
	        	result.setMsg(e.getMessage());
				 System.out.print("ffff2");
	                 
			} 

	        return ResponseEntity.ok(result);

	    }*/
	
	
	
	
	
	
@RequestMapping(value = "/modifierProfil", method = RequestMethod.POST )
    public @ResponseBody ResponseEntity<?>  afficherMessage(@RequestBody  ChangeProfilDto user) {
		String msg=null;
		 ServiceResponse<String>result = new ServiceResponse<>();
		 try {
				// ChangeProfilDto ch=new ChangeProfilDto(email, pwdActuel, newPassword, confirmPassword)
					ChangeProfilDto ch=new ChangeProfilDto();
					ch.setEmail(user.getEmail());
					ch.setConfirmPassword(user.getConfirmPassword());
					ch.setNewPassword(user.getNewPassword());
					ch.setPwdActuel(user.getPwdActuel());
					System.out.print("hhhhi     "+ch.getPwdActuel());
					changeProfileSer.changePassword(user);
					ServiceResponse<String> result1 = new ServiceResponse<>("success","votre mot de passe esr changé avec succée" );
					
					//result.setStatus("success");;
					//result.setMsg("votre mot de passe esr changé avec succée");
					//result.setData("votre mot de passe esr changé avec succée");
					return new ResponseEntity<>("Hello World!", HttpStatus.OK);
				} catch (Throwable e) {
					result.setMsg(e.getMessage());
					System.out.println("bonjour5");
					return new ResponseEntity<>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
					
					
				}
		// ServiceResponse<Integer> response = new ServiceResponse<>("success", nbrSer.nbreDemandes());
			//return new ResponseEntity<>(HttpStatus.OK);
		// return ResponseEntity.ok(result);
				}
		  
/*	
	@RequestMapping(value = "/afficherMessage", method = RequestMethod.POST ,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody  String loadCityByCountry(@RequestBody ChangeProfilDto user,Errors errors) {
		System.out.print("hhhhi     "+user.getPwdActuel());
		
		if (errors.hasErrors()) {
		String error=	errors.getAllErrors()
            .stream().map(x -> x.getDefaultMessage())
            .collect(Collectors.joining(","));
           return error;

          //  return ResponseEntity.badRequest().body(result);
            

        }
		else {
		
		 try {
		// ChangeProfilDto ch=new ChangeProfilDto(email, pwdActuel, newPassword, confirmPassword)
			ChangeProfilDto ch=new ChangeProfilDto();
			ch.setEmail(user.getEmail());
			ch.setConfirmPassword(user.getConfirmPassword());
			ch.setNewPassword(user.getNewPassword());
			ch.setPwdActuel(user.getPwdActuel());
			System.out.print("hhhhi     "+ch.getPwdActuel());
			changeProfileSer.changePassword(user);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		System.out.print(e);
			return e.getMessage();
			
		}
		}
    return "";
	}
	
	
	*/
	/*@PostMapping("/modifierProfil")
	public String postEditUserForm(  @ModelAttribute("user")ChangeProfilDto user) {
		return "modifierProfil";
	}
	*/
	
	/*@RequestMapping(value="/afficherMessage",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody String getSearchResultViaAjax(
	           @RequestBody @Valid ChangeProfilDto profildto) {
				return "hello";

		// ServiceResponse<String>result = new ServiceResponse<>();
		
	       //If error, just return a 400 bad request, along with the error message
	  

	    }*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	@RequestMapping(value = "/modifierProfil", method = RequestMethod.POST ,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody  List<Ville> loadCityByCountry(@Valid @RequestBody ChangeProfilDto profildto , BindingResult errors ) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		   String username = ((UserDetails)principal).getUsername();  
		  User user= userRep.findByEmail(username);
		  String message=null;
if( profildto.getPwdActuel().equals(user.getPassword())) {
throw new Exception("Current Password Incorrect.");
message="Current Password Incorrect.";
}

else if ( profildto.getPwdActuel().equals(profildto.getNewPassword())) {
throw new Exception("New Password must be different than Current Password!");
message="New Password must be different than Current Password!.";
}

else if( !profildto.getNewPassword().equals(profildto.getConfirmPassword())) {
throw new Exception("New Password and Confirm Password does not match!");
message="New Password and Confirm Password does not match!";
}
else{
	changeProfileSer.changePassword(profildto);
	}
	
		
		Long id =gouverneartCritere.getGouverneratId();
    	//System.out.print("xcvbn             "+id);
   Gouvernerat g=new Gouvernerat();
    	g.setId(id);
    	  List<Ville> villes =VilleSer.getAllVilles(g);
    /*	 for(int i=0;i<villes.size();i++)
  	    {
  	    	System.out.print(villes.get(i).getId_ville());	
  	    }*/
    	//  List<Ville> villes=new ArrayList<Ville>();
    //	  return villes;
    //}
	
	
	
	/* @PostMapping("/modifierProfil")
	   public String enregistrer(@Valid @ModelAttribute("user") ChangeProfilDto profildto , BindingResult errors ) throws Exception {
		 System.out.print("hello");  */
	   
	/*    if(errors.hasErrors())
	    {
	     return "/modifierProfil";
	     
	    }*/
	  /*  User u=new User();
	   
	    u.setEmail(profildto.getLogin());
	    //MOD
	    String message=null;*/
		 
		 
	    //changeProfileSer.changePassword(profildto);
	    //     
	     
	    //   return "redirect:/modifierProfil";
	   }

	

	
	
