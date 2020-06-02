package net.javaguides.springboot.springsecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.springsecurity.model.Chauffeur;
import net.javaguides.springboot.springsecurity.model.Marchand;
import net.javaguides.springboot.springsecurity.web.dto.DemandeJoinDto;
@Repository
public interface DemandeJoinRepository  extends JpaRepository<Marchand, Long>{
	
	
	
	
@Query(value=" SELECT new net.javaguides.springboot.springsecurity.web.dto.DemandeJoinDto( com.dateCom,c.adresse_marchand,c.adresse_client,c.code_Postale_marchand,c.code_Postale_client,c.desc_Colis,c.nom_client,c.prenom_client,c.rasison_sociale,c.numTel_client,c.poids, m.nom, m.Prenom,m.tel,v.nom,g.nom,v.nom,g.nom,EC.nom,com.id) "
			+ "FROM	Colis c,Commande com,Marchand m ,Ville v,Gouvernerat g,VilleColis vc,EtatCommande EC WHERE (m.id=com.marchandM) AND (com.id=c.commandeC)AND (vc.pk.colis=c.id_colis)AND (vc.pk.ville=v.id_ville) AND (v.gouverneratG=g.id)AND (com.etatCommandeE=EC.id)and (com.etatCommandeE=1)"
			+ "AND (vc.description='Adresse de destination')")
				List<DemandeJoinDto> AffichageDemandeDestination();
	
@Query(value=" SELECT new net.javaguides.springboot.springsecurity.web.dto.DemandeJoinDto( com.dateCom,c.adresse_marchand,c.adresse_client,c.code_Postale_marchand,c.code_Postale_client,c.desc_Colis,c.nom_client,c.prenom_client,c.rasison_sociale,c.numTel_client,c.poids, m.nom, m.Prenom,m.tel,v.nom,g.nom,v.nom,g.nom,EC.nom,com.id) "
		+ "FROM	Colis c,Commande com,Marchand m ,Ville v,Gouvernerat g,VilleColis vc,EtatCommande EC WHERE (m.id=com.marchandM) AND (com.id=c.commandeC)AND (vc.pk.colis=c.id_colis)AND (vc.pk.ville=v.id_ville) AND (v.gouverneratG=g.id)AND (com.etatCommandeE=EC.id)and (com.etatCommandeE=1)"
		+ "AND (vc.description='Adresse d''expedition')")
List<DemandeJoinDto> AffichageDemandeExpedition();

@Query(value=" SELECT new net.javaguides.springboot.springsecurity.web.dto.DemandeJoinDto( com.dateCom,c.adresse_marchand,c.adresse_client,c.code_Postale_marchand,c.code_Postale_client,c.desc_Colis,c.nom_client,c.prenom_client,c.rasison_sociale,c.numTel_client,c.poids, m.nom, m.Prenom,m.tel,v.nom,g.nom,v.nom,g.nom,EC.nom,com.id) "
		+ "FROM	Colis c,Commande com,Marchand m ,Ville v,Gouvernerat g,VilleColis vc,EtatCommande EC WHERE (m.id=com.marchandM) AND (com.id=c.commandeC)AND (vc.pk.colis=c.id_colis)AND (vc.pk.ville=v.id_ville) AND (v.gouverneratG=g.id)AND (com.etatCommandeE=EC.id)and (com.etatCommandeE!=1)"
		+ "AND (vc.description='Adresse de destination')")
			List<DemandeJoinDto> AffichageDemandeDestinationTous();

@Query(value=" SELECT new net.javaguides.springboot.springsecurity.web.dto.DemandeJoinDto( com.dateCom,c.adresse_marchand,c.adresse_client,c.code_Postale_marchand,c.code_Postale_client,c.desc_Colis,c.nom_client,c.prenom_client,c.rasison_sociale,c.numTel_client,c.poids, m.nom, m.Prenom,m.tel,v.nom,g.nom,v.nom,g.nom,EC.nom,com.id) "
	+ "FROM	Colis c,Commande com,Marchand m ,Ville v,Gouvernerat g,VilleColis vc,EtatCommande EC WHERE (m.id=com.marchandM) AND (com.id=c.commandeC)AND (vc.pk.colis=c.id_colis)AND (vc.pk.ville=v.id_ville) AND (v.gouverneratG=g.id)AND (com.etatCommandeE=EC.id)and(com.etatCommandeE!=1)"
	+ "AND (vc.description='Adresse d''expedition')")
List<DemandeJoinDto> AffichageDemandeExpeditionTous();

@Query(value=" SELECT new net.javaguides.springboot.springsecurity.web.dto.DemandeJoinDto(com.date_Modif,com.dateCom,c.desc_Colis,g.nom,g.nom) "
		+ "FROM	Colis c,Commande com,Marchand m ,Ville v,Gouvernerat g,VilleColis vc,EtatCommande EC WHERE (m.id=com.marchandM) AND (com.id=c.commandeC)AND (vc.pk.colis=c.id_colis)AND (vc.pk.ville=v.id_ville) AND (v.gouverneratG=g.id)AND (com.etatCommandeE=EC.id)and (com.etatCommandeE=4)"
		+ "AND (vc.description='Adresse de destination')AND (com.marchandM=?1)")

List<DemandeJoinDto> AffichageDemandeDestinationMarchHisto(Marchand id);
@Query(value=" SELECT new net.javaguides.springboot.springsecurity.web.dto.DemandeJoinDto(com.date_Modif,com.dateCom,c.desc_Colis,g.nom,g.nom)  "
		+ "FROM	Colis c,Commande com,Marchand m ,Ville v,Gouvernerat g,VilleColis vc,EtatCommande EC WHERE (m.id=com.marchandM) AND (com.id=c.commandeC)AND (vc.pk.colis=c.id_colis)AND (vc.pk.ville=v.id_ville) AND (v.gouverneratG=g.id)AND (com.etatCommandeE=EC.id)and (com.etatCommandeE=4)"
		+ "AND (vc.description='Adresse d''expedition')AND (com.marchandM=?1)")
List<DemandeJoinDto> AffichageDemandeExpeditionMarchHisto(Marchand id);







@Query(value=" SELECT new net.javaguides.springboot.springsecurity.web.dto.DemandeJoinDto( com.date_Modif,com.dateCom,c.adresse_marchand,c.adresse_client,c.desc_Colis,c.nom_client,c.prenom_client,c.rasison_sociale,c.numTel_client,c.poids,EC.nom,com.id) "
		+ "FROM	Colis c,Commande com,Marchand m, EtatCommande EC WHERE (m.id=com.marchandM) AND (com.id=c.commandeC)AND (com.etatCommandeE=EC.id)"
		+ "AND (com.marchandM=?1)")

List<DemandeJoinDto> AffichageDemandeMarch(Marchand id);
/*@Query(value=" SELECT new net.javaguides.springboot.springsecurity.web.dto.DemandeJoinDto( com.dateCom,c.adresse_marchand,c.adresse_client,c.code_Postale_marchand,c.code_Postale_client,c.desc_Colis,c.nom_client,c.prenom_client,c.rasison_sociale,c.numTel_client,c.poids, m.nom, m.Prenom,m.tel,v.nom,g.nom,v.nom,g.nom,EC.nom,com.id) "
		+ "FROM	Colis c,Commande com,Marchand m ,Ville v,Gouvernerat g,VilleColis vc,EtatCommande EC WHERE (m.id=com.marchandM) AND (com.id=c.commandeC)AND (vc.pk.colis=c.id_colis)AND (vc.pk.ville=v.id_ville) AND (v.gouverneratG=g.id)AND (com.etatCommandeE=EC.id)"
		+ "AND (vc.description='Adresse d''expedition')AND (com.marchandM=?1)")
List<DemandeJoinDto> AffichageDemandeExpeditionMarch(Marchand id);
*/



