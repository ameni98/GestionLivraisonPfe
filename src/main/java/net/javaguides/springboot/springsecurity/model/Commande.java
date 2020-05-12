package net.javaguides.springboot.springsecurity.model;

import java.util.Date;
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
	//mapping commande colis
@OneToMany(mappedBy="commandeC", cascade = CascadeType.ALL)
private Set<Colis>ColisCommande =new HashSet<Colis>();	

//mapping commande marchand
	@ManyToOne
	@JoinColumn(name="id_marchand")	
	private Marchand marchandM;


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
	public void addColisCommande(Colis c)
	{
		c.setCommandeC(this);
		ColisCommande.add(c);
	}
	public Set<Colis> getColisCommande() {return ColisCommande;	}
	

@OneToMany(mappedBy = "pk.commande",cascade = CascadeType.ALL)
private Set<AffectationCommandeEtat> affectComEtat = new HashSet<AffectationCommandeEtat>();
public Set<AffectationCommandeEtat> getAffectationCommandeEtats() {
       return this.affectComEtat;
}
public void setAffectationCommandeEtat(Set<AffectationCommandeEtat> a) {
       this.affectComEtat = a;
}

@OneToMany(mappedBy="CommandeC",fetch = FetchType.LAZY)
private Set<AffectationCommande>affectCommandes =new HashSet<AffectationCommande>();
	
	
	
	
	
}
