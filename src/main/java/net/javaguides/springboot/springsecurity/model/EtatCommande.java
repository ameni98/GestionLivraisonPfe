package net.javaguides.springboot.springsecurity.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "etatCommande")
public class EtatCommande {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id_etat", nullable = false)
private int id;


public int getId() {
return id;
}


public void setId(int id) {
this.id = id;
}


public String getNom() {
return nom;
}


public void setNom(String nom) {
this.nom = nom;
}


@Column(name = "nom", length = 255, nullable = true)
private String nom;

@OneToMany(mappedBy = "pk.etatCommande",cascade = CascadeType.ALL)
private Set<AffectationCommandeEtat> affectComEtat = new HashSet<AffectationCommandeEtat>();
public Set<AffectationCommandeEtat> getAffectationCommandeEtats() {
       return this.affectComEtat;
}
public void setAffectationCommandeEtat(Set<AffectationCommandeEtat> a) {
       this.affectComEtat = a;
}

}
