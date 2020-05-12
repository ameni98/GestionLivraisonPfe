package net.javaguides.springboot.springsecurity.web.dto;

public class AffectationRegisterDto {
private int id_affectCommande;
private String date_departColis;
private long idChauffeur;
private Long idVehicule;
private String idCommande;
public int getId_affectCommande() {
	return id_affectCommande;
}
public void setId_affectCommande(int id_affectCommande) {
	this.id_affectCommande = id_affectCommande;
}
public String getDate_departColis() {
	return date_departColis;
}
public void setDate_departColis(String date_departColis) {
	this.date_departColis = date_departColis;
}
public long getIdChauffeur() {
	return idChauffeur;
}
public void setIdChauffeur(long idChauffeur) {
	this.idChauffeur = idChauffeur;
}
public Long getIdVehicule() {
	return idVehicule;
}
public void setIdVehicule(Long idVehicule) {
	this.idVehicule = idVehicule;
}
public String getIdCommande() {
	return idCommande;
}
public void setIdCommande(String idCommande) {
	this.idCommande = idCommande;
}



}
