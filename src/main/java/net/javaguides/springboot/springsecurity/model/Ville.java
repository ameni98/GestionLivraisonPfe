package net.javaguides.springboot.springsecurity.model;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity

public class Ville implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ville", nullable = false)
	private Long id_ville;

	@Column(name = "nom", length = 255, nullable = true)
	private String nom;

	// mappage gouvernerat ville
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_gouvernerat")
	private Gouvernerat gouverneratG;

	// mapping ville villlecolis
	@OneToMany(mappedBy = "pk.ville", cascade = CascadeType.ALL)
	private Set<VilleColis> villesColis = new HashSet<VilleColis>();

	// getters et setters
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

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

	public Set<VilleColis> getVilleColis() {
		return this.villesColis;
	}

	public void setVilleColis(Set<VilleColis> r) {
		this.villesColis = r;
	}

}
