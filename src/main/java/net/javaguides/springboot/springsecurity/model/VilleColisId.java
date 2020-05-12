package net.javaguides.springboot.springsecurity.model;

import javax.persistence.*;

@Embeddable
public class VilleColisId implements java.io.Serializable{
	 /**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
	private Ville ville;
	 private Colis colis;
	@ManyToOne(cascade = CascadeType.ALL)
  //   @JoinColumn(name = "id_colis")
    
     public Colis getColis() {
             return colis;
     }

     public void setColis(Colis c) {
             this.colis = c;
     }
	
	@ManyToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "id_ville")
     
     public Ville getVille() {
             return ville;
     }

     public void setVille(Ville v) {
             this.ville = v;
     }

    

}
