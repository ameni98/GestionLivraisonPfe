package net.javaguides.springboot.springsecurity.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "commande")
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_commande", nullable = false)
	private int id;
	private String dateCom;
	
	private String date_Modif;
	
	
	// mapping commande colis
	@OneToMany(mappedBy = "commandeC", cascade = CascadeType.ALL)
	private Set<Colis> ColisCommande = new HashSet<Colis>();
   
	//mapping commande etatCommande
	@ManyToOne
	@JoinColumn(name = "id_etat")
	private EtatCommande etatCommandeE;
	
    // mapping commande marchand
	@ManyToOne
	@JoinColumn(name = "id_marchand")
	private Marchand marchandM;

	/*
	// mapping commande affectation commande etat
	@OneToMany(mappedBy = "pk.commande", cascade = CascadeType.ALL)
	private Set<AffectationCommandeEtat> affectComEtat = new HashSet<AffectationCommandeEtat>();
	*/
	
	// mapping commande affectation commande
	@OneToMany(mappedBy = "CommandeC", fetch = FetchType.LAZY)
	private Set<AffectationCommande> affectCommandes = new HashSet<AffectationCommande>();

	
	// getter et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDateCom() {
		return dateCom;
	}

	public void setDateCom(String dateCom) {
		this.dateCom = dateCom;
	}

	public Marchand getMarchandM() {
		return marchandM;
	}

	public void setMarchandM(Marchand marchandM) {
		this.marchandM = marchandM;
	}

	public void addColisCommande(Colis c) {
		c.setCommandeC(this);
		ColisCommande.add(c);
	}

	public Set<Colis> getColisCommande() {
		return ColisCommande;
	}

	public EtatCommande getEtatCommandeE() {
		return etatCommandeE;
	}

	public void setEtatCommandeE(EtatCommande etatCommandeE) {
		this.etatCommandeE = etatCommandeE;
	}

	public String getDate_Modif() {
		return date_Modif;
	}

	public void setDate_Modif(String date_Modif) {
		this.date_Modif = date_Modif;
	}
	

	/*public Set<AffectationCommandeEtat> getAffectationCommandeEtats() {
		return this.affectComEtat;
	}

	public void setAffectationCommandeEtat(Set<AffectationCommandeEtat> a) {
		this.affectComEtat = a;
	}*/
	

}
