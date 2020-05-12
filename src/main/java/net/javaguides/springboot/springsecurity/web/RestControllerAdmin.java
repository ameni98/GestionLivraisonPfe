package net.javaguides.springboot.springsecurity.web;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.springsecurity.model.Response;
import net.javaguides.springboot.springsecurity.service.ChangeProfilService;
import net.javaguides.springboot.springsecurity.service.NbreDemandeService;
import net.javaguides.springboot.springsecurity.web.dto.ChangeProfilDto;

@RestController
public class RestControllerAdmin {
	@Autowired
	NbreDemandeService nbrSer;
	@Autowired 
	ChangeProfilService changeProfileSer;
	
	@GetMapping("/getNumber")
	public ResponseEntity<Object> getAllBooks() {
		ServiceResponse<Integer> response = new ServiceResponse<>("success", nbrSer.nbreDemandes());
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	
	}
/*	@RequestMapping(value="/modifierProfil",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE )
	public  @ResponseBody ResponseEntity<?> getSearchResultViaAjax(
	           @RequestBody @Valid ChangeProfilDto profildto, Errors errors) {

		 ServiceResponse<String>result = new ServiceResponse<>();
		
	       //If error, just return a 400 bad request, along with the error message
	        if (errors.hasErrors()) {

	            result.setMsg(errors.getAllErrors()
	                        .stream().map(x -> x.getDefaultMessage())
	                        .collect(Collectors.joining(",")));

	            return ResponseEntity.badRequest().body(result);

	        }
	        //result.setMsg("3HHH");
	       try {
	 	   changeProfileSer.changePassword(profildto);
	        }
	        catch (Exception e) {
	        	result.setMsg(e.getMessage());
				 System.out.print("ffff2");
	                 
			} 

	        return ResponseEntity.ok(result);

	    }*/
	/*@PostMapping(value = "/modifierProfil",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	  public Response postCustomer(@ModelAttribute("user") ChangeProfilDto profildto ) throws Exception {
		// changeProfileSer.changePassword(profildto);
	    
	    // Create Response Object
	    Response response = new Response("Done",  changeProfileSer.changePassword(profildto));
	    return response;
	  }
	
	*/
	/*@RequestMapping(value="/modifierProfil",method = RequestMethod.POST)
	public String getSearchResultViaAjax1() {
return "/modifierProfil";*/

	    
	
	

}