	/*@Query(value=" SELECT new net.javaguides.springboot.springsecurity.web.dto.DemandeJoinDto( com.dateCom,c.adresse_marchand,c.adresse_client,c.code_Postale_marchand,c.code_Postale_client,c.desc_Colis,c.nom_client,c.prenom_client,c.rasison_sociale,c.numTel_client,c.poids, m.nom, m.Prenom,m.tel,v.nom,g.nom,v.nom,g.nom,EC.nom,com.id) "
			+ "FROM Colis c,Commande com,Marchand m ,Ville v,Gouvernerat g,VilleColis vc,AffectationCommandeEtat AC,EtatCommande EC WHERE (m.id=com.marchandM) AND (com.id=c.commandeC)AND (vc.pk.colis=c.id_colis)AND (vc.pk.ville=v.id_ville) AND (v.gouverneratG=g.id)AND (com.id=AC.pk.commande)AND (com.id=AC.pk.commande)AND(AC.pk.etatCommande=EC.id)"
			
			+ "And (vc.description='Adresse de destination')  AND AC.date IN (select MAX(ACE.date) from AffectationCommandeEtat ACE,Commande com WHERE (com.id=ACE.pk.commande) AND (com.marchandM=?1) GROUP by (ACE.pk.commande)) ")
			
	
	@Query(value=" SELECT new net.javaguides.springboot.springsecurity.web.dto.DemandeJoinDto( com.dateCom,c.adresse_marchand,c.adresse_client,c.code_Postale_marchand,c.code_Postale_client,c.desc_Colis,c.nom_client,c.prenom_client,c.rasison_sociale,c.numTel_client,c.poids, m.nom, m.Prenom,m.tel,v.nom,g.nom,v.nom,g.nom,EC.nom,com.id) "
			+ "FROM Colis c,Commande com,Marchand m ,Ville v,Gouvernerat g,VilleColis vc,AffectationCommandeEtat AC,EtatCommande EC WHERE (m.id=com.marchandM) AND (com.id=c.commandeC)AND (vc.pk.colis=c.id_colis)AND (vc.pk.ville=v.id_ville) AND (v.gouverneratG=g.id)AND (com.id=AC.pk.commande)AND (com.id=AC.pk.commande)AND(AC.pk.etatCommande=EC.id)"
			
			+ "And (vc.description='Adresse d''expedition') AND AC.date IN (select MAX(ACE.date) from AffectationCommandeEtat ACE,Commande com WHERE (com.id=ACE.pk.commande) AND (com.marchandM=?1) GROUP by (ACE.pk.commande)) ")
			List<DemandeJoinDto> AffichageDemandeExpeditionMarch(Marchand id);
	*/
	//affichage demande Dest grand tunis
@Query(value=" SELECT new net.javaguides.springboot.springsecurity.web.dto.DemandeJoinDto(vc.pk.colis,com.dateCom,c.adresse_marchand,c.adresse_client,c.code_Postale_marchand,c.code_Postale_client,c.desc_Colis,c.nom_client,c.prenom_client,c.rasison_sociale,c.numTel_client,c.poids, m.nom, m.Prenom,m.tel,v.nom,g.nom,v.nom,g.nom,EC.nom,com.id) "
		+ "FROM	Colis c,Commande com,Marchand m ,Ville v,Gouvernerat g,VilleColis vc,EtatCommande EC WHERE (m.id=com.marchandM) AND (com.id=c.commandeC)AND (vc.pk.colis=c.id_colis)AND (vc.pk.ville=v.id_ville) AND (v.gouverneratG=g.id)AND (com.etatCommandeE=EC.id)and (com.etatCommandeE=1)"
		+ "AND (vc.description='Adresse de destination')and(g.libelle='Grand Tunis')")
List<DemandeJoinDto> AffichageDemandeDestinationGrTunis();



