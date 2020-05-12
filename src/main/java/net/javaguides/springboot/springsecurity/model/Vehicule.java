package net.javaguides.springboot.springsecurity.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Véhicule")
public class Vehicule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vehicule", nullable = false)
	private Long id;
	@Column(name = "marque")
	private String marque;
	
	@Column(name = "dispo")
	private String dispo;
	

	public String getDispo() {
		return dispo;
	}

	public void setDispo(String dispo) {
		this.dispo = dispo;
	}


	@Override
	public String toString() {
		return "Véhicule [id=" + id + ", marque=" + marque + ", capacite=" + capacite
				+ ", matricule=" + matricule + "]";
	}

	@Column(name = "capacité")
	private float capacite;

	@ManyToOne
	@JoinColumn(name = "id_admin")
	private Admin adminA;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public float getCapacite() {
		return capacite;
	}

	public void setCapacite(float capacite) {
		this.capacite = capacite;
	}

	@Column(name = "matricule")
	private String matricule;

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Admin getAdminA() {
		return adminA;
	}

	public void setAdminA(Admin adminA) {
		this.adminA = adminA;
	}
	//mapping vehicule affectationcommande 
	@OneToMany(mappedBy="VehiculeV")
	private Set<AffectationCommande>affectVehicule =new HashSet<AffectationCommande>();

}
