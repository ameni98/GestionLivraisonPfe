package net.javaguides.springboot.springsecurity.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.springsecurity.exception.RecordNotFoundException;
import net.javaguides.springboot.springsecurity.model.Vehicule;
import net.javaguides.springboot.springsecurity.repository.VéhiculeRepository;

@Service
public class VéhiculeService {
@Autowired
private VéhiculeRepository véhiculerepositry;

public Page<Vehicule> getAllVéhicule(Pageable pageable)
{Page<Vehicule>result =véhiculerepositry.findAll(pageable);
if(result.getSize() > 0) {
        return result;}
    /*} else {
    	//Page<Vehicule>res=new Page<Vehicule>();
        return  Page<Vehicule>();
    }*/
/* repositrytodo.findAll().forEach(data::add);
return data;*/
return result;
}


public Vehicule getVéhiculeById(Long id)throws RecordNotFoundException
{Optional<Vehicule> v=véhiculerepositry.findById(id);

 if(v.isPresent()) {
          return v.get();
      } else {
          throw new RecordNotFoundException("il n'ya pas de véhicule avec cet id");
      }


}
public Optional<Vehicule> findById(Long id) throws RecordNotFoundException
   {
      return véhiculerepositry.findById(id);
   }
   


public void deleteVehicule(Vehicule v) //throws RecordNotFoundException
   {
véhiculerepositry.delete(v);

   }
   
public void deleteVéhiculeById(Long id) {
       Optional<Vehicule> vehicule = véhiculerepositry.findById(id);
       
 
        véhiculerepositry.deleteById(id);
      /* } else {
           throw new RecordNotFoundException("il n'ya pas de véhicule avec cet id");
       }*/
   }
public Vehicule addVéhicule(Vehicule v)
{
if(v.getId()  == null)
       {
           v = véhiculerepositry.save(v);
          
           
           return v;
       }
       else
       {
           Optional<Vehicule> vehicule = véhiculerepositry.findById(v.getId());
           
           if(vehicule.isPresent())
           {
            Vehicule newEntity = vehicule.get();
            newEntity.setMarque(v.getMarque());
            newEntity.setMatricule(v.getMatricule());
            newEntity.setCapacite(v.getCapacite());
          //  newEntity.setModele(v.getModele());
            newEntity.setDispo(v.getDispo());
             
               newEntity = véhiculerepositry.save(newEntity);
            
               
               return newEntity;
           } else {
               v = véhiculerepositry.save(v);
              
               return v;
           }
       }



//return véhiculerepositry.save(v);

}
public void update(int id,Vehicule v)
{
Optional<Vehicule> vehicule = véhiculerepositry.findById(v.getId());
           
/*  if(véhicule.isPresent())
           {
               Véhicule v1 = véhicule.get();
               véhicule.setEmail(véhicule.getEmail());
               véhicule.setFirstName(véhicule.getFirstName());
               véhicule.setLastName(véhicule.getLastName());

               newEntity = repository.save(newEntity);
               
               return newEntity;
           } else {
               entity = repository.save(entity);
               
               return entity;
           }
*/

véhiculerepositry.save(v);

}
public  Page<Vehicule> findByMatricule(String matricule,Pageable pageable)
{
return véhiculerepositry.findByMatriculeContainingIgnoreCase(matricule, pageable);
// véhiculerepositry.findByMatriculeContainingIgnoreCase(matricule, pageable);
}

public List<Vehicule> getVehiculeDispo()
{
	return véhiculerepositry.vehiculeDispo();
}

}

