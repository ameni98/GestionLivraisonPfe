package net.javaguides.springboot.springsecurity.web.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class VehiculeRegistrationDto {
	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Pattern( regexp="[0-9]{1,4} TU [0-9]{2,3}|{0}" ,message ="*ce champ doit etre sous la forme X TU Y")
	@NotEmpty(message="*ce champ est obligatoire")
	private String matricule;
	
	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getCapacite() {
		return capacite;
	}

	public void setCapacite(String capacite) {
		this.capacite = capacite;
	}

	@NotEmpty(message="*ce champ est obligatoire")
	private String marque;
	@NotEmpty(message="*ce champ est obligatoire")
	private String dispo;
	
	
	
	public String getDispo() {
		return dispo;
	}

	public void setDispo(String dispo) {
		this.dispo = dispo;
	}

	//@Pattern( regexp="	[-+]?[0-9]+(\\.[0-9]+)?([eE][-+]?[0-9]+)?")	
	@NotEmpty(message="*ce champ est obligatoire")
	private String capacite;
	
	


}
