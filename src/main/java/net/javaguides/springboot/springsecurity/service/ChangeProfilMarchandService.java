package net.javaguides.springboot.springsecurity.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.springsecurity.model.Marchand;
import net.javaguides.springboot.springsecurity.repository.MarchandRepository;
@Service
public class ChangeProfilMarchandService {
@Autowired
private static  MarchandRepository marchandRepository;



public Marchand addMarchand(Marchand m) {


	return marchandRepository.save(m);

}



}
