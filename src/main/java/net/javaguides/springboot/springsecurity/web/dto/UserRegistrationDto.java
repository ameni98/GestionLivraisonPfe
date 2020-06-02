package net.javaguides.springboot.springsecurity.web.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import net.javaguides.springboot.springsecurity.constraint.FieldMatch;

@FieldMatch.List({
        @FieldMatch(first = "password", second = "confirmPassword", message = "*confirmation de mot de passe invalide"),
       // @FieldMatch(first = "email", second = "confirmEmail", message = "The email fields must match")
})
public class UserRegistrationDto {

    @NotEmpty(message="*ce champ est obligatoire")
    private String password;

    @NotEmpty(message="*ce champ est obligatoire")
    private String confirmPassword;
   /* @NotEmpty
    private String nomUtilisateur;

    public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}*/

	@Email(message="*adresse email invalide")
    @NotEmpty(message="*ce champ est obligatoire")
    private String email;


    @AssertTrue
    private Boolean terms;

 

    public String getPassword() {
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
    }

}
