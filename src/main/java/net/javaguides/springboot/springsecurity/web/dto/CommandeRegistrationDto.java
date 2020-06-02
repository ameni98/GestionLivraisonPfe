package net.javaguides.springboot.springsecurity.web.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class CommandeRegistrationDto {
//ce qui concerner expediteur
	@NotEmpty(message = "*ce champ est obligatoire")
	private String adresse_marchand;
	// @NotEmpty(message="*ce champ est obligatoire")
	@Pattern(regexp = "[0-9]{4}|{0}", message = "Le code postale doit contenir 4 chiffres")

	private String code_Postale_marchand;
	@NotEmpty(message = "*ce champ est obligatoire")
	private String ville_marchand;
	@NotEmpty(message = "*ce champ est obligatoire")
	private String gouvernerat_marchand;

	// ce qui concerne destinataire
	@NotEmpty(message = "*ce champ est obligatoire")
	private String adresse_client;

	// @NotEmpty(message="*ce champ est obligatoire")
	@Pattern(regexp = "[0-9]{4}|{0}", message = "Le code postale doit contenir 4 chiffres")

	private String code_Postale_client;
	@NotEmpty(message = "*ce champ est obligatoire")
	private String ville_client;
	@NotEmpty(message = "*ce champ est obligatoire")
	private String gouvernerat_client;

	@NotEmpty(message = "*ce champ est obligatoire")
	private String type_destination;
	// @NotEmpty(message="*ce champ est obligatoire")
	private String nom_client;
	// @NotEmpty(message="*ce champ est obligatoire")
	private String prenom_client;
	// @NotEmpty(message="*ce champ est obligatoire")
	private String raison_sociale;
	@Pattern(regexp = "^[5,2,9,7][0-9]{7}|{0}", message = "*Invalid numéro de téléphone")
	@NotEmpty(message = "*ce champ est obligatoire")
	private String numTel_client;

	// ce qi concerne marchandise
	private String desc_Colis;
//@NotEmpty(message="*ce champ est obligatoire")
	private float poids;

	public String getAdresse_marchand() {
		return adresse_marchand;
	}

	public void setAdresse_marchand(String adresse_marchand) {
		this.adresse_marchand = adresse_marchand;
	}

	public String getCode_Postale_marchand() {
		return code_Postale_marchand;
	}

	public void setCode_Postale_marchand(String code_Postale_marchand) {
		this.code_Postale_marchand = code_Postale_marchand;
	}

	public String getVille_marchand() {
		return ville_marchand;
	}

	public void setVille_marchand(String ville_marchand) {
		this.ville_marchand = ville_marchand;
	}

	public String getGouvernerat_marchand() {
		return gouvernerat_marchand;
	}

	public void setGouvernerat_marchand(String gouvernerat_marchand) {
		this.gouvernerat_marchand = gouvernerat_marchand;
	}

	public String getAdresse_client() {
		return adresse_client;
	}

	public void setAdresse_client(String adresse_client) {
		this.adresse_client = adresse_client;
	}

	public String getCode_Postale_client() {
		return code_Postale_client;
	}

	public void setCode_Postale_client(String code_Postale_client) {
		this.code_Postale_client = code_Postale_client;
	}

	public String getVille_client() {
		return ville_client;
	}

	public void setVille_client(String ville_client) {
		this.ville_client = ville_client;
	}

	public String getGouvernerat_client() {
		return gouvernerat_client;
	}

	public void setGouvernerat_client(String gouvernerat_client) {
		this.gouvernerat_client = gouvernerat_client;
	}

	public String getType_destination() {
		return type_destination;
	}

	public void setType_destination(String type_destination) {
		this.type_destination = type_destination;
	}

	public String getNom_client() {
		return nom_client;
	}

	public void setNom_client(String nom_client) {
		this.nom_client = nom_client;
	}

	public String getPrenom_client() {
		return prenom_client;
	}

	public void setPrenom_client(String prenom_client) {
		this.prenom_client = prenom_client;
	}

	public String getRaison_sociale() {
		return raison_sociale;
	}

	public void setRaison_sociale(String raison_sociale) {
		this.raison_sociale = raison_sociale;
	}

	public String getNumTel_client() {
		return numTel_client;
	}

	public void setNumTel_client(String numTel_client) {
		this.numTel_client = numTel_client;
	}

	public String getDesc_Colis() {
		return desc_Colis;
	}

	public void setDesc_Colis(String desc_Colis) {
		this.desc_Colis = desc_Colis;
	}

	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}

}
