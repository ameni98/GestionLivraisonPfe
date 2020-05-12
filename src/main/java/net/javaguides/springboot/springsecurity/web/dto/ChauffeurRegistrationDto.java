package net.javaguides.springboot.springsecurity.web.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.beans.factory.annotation.Value;

import lombok.Builder.Default;
import lombok.NonNull;

public class ChauffeurRegistrationDto {
	private Long idEtat;
	
	public Long getIdEtat() {
		return idEtat;
	}

	public void setIdEtat(Long idEtat) {
		this.idEtat = idEtat;
	}
	private String TypeDeplacement;

	public String getTypeDeplacement() {
		return TypeDeplacement;
	}

	public void setTypeDeplacement(String typeDeplacement) {
		TypeDeplacement = typeDeplacement;
	}
	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

@NotEmpty(message="*ce champ est obligatoire")
	private String nom;
@NotEmpty(message="*ce champ est obligatoire")
	private String prenom;
	@NotEmpty(message="*ce champ est obligatoire")
	private String dateNai;
	@Pattern( regexp="^[5,2,9][0-9]{7}|{0}" ,message ="*invalid numéro de téléphone")
	@NotEmpty(message="*ce champ est obligatoire")

	private String NumTel;
	@NotEmpty(message="*ce champ est obligatoire")
	@Pattern( regexp="[0-9]{2}/[0-9]{6}|{0}" ,message ="*invalid numéro de permis")
	private String NumPermi;
	@Pattern( regexp="[0-9]{8}|{0}" ,message ="*Le numéro cin doit contenir 8 chiffres")
	@NotEmpty(message="*ce champ est obligatoire")
	private String NumCin;
	@NotEmpty(message="*ce champ est obligatoire")

	private String login;
	
	@NotEmpty(message="*ce champ est obligatoire")

	private String MotPasse;
	//@NotEmpty(message="*ce champ est obligatoire")
  //  @Value("disponible")
	private String etatDispo;
	
	private String dateDeb;
	private String dateFin;

	public String getEtatDispo() {
		return etatDispo;
	}

	public void setEtatDispo(String etatDispo) {
		this.etatDispo = etatDispo;
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
		return dateNai;
	}

	public void setDateNai(String dateNai) {
		this.dateNai = dateNai;
	}

	public String getNumTel() {
		return NumTel;
	}

	public void setNumTel(String numTel) {
		NumTel = numTel;
	}

	public String getNumPermi() {
		return NumPermi;
	}

	public void setNumPermi(String numPermi) {
		NumPermi = numPermi;
	}

	public String getNumCin() {
		return NumCin;
	}

	public void setNumCin(String numCin) {
		NumCin = numCin;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotPasse() {
		return MotPasse;
	}

	public void setMotPasse(String motPasse) {
		MotPasse = motPasse;
	}

	public String getDateDeb() {
		return dateDeb;
	}

	public void setDateDeb(String dateDeb) {
		this.dateDeb = dateDeb;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	public ChauffeurRegistrationDto(Long id, String nom, String prenom, String dateNai,String numTel,String numPermi, String numCin,
			String etatDispo, String dateDeb, String dateFin,String login,String MotPasse, Long idEtat) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNai = dateNai;
	this.	NumTel = numTel;
	this.	NumPermi = numPermi;
		this.NumCin = numCin;
	
		this.etatDispo = etatDispo;
		this.dateDeb = dateDeb;
		this.dateFin = dateFin;
		this.login=login;
		this.MotPasse=MotPasse;
		this.idEtat=idEtat;
	}
	
	public ChauffeurRegistrationDto(Long id, String nom, String prenom,String etatDispo, Long idEtat) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.etatDispo = etatDispo;	
		this.idEtat=idEtat;
	}
	
	
	
	
	public ChauffeurRegistrationDto()
	{
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((MotPasse == null) ? 0 : MotPasse.hashCode());
		result = prime * result + ((NumCin == null) ? 0 : NumCin.hashCode());
		result = prime * result + ((NumPermi == null) ? 0 : NumPermi.hashCode());
		result = prime * result + ((NumTel == null) ? 0 : NumTel.hashCode());
		result = prime * result + ((dateDeb == null) ? 0 : dateDeb.hashCode());
		result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
		result = prime * result + ((dateNai == null) ? 0 : dateNai.hashCode());
		result = prime * result + ((etatDispo == null) ? 0 : etatDispo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChauffeurRegistrationDto other = (ChauffeurRegistrationDto) obj;
		if (MotPasse == null) {
			if (other.MotPasse != null)
				return false;
		} else if (!MotPasse.equals(other.MotPasse))
			return false;
		if (NumCin == null) {
			if (other.NumCin != null)
				return false;
		} else if (!NumCin.equals(other.NumCin))
			return false;
		if (NumPermi == null) {
			if (other.NumPermi != null)
				return false;
		} else if (!NumPermi.equals(other.NumPermi))
			return false;
		if (NumTel == null) {
			if (other.NumTel != null)
				return false;
		} else if (!NumTel.equals(other.NumTel))
			return false;
		if (dateDeb == null) {
			if (other.dateDeb != null)
				return false;
		} else if (!dateDeb.equals(other.dateDeb))
			return false;
		if (dateFin == null) {
			if (other.dateFin != null)
				return false;
		} else if (!dateFin.equals(other.dateFin))
			return false;
		if (dateNai == null) {
			if (other.dateNai != null)
				return false;
		} else if (!dateNai.equals(other.dateNai))
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
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
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
