package net.javaguides.springboot.springsecurity.web.dto;



import net.javaguides.springboot.springsecurity.model.Colis;
import net.javaguides.springboot.springsecurity.model.EtatCommande;


public class DemandeJoinDto {
	//ce qui concerner expediteur
	
	private String date_com;
	private  String adresse_marchand;
	private  String adresse_client;
		private String code_Postale_marchand;
		private String code_Postale_client;
		private String desc_Colis;
		private String nom_client;
		private String prenom_client;
		private String raison_sociale;
		private String numTel_client;
		private float poids;
	    private String type_destination;
	    private String nom;
	    private String prenom;
	    private String tel;
	    private Colis id_colis;
	    private String nomVilleC;
	    private String nomVilleM;
	    private String descriptionVilleColis;
	    private String nomGouverneratC;
	    private String nomGouverneratM;
	    private String nomEtat;
	    private int idCom;
	    private EtatCommande idEtat;
	    private String matricule;
	    private String date_modif;
	    
	    
		public String getDate_modif() {
			return date_modif;
		}
		public void setDate_modif(String date_modif) {
			this.date_modif = date_modif;
		}
		public String getMatricule() {
			return matricule;
		}
		public void setMatricule(String matricule) {
			this.matricule = matricule;
		}
		public EtatCommande getIdEtat() {
			return idEtat;
		}
		public void setIdEtat(EtatCommande idEtat) {
			this.idEtat = idEtat;
		}
		public String getNomEtat() {
			return nomEtat;
		}
		public void setNomEtat(String nomEtat) {
			this.nomEtat = nomEtat;
		}
		public Colis getId_colis() {
			return id_colis;
		}
		public void setId_colis(Colis id_colis) {
			this.id_colis = id_colis;
		}
		public String getDate_com() {
			return date_com;
		}
		public void setDate_com(String date_com) {
			this.date_com = date_com;
		}
		public String getAdresse_marchand() {
			return adresse_marchand;
		}
		public void setAdresse_marchand(String adresse_marchand) {
			this.adresse_marchand = adresse_marchand;
		}
		public String getAdresse_client() {
			return adresse_client;
		}
		public void setAdresse_client(String adresse_client) {
			this.adresse_client = adresse_client;
		}
		public String getCode_Postale_marchand() {
			return code_Postale_marchand;
		}
		public void setCode_Postale_marchand(String code_Postale_marchand) {
			this.code_Postale_marchand = code_Postale_marchand;
		}
		public String getCode_Postale_client() {
			return code_Postale_client;
		}
		public void setCode_Postale_client(String code_Postale_client) {
			this.code_Postale_client = code_Postale_client;
		}
		public String getDesc_Colis() {
			return desc_Colis;
		}
		public void setDesc_Colis(String desc_Colis) {
			this.desc_Colis = desc_Colis;
		}
		public String getNom_client() {
			return nom_client;
		}
		public void setNom_client(String nom_client) {
			this.nom_client = nom_client;
		}
		public String getPrenom_client() {
			return prenom_client;
		}
		public void setPrenom_client(String prenom_client) {
			this.prenom_client = prenom_client;
		}
		public String getRaison_sociale() {
			return raison_sociale;
		}
		public void setRaison_sociale(String raison_sociale) {
			this.raison_sociale = raison_sociale;
		}
		public String getNumTel_client() {
			return numTel_client;
		}
		public void setNumTel_client(String numTel_client) {
			this.numTel_client = numTel_client;
		}
		public float getPoids() {
			return poids;
		}
		public void setPoids(float poids) {
			this.poids = poids;
		}
		public String getType_destination() {
			return type_destination;
		}
		public void setType_destination(String type_destination) {
			this.type_destination = type_destination;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel = tel;
		}
		

		public DemandeJoinDto( String date_modif,String date_com,String desc_Colis,String nomGouverneratM)
			 {
			this.date_com=date_com;
			this.date_modif=date_modif;
			//this.nomGouverneratC=nomGouverneratC;
			this.nomGouverneratM=nomGouverneratM;
			
			 }
		public DemandeJoinDto( String date_modif,String date_com,String desc_Colis,String nomGouverneratM,String nomGouverneratC)
		 {
		this.date_com=date_com;
		this.date_modif=date_modif;
		this.nomGouverneratC=nomGouverneratC;
		this.nomGouverneratM=nomGouverneratM;
		this.desc_Colis=desc_Colis;
		
		 }
		
		
		
