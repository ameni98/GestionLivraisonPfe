package net.javaguides.springboot.springsecurity.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "chauffeur")
@PrimaryKeyJoinColumn(name = "id")
public class Chauffeur extends User {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
	private Long id;
    @ManyToOne
	@JoinColumn(name="id_admin")	
	private Admin adminA;
    @Column(name = "nom")
    private String nom;
    @Column(name = "TypeDeplacement")
    private String TypeDeplacement;
    public String getTypeDeplacement() {
  		return TypeDeplacement;
  	}

  	public void setTypeDeplacement(String typeDeplacement) {
  		TypeDeplacement = typeDeplacement;
  	}

    public Long getId()
    {
    	return id;
    }
    
    public void setId(Long id)
    {
    	this.id=id;
    }
    public Admin getAdminA() {
		return adminA;
	}

	public void setAdminA(Admin adminA) {
		this.adminA = adminA;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateNai() {
		return DateNai;
	}

	public void setDateNai(String dateNai) {
		DateNai = dateNai;
	}
	@Column(name = "NumTel")
    private String NumTel;
	public String getNumTel() {
		return NumTel;
	}

	public void setNumTel(String numTel) {
		NumTel = numTel;
	}
	@Column(name = "prenom")
    private String prenom;
    public String getNumPermis() {
		return NumPermis;
	}

	public void setNumPermis(String numPermis) {
		NumPermis = numPermis;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}
	
    
    @Column(name = "DateNai")
    private String DateNai;
    @Column(name = "NumPermis")
    private String NumPermis;
    @Column(name = "cin")
    private String cin;
    //mapping chauffeur affectationCommande
    @OneToMany(mappedBy="chauffeurC")
    private Set<AffectationCommande>affectChauufeurs =new HashSet<AffectationCommande>();
    
    
   //mapping chauffeur et etatDispo
   
    
   // @OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    
  
    
    
   
	
	 @OneToOne (fetch = FetchType.LAZY)
	  private EtatDispo etatDispo;

	public EtatDispo getEtatDispo() {
		return etatDispo;
	}

	public void setEtatDispo(EtatDispo etatDispo) {
		this.etatDispo = etatDispo;
		
		
		
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chauffeur other = (Chauffeur) obj;
		if (DateNai == null) {
			if (other.DateNai != null)
				return false;
		} else if (!DateNai.equals(other.DateNai))
			return false;
		if (NumPermis == null) {
			if (other.NumPermis != null)
				return false;
		} else if (!NumPermis.equals(other.NumPermis))
			return false;
		if (NumTel == null) {
			if (other.NumTel != null)
				return false;
		} else if (!NumTel.equals(other.NumTel))
			return false;
		if (adminA == null) {
			if (other.adminA != null)
				return false;
		} else if (!adminA.equals(other.adminA))
			return false;
		if (affectChauufeurs == null) {
			if (other.affectChauufeurs != null)
				return false;
		} else if (!affectChauufeurs.equals(other.affectChauufeurs))
			return false;
		if (cin == null) {
			if (other.cin != null)
				return false;
		} else if (!cin.equals(other.cin))
			return false;
		if (etatDispo == null) {
			if (other.etatDispo != null)
				return false;
		} else if (!etatDispo.equals(other.etatDispo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}
	
	
	

    
}
