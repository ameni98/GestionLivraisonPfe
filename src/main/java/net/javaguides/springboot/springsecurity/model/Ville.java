package net.javaguides.springboot.springsecurity.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
//@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Ville {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ville", nullable = false)
	private Long id_ville;
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "nom", length = 255, nullable = true)
	private String nom;
	//mappage gouvernerat ville
	@JsonIgnore
	// @JsonManagedReference
	@ManyToOne
	@JoinColumn(name="id_gouvernerat")	
	private Gouvernerat gouverneratG;


	
	public Long getId_ville() {
		return id_ville;
	}

	public void setId_ville(Long id_ville) {
		this.id_ville = id_ville;
	}

	public Gouvernerat getGouverneratG() {
		return gouverneratG;
	}

	public void setGouverneratG(Gouvernerat gouverneratG) {
		this.gouverneratG = gouverneratG;
	}
	@OneToMany(mappedBy = "pk.ville",cascade = CascadeType.ALL)
	private Set<VilleColis> villesColis = new HashSet<VilleColis>();
	public Set<VilleColis> getVilleColis() {
	        return this.villesColis;
	}
	public void setVilleColis(Set<VilleColis> r) {
	        this.villesColis = r;
	}
	
	
}
