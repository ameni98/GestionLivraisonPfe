package net.javaguides.springboot.springsecurity.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.security.core.userdetails.UserDetails;
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

	public String tampilkanForm(Model m) throws Exception {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String username = ((UserDetails) principal).getUsername();

		ChangeProfilDto form = new ChangeProfilDto();
		form.setEmail(username);
		m.addAttribute("user", form);
		return "modifierProfil";

	}
	@GetMapping("/modifierProfilChauff")

	public String modifierProfChauff(Model m) throws Exception {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String username = ((UserDetails) principal).getUsername();

		ChangeProfilDto form = new ChangeProfilDto();
		form.setEmail(username);
		m.addAttribute("user", form);
		return "modifierProfilChauffeur";

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@RequestMapping(value = "/modifierProfil", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> afficherMessage(@RequestBody ChangeProfilDto user) {
		ServiceResponse<String> result = new ServiceResponse<>();
		try {
			ChangeProfilDto ch = new ChangeProfilDto();
			ch.setEmail(user.getEmail());
			ch.setConfirmPassword(user.getConfirmPassword());
			ch.setNewPassword(user.getNewPassword());
			ch.setPwdActuel(user.getPwdActuel());
			ServiceResponse<String> result1 = new ServiceResponse<>("success","votre mot de passe est changé avec succée" );

			//result.setStatus("success");;
			//result.setMsg("votre mot de passe esr changé avec succée");
			//result.setData("votre mot de passe esr changé avec succée");
			changeProfileSer.changePassword(user);

			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Throwable e) {
			result.setMsg(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);

		}
	}
}
