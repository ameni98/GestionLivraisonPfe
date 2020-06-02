package net.javaguides.springboot.springsecurity.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import net.javaguides.springboot.springsecurity.service.ChangeProfilService;
import net.javaguides.springboot.springsecurity.service.NbreDemandeService;


@RestController
public class RestControllerAdmin {
	@Autowired
	NbreDemandeService nbrSer;
	@Autowired 
	ChangeProfilService changeProfileSer;
	
	@GetMapping("/getNumber")
	public ResponseEntity<Object> getCountCommnde() {
		ServiceResponse<Integer> response = new ServiceResponse<>("success", nbrSer.nbreDemandes());
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	
	}


}
