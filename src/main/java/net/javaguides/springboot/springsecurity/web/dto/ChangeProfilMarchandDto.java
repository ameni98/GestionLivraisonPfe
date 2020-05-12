package net.javaguides.springboot.springsecurity.web.dto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ChangeProfilMarchandDto {

private Long id;
@Pattern( regexp="[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$" ,message ="*Invalid email")
@NotEmpty(message="*ce champ est obligatoire")
private String email;
@NotEmpty(message="*ce champ est obligatoire")
private String adresse;

@Pattern( regexp="^[5,2,9,7][0-9]{7}|{0}" ,message ="*Invalid numéro de téléphone")
@NotEmpty(message="*ce champ est obligatoire")
private String tel;


public String getEmail() {
return email;
}
public String getAdresse() {
return adresse;
}
public void setAdresse(String adresse) {
this.adresse = adresse;
}
public String getTel() {
return tel;
}
public void setTel(String tel) {
this.tel = tel;
}
public void setEmail(String email) {
this.email = email;
}

public ChangeProfilMarchandDto() { }
public ChangeProfilMarchandDto(Long id) {this.id = id;}
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
}


