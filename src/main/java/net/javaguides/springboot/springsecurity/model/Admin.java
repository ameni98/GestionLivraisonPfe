package net.javaguides.springboot.springsecurity.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "Admin")
@PrimaryKeyJoinColumn(name = "id")
public class Admin extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_admin", nullable = false)
	private Long id;
	/*private String nom;
	private String prenom;
	*/
	
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	/* @Autowired
	    private BCryptPasswordEncoder passwordEncoder;
	*/
   // private static final long serialVersionUID = 1L;
	public Admin() {
		super();}
	
	public Set<Vehicule> getVéhiculesAdmin() {
		return VéhiculesAdmin;
	}
	public void setVéhiculesAdmin(Set<Vehicule> véhiculesAdmin) {
		VéhiculesAdmin = véhiculesAdmin;
	}
	public Set<Chauffeur> getChauffeurAdmin() {
		return ChauffeurAdmin;
	}
	public void setChauffeurAdmin(Set<Chauffeur> chauffeurAdmin) {
		ChauffeurAdmin = chauffeurAdmin;
	}
//mapping admin vehicule
	@OneToMany(mappedBy="adminA")
  	private Set<Vehicule>VéhiculesAdmin =new HashSet<Vehicule>();
	//mapping admin chauffuer
    @OneToMany(mappedBy="adminA")
  	private Set<Chauffeur>ChauffeurAdmin =new HashSet<Chauffeur>();
    //mapping affectationcommande admin
    @OneToMany(mappedBy="adminA")
    private Set<AffectationCommande>affectAdmin=new HashSet<AffectationCommande>();
    
    
    
    
}