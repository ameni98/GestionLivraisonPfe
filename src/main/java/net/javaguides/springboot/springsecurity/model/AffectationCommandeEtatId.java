package net.javaguides.springboot.springsecurity.model;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class AffectationCommandeEtatId implements java.io.Serializable{
/**
*
*/
// private static final long serialVersionUID = 1L;
private EtatCommande etatCommande;
private Commande commande;
@ManyToOne(cascade = CascadeType.ALL)

public EtatCommande getEtatCommande() {
return etatCommande;
}
public void setEtatCommande(EtatCommande etatCommande) {
this.etatCommande = etatCommande;
}
@ManyToOne(cascade = CascadeType.ALL)
public Commande getCommande() {
return commande;
}
public void setCommande(Commande commande) {
this.commande = commande;
}

   }