	/*@Query(value=" SELECT new net.javaguides.springboot.springsecurity.web.dto.DemandeJoinDto(vc.pk.colis, com.dateCom,c.adresse_marchand,c.adresse_client,c.code_Postale_marchand,c.code_Postale_client,c.desc_Colis,c.nom_client,c.prenom_client,c.rasison_sociale,c.numTel_client,c.poids, m.nom, m.Prenom,m.tel,v.nom,g.nom,v.nom,g.nom,EC.nom,com.id) "
			+ "FROM	Colis c,Commande com,Marchand m ,Ville v,Gouvernerat g,VilleColis vc,AffectationCommandeEtat AC,EtatCommande EC WHERE (m.id=com.marchandM) AND (com.id=c.commandeC)AND (vc.pk.colis=c.id_colis)AND (vc.pk.ville=v.id_ville) AND (v.gouverneratG=g.id)AND (com.id=AC.pk.commande)AND (com.id=AC.pk.commande)AND(AC.pk.etatCommande=EC.id)"
			+ "AND (vc.description='Adresse de destination') AND (g.libelle='Grand Tunis') GROUP BY (AC.pk.commande)HAVING COUNT(AC.pk.etatCommande)=1")
		*/		
@Query(value=" SELECT new net.javaguides.springboot.springsecurity.web.dto.DemandeJoinDto(vc.pk.colis,com.dateCom,c.adresse_marchand,c.adresse_client,c.code_Postale_marchand,c.code_Postale_client,c.desc_Colis,c.nom_client,c.prenom_client,c.rasison_sociale,c.numTel_client,c.poids, m.nom, m.Prenom,m.tel,v.nom,g.nom,v.nom,g.nom,EC.nom,com.id) "
		+ "FROM	Colis c,Commande com,Marchand m ,Ville v,Gouvernerat g,VilleColis vc,EtatCommande EC WHERE (m.id=com.marchandM) AND (com.id=c.commandeC)AND (vc.pk.colis=c.id_colis)AND (vc.pk.ville=v.id_ville) AND (v.gouverneratG=g.id)AND (com.etatCommandeE=EC.id)and (com.etatCommandeE=1)"
		+ "AND (vc.description='Adresse d''expedition')and(g.libelle='Grand Tunis') ")
List<DemandeJoinDto> AffichageDemandeExpeditionGrTunis();

@Query(value=" SELECT new net.javaguides.springboot.springsecurity.web.dto.DemandeJoinDto(vc.pk.colis,com.dateCom,c.adresse_marchand,c.adresse_client,c.code_Postale_marchand,c.code_Postale_client,c.desc_Colis,c.nom_client,c.prenom_client,c.rasison_sociale,c.numTel_client,c.poids, m.nom, m.Prenom,m.tel,v.nom,g.nom,v.nom,g.nom,EC.nom,com.id) "
		+ "FROM	Colis c,Commande com,Marchand m ,Ville v,Gouvernerat g,VilleColis vc,EtatCommande EC WHERE (m.id=com.marchandM) AND (com.id=c.commandeC)AND (vc.pk.colis=c.id_colis)AND (vc.pk.ville=v.id_ville) AND (v.gouverneratG=g.id)AND (com.etatCommandeE=EC.id)and (com.etatCommandeE=1)"
		+ "AND (vc.description='Adresse de destination')and(g.libelle='Hors grand tunis')")
List<DemandeJoinDto> AffichageDemandeDestinationHorsGrTunis();
@Query(value=" SELECT new net.javaguides.springboot.springsecurity.web.dto.DemandeJoinDto(vc.pk.colis,com.dateCom,c.adresse_marchand,c.adresse_client,c.code_Postale_marchand,c.code_Postale_client,c.desc_Colis,c.nom_client,c.prenom_client,c.rasison_sociale,c.numTel_client,c.poids, m.nom, m.Prenom,m.tel,v.nom,g.nom,v.nom,g.nom,EC.nom,com.id) "
		+ "FROM	Colis c,Commande com,Marchand m ,Ville v,Gouvernerat g,VilleColis vc,EtatCommande EC WHERE (m.id=com.marchandM) AND (com.id=c.commandeC)AND (vc.pk.colis=c.id_colis)AND (vc.pk.ville=v.id_ville) AND (v.gouverneratG=g.id)AND (com.etatCommandeE=EC.id)and (com.etatCommandeE=1)"
		+ "AND (vc.description='Adresse d''expedition')and(g.libelle='Hors grand tunis')")

List<DemandeJoinDto> AffichageDemandeExpeditionHorsGrTunis();

@Query(value=" SELECT new net.javaguides.springboot.springsecurity.web.dto.DemandeJoinDto( veh.matricule,com.dateCom,c.adresse_marchand,c.adresse_client,c.code_Postale_marchand,c.code_Postale_client,c.desc_Colis,c.nom_client,c.prenom_client,c.rasison_sociale,c.numTel_client,c.poids, m.nom, m.Prenom,m.tel,v.nom,g.nom,v.nom,g.nom,EC.nom,com.id) "
		+ "FROM	Colis c,Commande com,Marchand m ,Ville v,Gouvernerat g,VilleColis vc,EtatCommande EC,AffectationCommande AC,Vehicule veh WHERE (m.id=com.marchandM) AND (com.id=c.commandeC)AND (vc.pk.colis=c.id_colis)AND (vc.pk.ville=v.id_ville) AND (v.gouverneratG=g.id)AND (com.etatCommandeE=EC.id)and (com.etatCommandeE!=1)and(AC.chauffeurC=?1)"
		+ "AND (vc.description='Adresse de destination')and (AC.CommandeC=com.id)and(AC.VehiculeV=veh.id)")
List<DemandeJoinDto> AffichageDemandeDestinationChauffeur(Chauffeur id);




@Query(value=" SELECT new net.javaguides.springboot.springsecurity.web.dto.DemandeJoinDto( veh.matricule,com.dateCom,c.adresse_marchand,c.adresse_client,c.code_Postale_marchand,c.code_Postale_client,c.desc_Colis,c.nom_client,c.prenom_client,c.rasison_sociale,c.numTel_client,c.poids, m.nom, m.Prenom,m.tel,v.nom,g.nom,v.nom,g.nom,EC.nom,com.id) "
		+ "FROM	Colis c,Commande com,Marchand m ,Ville v,Gouvernerat g,VilleColis vc,EtatCommande EC,AffectationCommande AC,Vehicule veh WHERE (m.id=com.marchandM) AND (com.id=c.commandeC)AND (vc.pk.colis=c.id_colis)AND (vc.pk.ville=v.id_ville) AND (v.gouverneratG=g.id)AND (com.etatCommandeE=EC.id)and (com.etatCommandeE!=1)and(AC.chauffeurC=?1)"
		+ "AND (vc.description='Adresse d''expedition')and (AC.CommandeC=com.id)and(AC.VehiculeV=veh.id)")
List<DemandeJoinDto> AffichageDemandeExpeditionChauffeur(Chauffeur id);



