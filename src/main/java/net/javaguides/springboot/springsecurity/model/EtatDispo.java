package net.javaguides.springboot.springsecurity.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//classe pour la disponiblité de chauffeur
@Entity
@Table(name = "EtatDispo")
public class EtatDispo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_EtatDispo")
	private Long id;

	@Column(name = "nom")
	private String nom;

	@Column(name = "DateDeb")
	private String DateDeb;

	@Column(name = "DateFin")
	private String DateFin;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "etatDispo", cascade = CascadeType.ALL)
	private Chauffeur chauff;

	// getters et setters
	public Chauffeur getChauff() {
		return chauff;
	}

	public void setChauff(Chauffeur chauff) {
		this.chauff = chauff;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDateDeb() {
		return DateDeb;
	}

	public void setDateDeb(String dateDeb) {
		DateDeb = dateDeb;
	}

	public String getDateFin() {
		return DateFin;
	}

	public void setDateFin(String dateFin) {
		DateFin = dateFin;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EtatDispo other = (EtatDispo) obj;
		if (DateDeb == null) {
			if (other.DateDeb != null)
				return false;
		} else if (!DateDeb.equals(other.DateDeb))
			return false;
		if (DateFin == null) {
			if (other.DateFin != null)
				return false;
		} else if (!DateFin.equals(other.DateFin))
			return false;
		if (chauff == null) {
			if (other.chauff != null)
				return false;
		} else if (!chauff.equals(other.chauff))
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
		return true;
	}

}
