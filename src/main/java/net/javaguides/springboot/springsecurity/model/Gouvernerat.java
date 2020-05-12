package net.javaguides.springboot.springsecurity.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity

//@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Gouvernerat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_gouvernerat", nullable = false)
	private Long id;

	
	@Column(name = "nom", length = 255, nullable = true)
	private String nom;
	@Column(name = "libelle", length = 255, nullable = true)
	private String libelle;
	
	//mapping gouvernerat ville
	 @JsonManagedReference
	@OneToMany(mappedBy="gouverneratG",fetch = FetchType.LAZY)
	private Set<Ville>VillesGouvernerat =new HashSet<Ville>();

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
		this.nom=nom;
	}
	
public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

public void addVilleGouvernerat(Ville v)
{

v.setGouverneratG(this);
VillesGouvernerat.add(v);

}

public Set<Ville> getVillesGouvernerat() {return VillesGouvernerat;}
}