	/*@Query(value=" SELECT new net.javaguides.springboot.springsecurity.web.dto.DemandeJoinDto(vc.pk.colis, com.dateCom,c.adresse_marchand,c.adresse_client,c.code_Postale_marchand,c.code_Postale_client,c.desc_Colis,c.nom_client,c.prenom_client,c.rasison_sociale,c.numTel_client,c.poids, m.nom, m.Prenom,m.tel,v.nom,g.nom,v.nom,g.nom,EC.nom,com.id) "
			+ "FROM	Colis c,Commande com,Marchand m ,Ville v,Gouvernerat g,VilleColis vc,AffectationCommandeEtat AC,EtatCommande EC WHERE (m.id=com.marchandM) AND (com.id=c.commandeC)AND (vc.pk.colis=c.id_colis)AND (vc.pk.ville=v.id_ville) AND (v.gouverneratG=g.id)AND (com.id=AC.pk.commande)AND (com.id=AC.pk.commande)AND(AC.pk.etatCommande=EC.id)"
			+ "AND (vc.description='Adresse d''expedition') AND (g.libelle='Grand Tunis')GROUP BY (AC.pk.commande)HAVING COUNT(AC.pk.etatCommande)=1")
				
				
				
				
	
	@Query(value=" SELECT new net.javaguides.springboot.springsecurity.web.dto.DemandeJoinDto(vc.pk.colis,com.dateCom,c.adresse_marchand,c.adresse_client,c.code_Postale_marchand,c.code_Postale_client,c.desc_Colis,c.nom_client,c.prenom_client,c.rasison_sociale,c.numTel_client,c.poids, m.nom, m.Prenom,m.tel,v.nom,g.nom,v.nom,g.nom,EC.nom,com.id) "
			+ "FROM	Colis c,Commande com,Marchand m ,Ville v,Gouvernerat g,VilleColis vc,AffectationCommandeEtat AC,EtatCommande EC WHERE (m.id=com.marchandM) AND (com.id=c.commandeC)AND (vc.pk.colis=c.id_colis)AND (vc.pk.ville=v.id_ville) AND (v.gouverneratG=g.id)AND (com.id=AC.pk.commande)AND (com.id=AC.pk.commande)AND(AC.pk.etatCommande=EC.id)"
			+ "AND (vc.description='Adresse de destination') AND (g.libelle='Hors grand tunis') GROUP BY (AC.pk.commande)HAVING COUNT(AC.pk.etatCommande)=1")
				List<DemandeJoinDto> AffichageDemandeDestinationHorsGrTunis();
	
	@Query(value=" SELECT new net.javaguides.springboot.springsecurity.web.dto.DemandeJoinDto(vc.pk.colis,com.dateCom,c.adresse_marchand,c.adresse_client,c.code_Postale_marchand,c.code_Postale_client,c.desc_Colis,c.nom_client,c.prenom_client,c.rasison_sociale,c.numTel_client,c.poids, m.nom, m.Prenom,m.tel,v.nom,g.nom,v.nom,g.nom,EC.nom,com.id) "
			+ "FROM	Colis c,Commande com,Marchand m ,Ville v,Gouvernerat g,VilleColis vc,AffectationCommandeEtat AC,EtatCommande EC WHERE (m.id=com.marchandM) AND (com.id=c.commandeC)AND (vc.pk.colis=c.id_colis)AND (vc.pk.ville=v.id_ville) AND (v.gouverneratG=g.id)AND (com.id=AC.pk.commande)AND (com.id=AC.pk.commande)AND(AC.pk.etatCommande=EC.id)"
			+ "AND (vc.description='Adresse d''expedition') AND (g.libelle='Hors grand tunis')GROUP BY (AC.pk.commande)HAVING COUNT(AC.pk.etatCommande)=1")
				List<DemandeJoinDto> AffichageDemandeExpeditionHorsGrTunis();

	
	*/
	
