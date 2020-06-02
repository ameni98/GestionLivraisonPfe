package net.javaguides.springboot.springsecurity.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.javaguides.springboot.springsecurity.model.VilleDto;
import net.javaguides.springboot.springsecurity.repository.RepositoryVille;

@Service
public class VilleService {
	@Autowired
	RepositoryVille RepVille;
	
	public List<VilleDto> getAllVilles(Long id)
	{
		List<VilleDto>result =RepVille.findByGouverneratG(id);
return result;
	}

}
