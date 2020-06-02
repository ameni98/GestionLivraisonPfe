package net.javaguides.springboot.springsecurity.web.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import net.javaguides.springboot.springsecurity.constraint.FieldMatch;

@FieldMatch.List({ @FieldMatch(first = "email", second = "confirmEmail", message = "The email fields must match")
		// @FieldMatch(second = "password", second = "confirmPassword", message = "The
		// password fields must match"),
})
public class MarchandRegistrationDto extends UserRegistrationDto {
	@Pattern(regexp = "[a-zA-Z]+|^$", message = "*Invalid nom")
	@NotEmpty(message = "*ce champ est obligatoire")
	private String nom;

	@NotEmpty(message = "*ce champ est obligatoire")
	private String adresse;
	@Pattern(regexp = "^[5,2,9][0-9]{7}|{0}", message = "*invalid numéro de téléphone")
	@NotEmpty(message = "*ce champ est obligatoire")
	private String NumTel;
	@Pattern(regexp = "[a-zA-Z]+|^$", message = "*Invalid prénom")
	@NotEmpty(message = "*ce champ est obligatoire")
	private String prenom;

	@AssertTrue(message="*veuiller cocher la case")
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

	public Boolean getTerms() {
		return terms;
	}

	public void setTerms(Boolean terms) {
		this.terms = terms;
	}

}