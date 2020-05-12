package net.javaguides.springboot.springsecurity.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.springsecurity.exception.RecordNotFoundException;
import net.javaguides.springboot.springsecurity.model.Chauffeur;
import net.javaguides.springboot.springsecurity.model.Vehicule;
import net.javaguides.springboot.springsecurity.repository.AfficheChauRepository;
import net.javaguides.springboot.springsecurity.repository.ChauffeurRepository;
import net.javaguides.springboot.springsecurity.web.dto.ChauffeurRegistrationDto;

@Service
public class ChauffeurService {
@Autowired
private ChauffeurRepository chauffeurrepositry;



public Page<ChauffeurRegistrationDto> getAllChauffeur(Pageable pageable) {
	List<ChauffeurRegistrationDto>result=  chauffeurrepositry.affichageChauff();
	 //  int start = (int) pageable.getOffset();
	//int end = (start + pageable.getPageSize()) > result.size() ? result.size() : (start + pageable.getPageSize());
	//Page<ChauffeurRegistrationDto> page = new PageImpl<ChauffeurRegistrationDto>(result.subList(start, end), pageable, result.size());
Page<ChauffeurRegistrationDto> page = new PageImpl<ChauffeurRegistrationDto>(result,pageable,result.size());

return page;
		//new PageImpl<ChauffeurRegistrationDto>(result.subList(start, end), pageable, result.size());

/*
* repositrytodo.findAll().forEach(data::add); return data;
*/
}


/* public List<Long>  getAllIdchauffeur()
{ List<Long> ids =  (List<Long>) chauffeurrepositry.findAllIdChauffeur();

if (ids.size() > 0) {
return ids;
} else {
return new ArrayList<Long>();
}
}*/
public Chauffeur getChauffeurById(Long id) throws RecordNotFoundException {
Optional<Chauffeur> c = chauffeurrepositry.findById(id);

if (c.isPresent()) {
return c.get();
} else {
throw new RecordNotFoundException("il n'ya pas de chauffeur avec cet id");
}

}

public Optional<Chauffeur> findById(Long id) throws RecordNotFoundException {
return chauffeurrepositry.findById(id);
}

public void deleteChauffeur(Chauffeur v) // throws RecordNotFoundException
{
chauffeurrepositry.delete(v);

}

public void deleteChauffeurById(Long id) {
Optional<Chauffeur> vehicule = chauffeurrepositry.findById(id);

chauffeurrepositry.deleteById(id);
/*
* } else { throw new
* RecordNotFoundException("il n'ya pas de véhicule avec cet id"); }
*/
}

public Chauffeur addChauffeur(Chauffeur c) {
	//c'est pour faire l'ajout
if (c.getId() == null) {
	// System.out.print("hello"+c.getId());
c = chauffeurrepositry.save(c); //System.out.print("save");

return c;

} else {
	//c'est pour le cas de modification récupération des valeurs de l'objet chauffeur à partir de son id
Optional<Chauffeur> chauffeur = chauffeurrepositry.findById(c.getId());
Long id=c.getEtatDispo().getId();
System.out.print("azerty"+id);

if (chauffeur.isPresent()&&(c.getEtatDispo().getId()!=null)) {
Chauffeur newEntity = chauffeur.get();
newEntity.setNom((c.getNom()));
newEntity.setPrenom((c.getPrenom()));
newEntity.setDateNai(c.getDateNai());
newEntity.setEmail((c.getEmail()));
newEntity.setEtatDispo(c.getEtatDispo());
newEntity.setCin(c.getCin());
newEntity.setNumPermis(c.getNumPermis());
newEntity.setNumTel(c.getNumTel());
newEntity = chauffeurrepositry.save(newEntity);
System.out.print("update");

return newEntity;
} else {
c = chauffeurrepositry.save(c);
System.out.print("save1");


return c;
}

}

}
public  Page<Chauffeur> findByNom(String nom,Pageable pageable)
{
return chauffeurrepositry.findByNomContainingIgnoreCase(nom, pageable);
// véhiculerepositry.findByMatriculeContainingIgnoreCase(matricule, pageable);
}
public List<ChauffeurRegistrationDto>chauffDispo()
{return chauffeurrepositry.affichageChauffDispo();
	
}
}