	Marchand findByEmail(String username);
	//Chauffeur findeByEmail(String username);
	
		/*@Query(value=" SELECT new net.javaguides.springboot.springsecurity.web.dto.DemandeJoinDto( AF.date_departColis,c.adresse_marchand,c.adresse_client,c.code_Postale_marchand,c.code_Postale_client,c.desc_Colis,c.nom_client,c.prenom_client,c.rasison_sociale,c.numTel_client,c.poids, m.nom, m.Prenom,m.tel,v.nom,g.nom,v.nom,g.nom,EC.nom,com.id) "
			+ "FROM	Colis c,Commande com,Marchand m ,Ville v,Gouvernerat g,VilleColis vc,AffectationCommandeEtat AC,EtatCommande EC,AffectationCommande AF  WHERE (m.id=com.marchandM) AND (com.id=c.commandeC)AND (vc.pk.colis=c.id_colis)AND (vc.pk.ville=v.id_ville) AND (v.gouverneratG=g.id)AND (com.id=AC.pk.commande)AND (com.id=AC.pk.commande)AND(AC.pk.etatCommande=EC.id)AND(AF.id_affectCommande=AC.affectationCommandeC)"
			+ "AND (vc.description='Adresse de destination') AND (AC.pk.etatCommande)=2")
			*/
	
	
	/*@Query(value=" SELECT  new net.javaguides.springboot.springsecurity.web.dto.DemandeJoinDto( AF.date_departColis,c.adresse_marchand,c.adresse_client,c.code_Postale_marchand,c.code_Postale_client,c.desc_Colis,c.nom_client,c.prenom_client,c.rasison_sociale,c.numTel_client,c.poids, m.nom, m.Prenom,m.tel,v.nom,g.nom,v.nom,g.nom,EC.nom,com.id) "
			+ "FROM Colis c,Commande com,Marchand m ,Ville v,Gouvernerat g,VilleColis vc,AffectationCommandeEtat AC,EtatCommande EC ,AffectationCommande AF WHERE (m.id=com.marchandM) AND (com.id=c.commandeC)AND (vc.pk.colis=c.id_colis)AND (vc.pk.ville=v.id_ville) AND (v.gouverneratG=g.id)AND (com.id=AC.pk.commande)AND (com.id=AC.pk.commande)AND(AC.pk.etatCommande=EC.id)"
			+ "AND (vc.description='Adresse de destination') AND(AC.pk.etatCommande=2)")*/
		//	List<DemandeJoinDto> AffichageDemandeDestinationChauffeur();

	
	
	
	/*@Query(value=" SELECT new net.javaguides.springboot.springsecurity.web.dto.DemandeJoinDto( AF.date_departColis,c.adresse_marchand,c.adresse_client,c.code_Postale_marchand,c.code_Postale_client,c.desc_Colis,c.nom_client,c.prenom_client,c.rasison_sociale,c.numTel_client,c.poids, m.nom, m.Prenom,m.tel,v.nom,g.nom,v.nom,g.nom,EC.nom,com.id) "
			+ "FROM	Colis c,Commande com,Marchand m ,Ville v,Gouvernerat g,VilleColis vc,AffectationCommandeEtat AC,EtatCommande EC,AffectationCommande AF  WHERE (m.id=com.marchandM) AND (com.id=c.commandeC)AND (vc.pk.colis=c.id_colis)AND (vc.pk.ville=v.id_ville) AND (v.gouverneratG=g.id)AND (com.id=AC.pk.commande)AND (com.id=AC.pk.commande)AND(AC.pk.etatCommande=EC.id)AND(AF.id_affectCommande=AC.affectationCommandeC)"
			+ "AND (vc.description='Adresse d''expedition') AND (AC.pk.etatCommande)=2")*/
			
	   

