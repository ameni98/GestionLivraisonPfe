package net.javaguides.springboot.springsecurity.web;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.javaguides.springboot.springsecurity.service.NbreDemandeService;
@Controller
public class AdminController {
	//@Autowired
	//NbreDemandeService nbrSer;
	  @GetMapping(value="/admin")
	 public String admin() {
		//  m.addAttribute("nbreDemande",nbrSer.nbreDemandes());
		  
		  
	     return "admin";
	  }

}
