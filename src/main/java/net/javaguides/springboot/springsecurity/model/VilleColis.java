package net.javaguides.springboot.springsecurity.model;

import javax.persistence.*;

//classe d'association ville et ville colis
@Entity
@AssociationOverrides({ @AssociationOverride(name = "pk.ville", joinColumns = @JoinColumn(name = "id_ville")),
		@AssociationOverride(name = "pk.colis", joinColumns = @JoinColumn(name = "id_colis")) })

public class VilleColis {
	// c'est une clé primaire VilleColisId composé de deux clés etarngéres id ville et id
	// colis avec un attribut de description
	private VilleColisId pk = new VilleColisId();
	
	@Column(name = "description")
	private String description;

	// getters et setters
	@EmbeddedId
	public VilleColisId getPk() {
		return pk;
	}

	public void setPk(VilleColisId pk) {
		this.pk = pk;
	}

	public void setDescription(String d) {
		description = d;
	}

	public String getDescription() {
		return description;
	}

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