		/*	@Query(value=" SELECT  new net.javaguides.springboot.springsecurity.web.dto.DemandeJoinDto( AF.date_departColis,c.adresse_marchand,c.adresse_client,c.code_Postale_marchand,c.code_Postale_client,c.desc_Colis,c.nom_client,c.prenom_client,c.rasison_sociale,c.numTel_client,c.poids, m.nom, m.Prenom,m.tel,v.nom,g.nom,v.nom,g.nom,EC.nom,com.id) "
			+ "FROM Colis c,Commande com,Marchand m ,Ville v,Gouvernerat g,VilleColis vc,AffectationCommandeEtat AC,EtatCommande EC ,AffectationCommande AF WHERE (m.id=com.marchandM) AND (com.id=c.commandeC)AND (vc.pk.colis=c.id_colis)AND (vc.pk.ville=v.id_ville) AND (v.gouverneratG=g.id)AND (com.id=AC.pk.commande)AND (com.id=AC.pk.commande)AND(AC.pk.etatCommande=EC.id)"
			+ "AND (vc.description='Adresse d''expedition') AND(AC.pk.etatCommande=2)")*/

	//		List<DemandeJoinDto> AffichageDemandeExpeditionChauffeur();
	
	
	
			}

	
	

	
	//group BY vc.pk.colis
