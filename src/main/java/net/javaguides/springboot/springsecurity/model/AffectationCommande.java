package net.javaguides.springboot.springsecurity.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AffectationCommande")
public class AffectationCommande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_affectCommande", nullable = false)
	private int id_affectCommande;

	@Column(name = "date_departColis")
	private String date_departColis;

    //mapping chauffeur affectationCommande
	@ManyToOne
	@JoinColumn(name = "id")
	private Chauffeur chauffeurC;
	
	private String date_affect;
	
	//mapping admin affectationCommande
	@ManyToOne
	@JoinColumn(name = "id_admin")
	private Admin adminA;
/*
	//mapping affectCommande et affectCommEtat
	@OneToMany(mappedBy = "affectationCommandeC")
	private Set<AffectationCommandeEtat> AffectComm = new HashSet<AffectationCommandeEtat>();
*/
	//mapping vehicule affectationCommande
	@ManyToOne
	@JoinColumn(name = "id_véhicule")
	private Vehicule VehiculeV;

	//mapping commande affectationCommande
	@ManyToOne
	@JoinColumn(name = "id_commande")
	private Commande CommandeC;

    //getters et setters
	public int getId_affectCommande() {
		return id_affectCommande;
	}

	public void setId_affectCommande(int id_affectCommande) {
		this.id_affectCommande = id_affectCommande;
	}

	public Chauffeur getChauffeurC() {
		return chauffeurC;
	}

	public void setChauffeurC(Chauffeur chauffeurC) {
		this.chauffeurC = chauffeurC;
	}

	public Vehicule getVehiculeV() {
		return VehiculeV;
	}

	public void setVehiculeV(Vehicule vehiculeV) {
		VehiculeV = vehiculeV;
	}

	public Commande getCommandeC() {
		return CommandeC;
	}

	public void setCommandeC(Commande commandeC) {
		CommandeC = commandeC;
	}

	public Admin getAdminA() {
		return adminA;
	}

	public void setAdminA(Admin adminA) {
		this.adminA = adminA;
	}

	/*@Transient
	public Set<AffectationCommandeEtat> getAffectComm() {
		return AffectComm;
	}
   */
	public String getDate_departColis() {
		return date_departColis;
	}

	public void setDate_departColis(String date_departColis) {
		this.date_departColis = date_departColis;
	}
	public String getDate_affect() {
		return date_affect;
	}

	public void setDate_affect(String date_affect) {
		this.date_affect = date_affect;
	}

}