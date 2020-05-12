package net.javaguides.springboot.springsecurity.web.dto;

import javax.validation.constraints.AssertTrue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import net.javaguides.springboot.springsecurity.constraint.FieldMatch;


@FieldMatch.List({
    @FieldMatch(first = "email", second = "confirmEmail", message = "The email fields must match")
 //   @FieldMatch(second = "password", second = "confirmPassword", message = "The password fields must match"),
})
public class MarchandRegistrationDto extends UserRegistrationDto{
@NotEmpty
private String nom;



@NotEmpty
private String adresse;
@Pattern( regexp="^[5,2,9][0-9]{7}" ,message ="invalid numéro de téléphone")
@NotEmpty
private String NumTel;
@NotEmpty
private String prenom;

@AssertTrue
private Boolean terms;


public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}


public String getAdresse() {
	return adresse;
}

public void setAdresse(String adresse) {
	this.adresse = adresse;
}

public String getNumTel() {
	return NumTel;
}

public void setNumTel(String numTel) {
	NumTel = numTel;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

/*public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getConfirmPassword() {
	return confirmPassword;
}

public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Boolean getTerms() {
	return terms;
}

public void setTerms(Boolean terms) {
	this.terms = terms;
}*/

}