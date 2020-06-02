package net.javaguides.springboot.springsecurity.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Marchand")
@PrimaryKeyJoinColumn(name = "id")
//Cette annotation spécifie une colonne de clé primaire qui est utilisée comme clé étrangère pour se joindre à la table user

public class Marchand extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_marchand", nullable = false)
	private Long id;

	@Column(name = "adresse")
	private String adresse;

	// mapping cmmande marchand
	@OneToMany(mappedBy = "marchandM")
	private Set<Commande> CommandesMarchand = new HashSet<Commande>();

	@Column(name = "nom")
	private String nom;

	@Column(name = "Prenom")
	private String Prenom;

	@Column(name = "tel")
	private String tel;

	// getters et setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}