package net.javaguides.springboot.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.javaguides.springboot.springsecurity.model.Colis;
import net.javaguides.springboot.springsecurity.repository.ColisRepositry;

@Service
public class ColisService {
	@Autowired
	ColisRepositry   colisRepositry;
	
	public Colis addColis(Colis colis)
	{
		return colisRepositry.save(colis);
			
	}
	
}