		public DemandeJoinDto( String date_modif,String date_com, String adresse_marchand, String adresse_client,
				String desc_Colis,
				 String nom_client,
					String prenom_client
					, String raison_sociale, String tel,float poids,String nomEtat,int commandeId
				)
		 {
		this.date_com=date_com;
		this.date_modif=date_modif;
this.adresse_marchand=adresse_marchand;
this.adresse_client=adresse_client;
this.nom_client=nom_client;
this.raison_sociale=raison_sociale;
this.poids=poids;
this.nomEtat=nomEtat;
this.idCom=commandeId;
this.numTel_client=tel;
		this.desc_Colis=desc_Colis;
		
		 }
		
			 
		public DemandeJoinDto(String date_com, String adresse_marchand, String adresse_client,
				String code_Postale_marchand, String code_Postale_client, String desc_Colis, String nom_client,
				String prenom_client, String raison_sociale, String numTel_client, float poids,
				String nom, String prenom, String tel, String nomVilleC,
				String nomGouverneratC,String nomVilleM,
				String nomGouverneratM,String nomEtat,int commandeId,EtatCommande etatId) {
			super();
			this.date_com = date_com;
			this.adresse_marchand = adresse_marchand;
			this.adresse_client = adresse_client;
			this.code_Postale_marchand = code_Postale_marchand;
			this.code_Postale_client = code_Postale_client;
			this.desc_Colis = desc_Colis;
			this.nom_client = nom_client;
			this.prenom_client = prenom_client;
			this.raison_sociale = raison_sociale;
			this.numTel_client = numTel_client;
			this.poids = poids;
			this.nomGouverneratC=nomGouverneratC;
			this.nomVilleC=nomVilleC;
			this.nomGouverneratM=nomGouverneratM;
			this.nomVilleM=nomVilleM;
	;
			this.nom = nom;
			this.prenom = prenom;
			this.tel = tel;
			this.nomEtat=nomEtat;
			this.idCom=commandeId;
			this.idEtat=etatId;
			//this.id_colis = id_colis;
			
		}
		
		
		public DemandeJoinDto(String date_com, String adresse_marchand, String adresse_client,
				String code_Postale_marchand, String code_Postale_client, String desc_Colis, String nom_client,
				String prenom_client, String raison_sociale, String numTel_client, float poids,
				String nom, String prenom, String tel, String nomVilleC,
				String nomGouverneratC,String nomVilleM,
				String nomGouverneratM,String nomEtat,int commandeId) {
			super();
			this.date_com = date_com;
			this.adresse_marchand = adresse_marchand;
			this.adresse_client = adresse_client;
			this.code_Postale_marchand = code_Postale_marchand;
			this.code_Postale_client = code_Postale_client;
			this.desc_Colis = desc_Colis;
			this.nom_client = nom_client;
			this.prenom_client = prenom_client;
			this.raison_sociale = raison_sociale;
			this.numTel_client = numTel_client;
			this.poids = poids;
			this.nomGouverneratC=nomGouverneratC;
			this.nomVilleC=nomVilleC;
			this.nomGouverneratM=nomGouverneratM;
			this.nomVilleM=nomVilleM;
	;
			this.nom = nom;
			this.prenom = prenom;
			this.tel = tel;
			this.nomEtat=nomEtat;
			this.idCom=commandeId;
			//this.id_colis = id_colis;
			
		}
		

		public DemandeJoinDto(String matricule,String date_com, String adresse_marchand, String adresse_client,
				String code_Postale_marchand, String code_Postale_client, String desc_Colis, String nom_client,
				String prenom_client, String raison_sociale, String numTel_client, float poids,
				String nom, String prenom, String tel, String nomVilleC,
				String nomGouverneratC,String nomVilleM,
				String nomGouverneratM,String nomEtat,int commandeId) {
			super();
			this.date_com = date_com;
			this.adresse_marchand = adresse_marchand;
			this.adresse_client = adresse_client;
			this.code_Postale_marchand = code_Postale_marchand;
			this.code_Postale_client = code_Postale_client;
			this.desc_Colis = desc_Colis;
			this.nom_client = nom_client;
			this.prenom_client = prenom_client;
			this.raison_sociale = raison_sociale;
			this.numTel_client = numTel_client;
			this.poids = poids;
			this.nomGouverneratC=nomGouverneratC;
			this.nomVilleC=nomVilleC;
			this.nomGouverneratM=nomGouverneratM;
			this.nomVilleM=nomVilleM;
	;
			this.nom = nom;
			this.prenom = prenom;
			this.tel = tel;
			this.nomEtat=nomEtat;
			this.idCom=commandeId;
			this.matricule=matricule;
			//this.id_colis = id_colis;
			
		}
		
		
		
