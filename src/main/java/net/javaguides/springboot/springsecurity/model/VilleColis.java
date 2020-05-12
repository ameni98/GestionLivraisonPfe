package net.javaguides.springboot.springsecurity.model;

import javax.persistence.*;

@Entity
@AssociationOverrides({
    @AssociationOverride(name = "pk.ville",
        joinColumns = @JoinColumn(name = "id_ville")),
    @AssociationOverride(name = "pk.colis",
        joinColumns = @JoinColumn(name = "id_colis")) })
public class VilleColis {
	
	 private VilleColisId pk = new VilleColisId();
	 @EmbeddedId
    public VilleColisId getPk() {
            return pk;
    }

    public void setPk(VilleColisId pk) {
            this.pk = pk;
    }

    @Column(name="description")
    private String description;
    public void setDescription(String d) {description= d;}
    public String getDescription() {return description;}
    
    @Transient
    public Ville getVille() {
        return getPk().getVille();
}

public void setVille(Ville ville) {
        getPk().setVille(ville);
}
@Transient
public Colis getColis() {
        return getPk().getColis();
}

public void setColis(Colis colis) {
        getPk().setColis(colis);
}
}
