package net.javaguides.springboot.springsecurity.web.dto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ChangeProfilDto {

private String email;
public String getEmail() {
return email;
}
public void setEmail(String email) {
this.email = email;
}

@NotBlank(message="Current Password must not be blank")
private String pwdActuel;
@NotBlank(message="New Password must not be blank")
private String newPassword;

@NotBlank(message="Confirm Password must not be blank")
private String confirmPassword;

public ChangeProfilDto() { }
public String getPwdActuel() {
return pwdActuel;
}
public void setPwdActuel(String pwdActuel) {
this.pwdActuel = pwdActuel;
}
public String getNewPassword() {
return newPassword;
}
public void setNewPassword(String newPassword) {
this.newPassword = newPassword;
}
public String getConfirmPassword() {
return confirmPassword;
}
public void setConfirmPassword(String confirmPassword) {
this.confirmPassword = confirmPassword;
}
public ChangeProfilDto(String email, String pwdActuel, String newPassword, String confirmPassword) {
	super();
	this.email = email;
	this.pwdActuel = pwdActuel;
	this.newPassword = newPassword;
	this.confirmPassword = confirmPassword;
}


}

