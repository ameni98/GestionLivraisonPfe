package net.javaguides.springboot.springsecurity.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import net.javaguides.springboot.springsecurity.model.Vehicule;
import net.javaguides.springboot.springsecurity.repository.VéhiculeRepository;

@Service
public class VéhiculeService {
	@Autowired
	private VéhiculeRepository véhiculerepositry;

	// afficher tous les véhicules
	public Page<Vehicule> getAllVéhicule(Pageable pageable) {
		Page<Vehicule> result = véhiculerepositry.findAll(pageable);
		if (result.getSize() > 0) {
			return result;
		}
		return result;
	}

	public void deleteVehicule(Vehicule v) {
		véhiculerepositry.delete(v);

	}

	public Vehicule addVéhicule(Vehicule v) {
		// si l'id de vhicule est null allors on fait l'ajout
		if (v.getId() == null) {
			v = véhiculerepositry.save(v);

			return v;
		} // sinon on fait la modification
		else {
			Optional<Vehicule> vehicule = véhiculerepositry.findById(v.getId());

			if (vehicule.isPresent()) {
				Vehicule newEntity = vehicule.get();
				newEntity.setMarque(v.getMarque());
				newEntity.setMatricule(v.getMatricule());
				newEntity.setCapacite(v.getCapacite());
				newEntity.setDispo(v.getDispo());
				newEntity = véhiculerepositry.save(newEntity);
				return newEntity;
			} else {
				v = véhiculerepositry.save(v);
				return v;
			}
		}

	}

	// faire une recherche par matricule
	public Page<Vehicule> findByMatricule(String matricule, Pageable pageable) {
		return véhiculerepositry.findByMatriculeContainingIgnoreCase(matricule, pageable);
	}

	// afficher les véhicules disponibles
	public List<Vehicule> getVehiculeDispo() {
		return véhiculerepositry.vehiculeDispo();
	}
	
	public int nbreTotalV() {
		int nbre=0;
		nbre=véhiculerepositry.findNumberVehi();
		return nbre;
	}


}
