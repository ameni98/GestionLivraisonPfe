package net.javaguides.springboot.springsecurity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.springsecurity.model.Gouvernerat;
import net.javaguides.springboot.springsecurity.model.Ville;
import net.javaguides.springboot.springsecurity.repository.RepositoryVille;



@Service
public class VilleService {
	@Autowired
	RepositoryVille RepVille;
	
	public List<Ville> getAllVilles(Gouvernerat idGouverneart)
	{
		List<Ville>result =RepVille.findByGouverneratG(idGouverneart);
return result;
	}

}
