package net.javaguides.springboot.springsecurity.web;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import net.javaguides.springboot.springsecurity.model.Marchand;
import net.javaguides.springboot.springsecurity.model.User;
import net.javaguides.springboot.springsecurity.repository.MarchandRepository;
import net.javaguides.springboot.springsecurity.repository.UserRepository;
import net.javaguides.springboot.springsecurity.service.ChangeProfilMarchandService;
import net.javaguides.springboot.springsecurity.service.UserService;
import net.javaguides.springboot.springsecurity.web.dto.ChangeProfilMarchandDto;

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
	public ModelMap AfficherFormulaireModifierProfil(Model m) throws Exception {

		// trouver l'utilisateur connecté
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails) principal).getUsername();
		User user = userSer.findByEmail(username);

		// si user existe
		if (user != null) {
			long id = user.getId();
			Marchand marchand = (Marchand) userRep.findById(id);
			System.out.print(id);
			ChangeProfilMarchandDto form = new ChangeProfilMarchandDto();
			form.setEmail(username);
			form.setTel(marchand.getTel());
			form.setAdresse(marchand.getAdresse());
			m.addAttribute("marchand", form);
			return new ModelMap("marchand", form);
		}
		ChangeProfilMarchandDto form = new ChangeProfilMarchandDto();
		return new ModelMap("marchand", form);
	}

	@PostMapping("/modifierProfilMarchand")
	public String enregistrer(@Valid @ModelAttribute("marchand") ChangeProfilMarchandDto marchand, BindingResult errors,
			SessionStatus status, Model model, RedirectAttributes redirectAttrs) throws Exception {

		if (errors.hasErrors()) {
			return "modifierProfilMarchand";
		}
		// trouver l'utilisateur connecté
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails) principal).getUsername();
		User user = userSer.findByEmail(username);

		if (user != null) {
			long id = user.getId();

			Optional<Marchand> ma = marchRep.findById(id);
			Marchand m = ma.get();
			m.setId(id);
			m.setAdresse(marchand.getAdresse());
			m.setEmail(marchand.getEmail());
			m.setTel(marchand.getTel());

			userRep.save(m);
			return "redirect:/modifierProfilMarchand?success";
		}
		status.setComplete();
		return "redirect:/modifierProfilMarchand";

	}

}
