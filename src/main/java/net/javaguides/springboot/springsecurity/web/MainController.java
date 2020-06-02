package net.javaguides.springboot.springsecurity.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


  @GetMapping("/Accueil")
    public String root() {
        return "Accueil";
    }
  
 @GetMapping("/editProfil")
 public String editProfil() {
 	 return "editProfil";
 	 
  } 
   
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
 
    
}

