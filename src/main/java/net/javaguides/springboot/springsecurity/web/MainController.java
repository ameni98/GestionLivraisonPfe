package net.javaguides.springboot.springsecurity.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {


  @GetMapping("/Accueil")
    public String root() {
        return "Accueil";
    }
  /*@GetMapping("/admin")
  public String admin() {
      return "admin";
  }*/
 /*@GetMapping("/suiviColis")
public String suivi() {
	 return "suiviColis";
	 
 } */
 @GetMapping("/editProfil")
 public String editProfil() {
 	 return "editProfil";
 	 
  } 
   /*@GetMapping("/commande")
    public String commade(Model model) {
        return "commande";
    }*/
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
 /*   @GetMapping("/list")
    public String dem(Model model) {
        return "list";
    }
*/
  /*  @GetMapping("/commande")
    public String cm(Model model) {
        return "commande";
    }
*/
    
  /*  @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }
   
    @GetMapping("/")
    public String root() {
        return "index";
    }*/
   
   /* @PostMapping("/login")
    public String index(Model model) {
        return "/index";
    }*/
  /*  
   @GetMapping("/index")
    public String userIndex() {
        return "index";
    }    
    */
  /*  @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }*/
/* @GetMapping("/commande")
    public String demande() {
        return "commande";
    }*/
    
}

