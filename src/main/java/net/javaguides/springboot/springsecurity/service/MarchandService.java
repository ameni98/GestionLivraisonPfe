package net.javaguides.springboot.springsecurity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.springsecurity.model.Marchand;
import net.javaguides.springboot.springsecurity.repository.MarchandRepository;

@Service
public class MarchandService {
	@Autowired
	MarchandRepository MarchandRep;

	public List<Marchand> getAllMarchand() {
		List<Marchand> result = (List<Marchand>) MarchandRep.findAll();
		if (result.size() > 0) {
			return result;
		} else {
			return new ArrayList<Marchand>();
		}
		
	}
	
	
	
	public int nbreMarchands()
	{
	int nbre=0;
	nbre=MarchandRep.findNumberMarch();
	return nbre;
	}


	}


