package net.javaguides.springboot.springsecurity.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.springsecurity.model.Colis;
import net.javaguides.springboot.springsecurity.model.Commande;
import net.javaguides.springboot.springsecurity.repository.ColisRepositry;
import net.javaguides.springboot.springsecurity.repository.CommandeRepositry;

@Service
public class CommandeService {
	@Autowired
	CommandeRepositry   commandeRepositry;
	@Autowired
	ColisRepositry   colisRepositry;
	
	public Commande addCommande(Commande commande)
	{
		//commande.addColisCommande(c);
		return commandeRepositry.save(commande);
		
			
		
	}
	public Colis addColis(Colis c)
	{
	
		return colisRepositry.save(c);
			
		
	}
	/*public int nbreDemande() {
		int nbr=0;
		factory=HibernateUtils.getSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=null;
		try {
			transaction=session.beginTransaction();
			nbr=((Long) session.createQuery("select count(*) from commande where etat='En attente'").iterate().next()).intValue();
			transaction.commit();
			
		}
		catch(Exception e)
		{
			if (transaction!=null)
			{transaction.rollback();
			}
				System.out.println("ERROR:"+e.getMessage());
				
			}
			finally {
				session.close(); 	
			}
	 
		
		
		return  nbr;
		
	}*/
	
}
