package net.javaguides.springboot.springsecurity.model;

import javax.persistence.*;

@Embeddable
public class VilleColisId implements java.io.Serializable{
	 /**
	 * 
	 */

	 private Ville ville;
	 private Colis colis;
	 
	 
	@ManyToOne(cascade = CascadeType.ALL)    
     public Colis getColis() {
             return colis;
     }

     public void setColis(Colis c) {
             this.colis = c;
     }
	
	@ManyToOne(cascade = CascadeType.ALL)  
     public Ville getVille() {
             return ville;
     }

     public void setVille(Ville v) {
             this.ville = v;
     }

    

}
