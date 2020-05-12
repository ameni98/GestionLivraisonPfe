package net.javaguides.springboot.springsecurity.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
@Entity
public class Colis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_colis", nullable = false)
	private Long id_colis;
	
	//adresse de l'expediteur
	private  String adresse_marchand;
	private String code_Postale_marchand;
	
	//adresse de destinataire
	private  String adresse_client;
    private String code_Postale_client;
    private String type_destination;
	
	private String nom_client;
	private String prenom_client;
	private String rasison_sociale;
	
	private String numTel_client;
	
	//information sur les colis
	private String desc_Colis;
    private float poids;
    //getters et setters
	public String getRasison_sociale() {
		return rasison_sociale;
	}
	public void setRasison_sociale(String rasison_sociale) {
		this.rasison_sociale = rasison_sociale;
	}
    public String getNumTel_client() {
		return numTel_client;
	}
	public void setNumTel_client(String numTel_client) {
		this.numTel_client = numTel_client;
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
	public String getType_destination() {
		return type_destination;
	}
	public void setType_destination(String type_destination) {
		this.type_destination = type_destination;
	}
	private Date date_depart;
    //mapping commande colis
    @ManyToOne
	@JoinColumn(name="id_commande")	
	private Commande commandeC;
    
    
    
	public Commande getCommandeC() {
		return commandeC;
	}
	public void setCommandeC(Commande commandeC) {
		this.commandeC = commandeC;
	}
	public Long getId_colis() {
		return id_colis;
	}
	public void setId_colis(Long id_colis) {
		this.id_colis = id_colis;
	}
	public String getDesc_Colis() {
		return desc_Colis;
	}
	public void setDesc_Colis(String desc_Colis) {
		this.desc_Colis = desc_Colis;
	}
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
	public float getPoids() {
		return poids;
	}
	public void setPoids(float poids) {
		this.poids = poids;
	}
	public Date getDate_depart() {
		return date_depart;
	}
	public void setDate_depart(Date date_depart) {
		this.date_depart = date_depart;
	}
	@OneToMany(mappedBy = "pk.colis",cascade = CascadeType.ALL)
	private Set<VilleColis> villesColis = new HashSet<VilleColis>();
	public Set<VilleColis> getVilleColis() {
	        return this.villesColis;
	}
	public void setVilleColis(Set<VilleColis> r) {
	        this.villesColis = r;
	}
	
	
}
