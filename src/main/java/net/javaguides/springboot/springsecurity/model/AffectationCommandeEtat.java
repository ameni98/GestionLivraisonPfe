package net.javaguides.springboot.springsecurity.model;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
 @AssociationOverrides({
     @AssociationOverride(name = "pk.commande",
         joinColumns = @JoinColumn(name = "id_commande")),
     @AssociationOverride(name = "pk.etatCommande",
         joinColumns = @JoinColumn(name = "id_etat")) })
@Table(name = "AffectationCommandeEtat")
public class AffectationCommandeEtat {
private AffectationCommandeEtatId pk = new AffectationCommandeEtatId();
@EmbeddedId
   public AffectationCommandeEtatId getPk() {
           return pk;
   }

   public void setPk(AffectationCommandeEtatId pk) {
           this.pk = pk;
   }

   @Column(name="date")
   private String date;
   public void setDate(String d) {date= d;}
   public String getDate() {return date;}
   


   @Transient
   public Commande getCommande() {
       return getPk().getCommande();
}

public void setCommande(Commande commande) {
       getPk().setCommande (commande);
}
@Transient
public EtatCommande getEtatCommande() {
       return getPk().getEtatCommande();
}



public void setEtatCommande(EtatCommande etatCommande) {
       getPk().setEtatCommande(etatCommande);
}

private AffectationCommande affectationCommandeC;
@ManyToOne
@JoinColumn(name="id_affectCommande")	
public AffectationCommande getAffectationCommandeC() {
	return affectationCommandeC;
}
@Transient
public void setAffectationCommandeC(AffectationCommande affectationCommandeC) {
	this.affectationCommandeC = affectationCommandeC;
}




}

