package net.javaguides.springboot.springsecurity.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "Admin")
@PrimaryKeyJoinColumn(name = "id")
//Cette annotation spécifie une colonne de clé primaire qui est utilisée comme clé étrangère pour se joindre à la table user
public class Admin extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_admin", nullable = false)
	private Long id;
	
	// mapping admin vehicule
	@OneToMany(mappedBy = "adminA")
	private Set<Vehicule> VéhiculesAdmin = new HashSet<Vehicule>();
	
	// mapping admin chauffuer
	@OneToMany(mappedBy = "adminA")
	private Set<Chauffeur> ChauffeurAdmin = new HashSet<Chauffeur>();
	
	// mapping affectationcommande admin
	@OneToMany(mappedBy = "adminA")
	private Set<AffectationCommande> affectAdmin = new HashSet<AffectationCommande>();

	
	/*  les getters et les setters  */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Vehicule> getVéhiculesAdmin() {
		return VéhiculesAdmin;
	}

	public void setVéhiculesAdmin(Set<Vehicule> véhiculesAdmin) {
		VéhiculesAdmin = véhiculesAdmin;
	}

	public Set<Chauffeur> getChauffeurAdmin() {
		return ChauffeurAdmin;
	}

	public void setChauffeurAdmin(Set<Chauffeur> chauffeurAdmin) {
		ChauffeurAdmin = chauffeurAdmin;
	}

	//constructeur
	public Admin() {
		super();
	}

}