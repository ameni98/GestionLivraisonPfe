package net.javaguides.springboot.springsecurity.service;

import java.util.ArrayList;
import java.util.List;
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
	
}