		public DemandeJoinDto(Colis id_colis,String date_com, String adresse_marchand, String adresse_client,
				String code_Postale_marchand, String code_Postale_client, String desc_Colis, String nom_client,
				String prenom_client, String raison_sociale, String numTel_client, float poids,
				String nom, String prenom, String tel, String nomVilleC,
				String nomGouverneratC,String nomVilleM,
				String nomGouverneratM,String nomEtat,int commandeId) {
			super();
			this.date_com = date_com;
			this.adresse_marchand = adresse_marchand;
			this.adresse_client = adresse_client;
			this.code_Postale_marchand = code_Postale_marchand;
			this.code_Postale_client = code_Postale_client;
			this.desc_Colis = desc_Colis;
			this.nom_client = nom_client;
			this.prenom_client = prenom_client;
			this.raison_sociale = raison_sociale;
			this.numTel_client = numTel_client;
			this.poids = poids;
			this.nomGouverneratC=nomGouverneratC;
			this.nomVilleC=nomVilleC;
			this.nomGouverneratM=nomGouverneratM;
			this.nomVilleM=nomVilleM;
	;
			this.nom = nom;
			this.prenom = prenom;
			this.tel = tel;
			this.nomEtat=nomEtat;
			this.idCom=commandeId;
			this.id_colis = id_colis;
			
		}
		
		
		
		
		
		public DemandeJoinDto(String date_com, String adresse_marchand, String adresse_client,
				String code_Postale_marchand, String code_Postale_client, String desc_Colis, String nom_client,
				String prenom_client, String raison_sociale, String numTel_client, float poids,
				String nom, String prenom, String tel, String nomVilleC,
				String nomGouverneratC) {
			super();
			this.date_com = date_com;
			this.adresse_marchand = adresse_marchand;
			this.adresse_client = adresse_client;
			this.code_Postale_marchand = code_Postale_marchand;
			this.code_Postale_client = code_Postale_client;
			this.desc_Colis = desc_Colis;
			this.nom_client = nom_client;
			this.prenom_client = prenom_client;
			this.raison_sociale = raison_sociale;
			this.numTel_client = numTel_client;
			this.poids = poids;
	this.nomGouverneratC=nomGouverneratC;
	this.nomVilleC=nomVilleC;
			this.nom = nom;
			this.prenom = prenom;
			this.tel = tel;
			//this.id_colis = id_colis;
			
		}
		
		
		
		
		
		
		
		
		
		public int getIdCom() {
			return idCom;
		}
		public void setIdCom(int idCom) {
			this.idCom = idCom;
		}
		/*public String getNomVille() {
			return nomVille;
		}
		public void setNomVille(String nomVille) {
			this.nomVille = nomVille;
		}*/
		public String getDescriptionVilleColis() {
			return descriptionVilleColis;
		}
		public void setDescriptionVilleColis(String descriptionVilleColis) {
			this.descriptionVilleColis = descriptionVilleColis;
		}
	/*	public String getNomGouvernerat() {
			return nomGouvernerat;
		}
		public void setNomGouvernerat(String nomGouvernerat) {
			this.nomGouvernerat = nomGouvernerat;
		}
		
	   */
		public String getNomVilleC() {
			return nomVilleC;
		}
		public void setNomVilleC(String nomVilleC) {
			this.nomVilleC = nomVilleC;
		}
		public String getNomVilleM() {
			return nomVilleM;
		}
		public void setNomVilleM(String nomVilleM) {
			this.nomVilleM = nomVilleM;
		}
		public String getNomGouverneratC() {
			return nomGouverneratC;
		}
		public void setNomGouverneratC(String nomGouverneratC) {
			this.nomGouverneratC = nomGouverneratC;
		}
		public String getNomGouverneratM() {
			return nomGouverneratM;
		}
		public void setNomGouverneratM(String nomGouverneratM) {
			this.nomGouverneratM = nomGouverneratM;
		}
}