//	v.gouverneratG v.id_ville v.nom g.id,g.nom,VilleColis vc. description vc.id_ville vc.id_colis select * FROM affectation_commande_etat GROUP BY id_commande HAVING COUNT(id_etat)=1
	//FROM colis c LEFT JOIN 	c.commande s LEFT JOIN s.marchand m
	
	// Commande com ON (m.id=com.marchandM)  join Colis c ON (com.id=c.commandeC)
	//SELECT DISTINCT e FROM Employee e INNER JOIN e.tasks t where t.supervisor = e.name""
		//	+ "FROM colis c LEFT JOIN 	c.commande s  where s.id_commande=c.id_commande LEFT JOIN s.marchand m  where m.id=s.id_marchand
	
	//FROM colis c INNER JOIN 	c.commande s  where s.id_commande=c.id_commande INNER JOIN  s.marchand m  where m.id=s.id_marchand"	
//FROM marchand m JOIN commande com WHERE m.id=com.id_marchand  JOIN colis  WHERE  com.id_commande=c.id_commande") 

	/* members_test m JOIN zones_test z WHERE z.zone_id = m.zone_id"
			 marchand m JOIN commande com WHERE m.id=com.id_marchand  JOIN colis  WHERE  com.id_commande=c.id_commande
			 com.id_commande=c.id_commande*/
	//FROM	marchand m INNER JOIN  commande com ON  m.id=com.id_marchand INNER JOIN colis c ON com.id_commande=c.id_commande
	//	FROM colis c,commande com,marchand m where m.id=com.id_marchand and com.id_commande=c.id_commande"
