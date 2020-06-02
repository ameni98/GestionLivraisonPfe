package net.javaguides.springboot.springsecurity.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "etatCommande")
public class EtatCommande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_etat", nullable = false)
	private int id;

	
	@Column(name = "nom", length = 255, nullable = true)
	private String nom;
	//mapping etatCommande commande
	@OneToMany(mappedBy = "etatCommandeE", cascade = CascadeType.ALL)
	private Set<Commande> CommandeEtatCommande = new HashSet<Commande>();
	
	/*
    // mapping etat commande et affectation etat commande
	@OneToMany(mappedBy = "pk.etatCommande", cascade = CascadeType.ALL)
	private Set<AffectationCommandeEtat> affectComEtat = new HashSet<AffectationCommandeEtat>();
	*/
	
     // getters et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<Commande> getCommandeEtatCommande() {
		return CommandeEtatCommande;
	}

	public void setCommandeEtatCommande(Set<Commande> commandeEtatCommande) {
		CommandeEtatCommande = commandeEtatCommande;
	}

	/*public Set<AffectationCommandeEtat> getAffectationCommandeEtats() {
		return this.affectComEtat;
	}

	public void setAffectationCommandeEtat(Set<AffectationCommandeEtat> a) {
		this.affectComEtat = a;
	}*/
	

}
