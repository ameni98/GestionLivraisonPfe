package net.javaguides.springboot.springsecurity.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.javaguides.springboot.springsecurity.model.Gouvernerat;

import net.javaguides.springboot.springsecurity.repository.RepositoryGover;

@Service


public class GouverneratService {
	@Autowired
	RepositoryGover repGouv;
	
	public List<Gouvernerat> getAllGouvernerat()
	{List<Gouvernerat>result =(List<Gouvernerat>) repGouv.findAll();
	if(result.size() > 0) {
        return result;
    } else {
        return new ArrayList<Gouvernerat>();
    }
	}
	
	
	/*public void ajouter()
	{
		Gouvernerat g1=new Gouvernerat();
		g1.setNom("mednine");
		Gouvernerat g2=new Gouvernerat();
		g2.setNom("gabes");
		Gouvernerat g3=new Gouvernerat();
		g3.setNom("tunis");
		List<Gouvernerat>lisGouv=new ArrayList<Gouvernerat>();
		lisGouv.add(g1);
		lisGouv.add(g2);
		lisGouv.add(g3);
		repGouv.saveAll(lisGouv);
		
	}*/
	


}