//	FROM colis c,commande com,marchand m "+"WHERE m.id=com.id_marchand"+" AND com.id_commande=c.id_commande ",nativeQuery=true)
//FROM	marchand m INNER JOIN  commande com ON  m.id=com.id_marchand INNER JOIN colis c ON com.id_commande=c.id_commande",nativeQuery=true)  
				//	 FROM colis c  INNER JOIN	c.commande com  INNER JOIN com.marchand m"
	/*SELECT g.guichet_cod
	FROM guichets g
	INNER JOIN agences a ON a.agc_cod = g.agc_cod
	INNER JOIN delegations d ON d.ref_dlg = a.ref_dlg
	WHERE d.lib_dlg LIKE  '%Siege%'*/

	/*SELECT s.id, f.name,c.name, s.amount 
	FROM sale s
	LEFT JOIN food f ON s.food_id=f.id 
	LEFT JOIN company c ON f.company_id=c.id
	FROM colis c LEFT JOIN 	c.commande s LEFT JOIN s.marchand m
	SELECT *
	FROM A
	FULL JOIN B ON A.key = B.key*/
//			"FROM colis c LEFT JOIN 	c.commande com LEFT JOIN com.marchand m")

	
	
//	"FROM colis c LEFT JOIN commande com ON c.id_commande=com.id_commande LEFT JOIN marchand m ON com.id_marchand=m.id "
	//"FROM Sale s LEFT JOIN s.food f LEFT JOIN f.company c

//ompany->food->sale
//marchand->commande->colis->ville_colis
	
	//vrai
	//SELECT new net.javaguides.springboot.springsecurity.web.dto.DemandeJoinDto( com.dateCom,c.id_colis,c.adresse_marchand,c.adresse_client,c.code_Postale_marchand,c.code_Postale_client,c.desc_Colis,c.nom_client,c.prenom_client,c.rasison_sociale,c.numTel_client,c.poids,c.type_destination, m.nom, m.Prenom,m.tel) "
	//+ "FROM	Colis c,Commande com,Marchand m WHERE (m.id=com.marchandM) AND (com.id=c.commandeC) "
	

