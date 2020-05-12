	
function change(selectedValue)
{ //selon  la valeur séléctionné
	//si on séléctionnne congé on doit ajouter les deux inputs des deux dates
if(selectedValue=="en conge")
	{
	//l'élément à créer
    let	divElem= document.createElement("div");
	//divElem.id="physique";
	divElem.className="form-group";
	divElem.id="divConge";
	//récupération de l'élément qui est avant l'élément à insérer divcong
	let etatDis=document.getElementById('etDis');
	//l'élement parent 
	let formCont=document. getElementById('formChauff');
	
	let elementParent = etatDis.parentNode;
	
	elementParent.insertBefore(divElem, etatDis.nextSibling);
	
	//création de label date de congé 
	 labelDate= document.createElement("label");
	 labelDate.for="labelDate";
	 labelDate.id="labelDate";
	 labelDate.textContent="Durée de congé "+"\u00a0 \u00a0 \u00a0  ";
	 //ajouter label a la div
	 divElem.appendChild(labelDate);
	 
	 
	//création de input de datedebut
	 let inuptDate=document.createElement("input");
	 inuptDate.type="date"	;
	 //inuptNom.className="inval";
	 inuptDate.id="inputDateDeb";
//	 inuptDate.className="form-control col";
	 inuptDate.value="";

	 

	//création de input de datefin
	 let inuptDate2=document.createElement("input");
	 inuptDate2.type="date"	;
//	 inuptNom.className="";
	 inuptDate2.id="inputDateFin";
	// inuptDate2.className="form-control col";
	 inuptDate2.value="";

	 
	//form row 
	 let divElement= document.createElement("div");
		divElement.className="form-row";
		
		
		//création de premier div qui contient date de debut
			let divElementCol1= document.createElement("div");
			divElementCol1.className="col-md-5 ";
			divElementCol1.innerHTML="De \u00a0 ";
			divElementCol1.appendChild(inuptDate);
			
		//création de premier div qui contient date de fin	
			let divElementCol2= document.createElement("div");
			divElementCol2.className="col-md-7";
			divElementCol2.innerHTML="à \u00a0 ";
			divElementCol2.appendChild(inuptDate2);
	 //ajout de ces deux éléments div element de class form row
	divElement.appendChild(divElementCol1);
	divElement.appendChild(divElementCol2);
			
		
	//ajout de l'élément div qui contient le label et input pour la premiére date et aussi la deuxiéme date
	 divElem.appendChild(divElement);
	 
	 
	// lorsque on resélectionne si se trouve ce div on le cache (on les supprime) 
	 var divAb=document.getElementById('divAbsent');
	 if(divAb!=null)
	 	{
	 document.getElementById("boxbody").removeChild(divAb);
	 	
	 }
	
	 //creation de label de controle en cas d'erreur
	 labelControl= document.createElement("label");
	  divElem.appendChild(labelControl);
	  labelControl.id="labelControle";
	  
	
	}
else if(selectedValue=="absent"){
	//l'élément à créer
    let	divElem= document.createElement("div");
	
	divElem.className="form-group";
	divElem.id="divAbsent";
	//récupération de l'élément qui est avant l'élément à insérer divAbsent
	let etatDis=document.getElementById('etDis');
	//l'élement parent 
	let formCont=document. getElementById('formChauff');
	
	let elementParent = etatDis.parentNode;
	
	elementParent.insertBefore(divElem, etatDis.nextSibling);
	
	
	 labelDate= document.createElement("label");
	 labelDate.for="labelDate";
	 labelDate.id="labelDate";
	 labelDate.textContent="Durée de congé";
	 //ajouter label a la div
	 divElem.appendChild(labelDate);
	 //création de input
	 let inputDateDeb=document.createElement("input");
	 inputDateDeb.type="date";
//	 inuptNom.className="";
	 inputDateDeb.id="inputDateDeb1";
	 inputDateDeb.className="form-control";
	 inputDateDeb.value="";

	 

	 divElem.appendChild(inputDateDeb);
	// lorsque on resélectionne si se trouve ce div on le cache (on les supprime) 
	 var divConge=document.getElementById('divConge');
	 if(divConge!=null)
	 	{
	 document.getElementById("boxbody").removeChild(divConge);
	 	
	 }
	 //si on change la valeur de séléction on doit initialiser les valeurs de input hidden
	 document.getElementById("date1").value="";
	  document.getElementById("date2").value="";
	 
	  
	  //creation de label de controle en cas d'erreur
		 labelControl= document.createElement("label");
		  divElem.appendChild(labelControl);
		  labelControl.id="labelControle";
	
	}
	
else if(selectedValue="disponible")
	{ //si on change la valeur de séléction on doit initialiser les valeurs de input hidden
	//si on passe de l'état en congé ou absent à l'état disponible on doit initialiser les valeurs à null
	 document.getElementById("date1").value="";
	  document.getElementById("date2").value="";
	  //supprimer l'éat d'absence ou bien congé (faire cacher)si se trouve
	  var divAb=document.getElementById('divAbsent');
		 if(divAb!=null)
		 	{
		 document.getElementById("boxbody").removeChild(divAb);
		 	}
		 var divConge=document.getElementById('divConge');
		 if(divConge!=null)
		 	{
		 document.getElementById("boxbody").removeChild(divConge);
		 	
		 }
	}
	
	
else{
	 var divConge=document.getElementById('divConge');
	 var divAb=document.getElementById('divAbsent');

	if(divAb!=null) 
		{
		 document.getElementById("boxbody").removeChild(divAb);
	}
	else if(divConge!=null)
		{
		 document.getElementById("boxbody").removeChild(divConge);

		}
}

	

}
	// JavaScript Document
var preventDefaultBehavior = function(e) {
    e.preventDefault();      
}	


//fonction pour afficher les deux inputs remplis par les valeurs des dates si l'état est congé et un input si l'état est absent
		$(function() 
		 {
//	 var chauffeur = "[[${ch}]]";	 
	 console.log("azerty"+chauffeur);
	 //en cas d'ajout on met l'etat disponible à readonly et séléctionne par défaut
	if((chauffeur==null)&&(document.getElementById("idchauff").value==""))
		{
		
		var dropDownListId=document.getElementById("etatDispo");
		 $("#etatDispo").addClass('readonly');
		 //pour désactiver l'affichage de la liste
		 $("#etatDispo").bind('mousedown', preventDefaultBehavior);
		
		document.getElementById("etatDispo").setAttribute("readOnly",true);
		
		//document.getElementById("dispo").setAttribute("selected",true);
	//var v=	document.getElementById("etatDispo");
		console.log("hhh");
	//alert(v);//
//	v.readOnly=false;
		}
	else
		{//sinon en cas de modidfication
		
		if(etat=="en conge")
			{//console.log("hello");
			//l'élément à créer
		    let	divElem= document.createElement("div");
			//divElem.id="physique";
			divElem.className="form-group";
			divElem.id="divConge";
			//l'élément à insérer apres divNom 
			let etatDis=document.getElementById('etDis');
			//l'élement parent 
			let formCont=document. getElementById('formChauff');
			
			let elementParent = etatDis.parentNode;
			
			elementParent.insertBefore(divElem, etatDis.nextSibling);
			
			
			 labelDate= document.createElement("label");
			 labelDate.for="labelDate";
			 labelDate.id="labelDate";
			 labelDate.textContent="Durée de congé "+"\u00a0 \u00a0 \u00a0  ";
			 //ajouter label a la div
			 divElem.appendChild(labelDate);
			 //création de input
			 
			 
			 let inuptDate=document.createElement("input");
			 inuptDate.type="date"	;
//			 inuptNom.className="";
			 inuptDate.id="inputDateDeb";
//			 inuptDate.className="form-control col";
			 //on place la valeur récupérer à partir de controlleur date1 dans inuptDate  
			 inuptDate.value=date1;
			 inuptDate.setAttribute("value",date1);

			 
			 
			 
			 
			 let inuptDate2=document.createElement("input");
			 inuptDate2.type="date"	;
//			 inuptNom.className="";
			 inuptDate2.id="inputDateFin";
			// inuptDate2.className="form-control col";
			 //on place la valeur récupérer à partir de controlleur date1 dans inuptDate  
			 inuptDate2.value=date2;
			 inuptDate.setAttribute("value",date2);
			 
			//form row 
			 let divElement= document.createElement("div");
				divElement.className="form-row";
				
				
				
					let divElementCol1= document.createElement("div");
					divElementCol1.className="col-md-5 ";
					divElementCol1.innerHTML="De \u00a0 ";
					divElementCol1.appendChild(inuptDate);
					
					let divElementCol2= document.createElement("div");
					divElementCol2.className="col-md-7";
					divElementCol2.innerHTML="à \u00a0 ";
					divElementCol2.appendChild(inuptDate2);

			divElement.appendChild(divElementCol1);
			divElement.appendChild(divElementCol2);

			 divElem.appendChild(divElement);
			  //creation de label de controle en cas d'erreur
			 labelControl= document.createElement("label");
			  divElem.appendChild(labelControl);
			  labelControl.id="labelControle";
			}
		
	else if(etat=="absent")
		{
		//l'élément à créer
	    let	divElem= document.createElement("div");
		
		divElem.className="form-group";
		divElem.id="divAbsent";
		//l'élément à insérer apres divNom 
		let etatDis=document.getElementById('etDis');
		//l'élement parent 
		let formCont=document. getElementById('formChauff');
		
		let elementParent = etatDis.parentNode;
		
		elementParent.insertBefore(divElem, etatDis.nextSibling);
		
		
		 labelDate= document.createElement("label");
		 labelDate.for="labelDate";
		 labelDate.id="labelDate";
		 labelDate.textContent="Durée de congé";
		 //ajouter label a la div
		 divElem.appendChild(labelDate);
		 //création de input
		 let inputDateDeb=document.createElement("input");
		 inputDateDeb.type="date";
//		 inuptNom.className="";
		 inputDateDeb.id="inputDateDeb1";
		 inputDateDeb.className="form-control";
		
		 inputDateDeb.value=date1;
		 inputDateDeb.setAttribute("value",date1);


		 divElem.appendChild(inputDateDeb);
		// lorsque on resélectionne si se trouve ce div on le cache (on les supprime) 
		 var divConge=document.getElementById('divConge');
		 if(divConge!=null)
		 	{
		 document.getElementById("boxbody").removeChild(divConge);
		 	
		 }
		  //creation de label de controle en cas d'erreur
		 labelControl= document.createElement("label");
		  divElem.appendChild(labelControl);
		  labelControl.id="labelControle";
		
		}	
		}
	
});

	//en changant la valeur de select on le récupére dans input hidden 
$(document).ready(function(){
	 $("#etatDispo,#inputDateDeb,#inputDateFin").change(function() {
	
		  if($("#divConge").css("visibility")!="hidden")
				  //&&($("#divPren").css("visibility")!="hidden")){
			{
			  $('#inputDateDeb').blur(function()
					  {
					if(this.value) {
					var inputDateDeb= this.value;
					
					    document.getElementById('date1').value=	inputDateDeb;	
			   }
					 
		  });
		  
			  //blur2
		  $('#inputDateFin').blur(function()
					  {
					if(this.value) {
					    var inputDateFin= this.value;
					    document.getElementById('date2').value=inputDateFin;	
					
					  }  	
					  });
		
	 }
		
  if($("#divAbsent").css("visibility")!="hidden")
		 
		 {  
		  $('#inputDateDeb').blur(function()
				  {
				if(this.value) {
				    var inputDateDeb= this.value;
				  
				    document.getElementById('date1').value=inputDateDeb;	
					
				}
				  });
		 }	 
		  });});

$(document).ready(function(){
	//contole de saisie pour input datedebut e date fin
document.getElementById("formChauff").addEventListener("submit", function(evenement) { 

	

	if((document.getElementById("inputDateFin").value == "")&&(document.getElementById("inputDateDeb").value == ""))
	{    console.log("sxdfcv1");
	 document.getElementById("inputDateDeb").className="inval";;
     document.getElementById("labelControle").className="control-label error-label";
     document.getElementById("labelControle").textContent ="*ce champs est obligatoire";
     document.getElementById("inputDateFin").className="inval";;
     document.getElementById("labelControle").className="control-label error-label";
     document.getElementById("labelControle").textContent ="*ce champs est obligatoire";

     evenement.preventDefault();
	}

    else if ((document.getElementById("inputDateFin").value == "")&&(document.getElementById("inputDateDeb").value != "")) {
        evenement.preventDefault();
        
        document.getElementById("inputDateFin").className="inval";;
        document.getElementById("labelControle").className="control-label error-label";
        document.getElementById("labelControle").textContent ="*ce champs est obligatoire";
        document.getElementById("inputDateDeb").className="";;
       // document.getElementById("labelControle").className="";
     //   document.getElementById("labelControle").textContent ="";
        console.log("sxdfcv3");
          }
    else if ((document.getElementById("inputDateDeb").value == "")&&(document.getElementById("inputDateFin").value != "")) {
        evenement.preventDefault();
        
        document.getElementById("inputDateDeb").className="inval";;
        document.getElementById("labelControle").className="control-label error-label";
        document.getElementById("labelControle").textContent ="*ce champs est obligatoire";
        document.getElementById("inputDateFin").className="";;
       // document.getElementById("labelControle").className="";
     //   document.getElementById("labelControle").textContent ="";
        console.log("sxdfcv4");
          }
	else if (document.getElementById("inputDateDeb").value == "") {
		  evenement.preventDefault();
        console.log("sxdfcv5");
        document.getElementById("inputDateDeb").className="inval";;
        document.getElementById("labelControle").className="control-label error-label";
        document.getElementById("labelControle").textContent ="*ce champs est obligatoire";
      
        //document.getElementById("email").focus();
    }
	
  
});
});
$(document).ready(function(){
	//contole de saisie pour input datedebut e date fin
document.getElementById("formChauff").addEventListener("submit", function(evenement) { 
	if (document.getElementById("inputDateDeb1").value == "") {
		//	alert(document.getElementById("inputDateDeb1").value); 
			  evenement.preventDefault();
	      console.log("sxdfcv2");
	      document.getElementById("inputDateDeb1").className="inval form-control";;
	      document.getElementById("labelControle").className="control-label error-label";
	      document.getElementById("labelControle").textContent ="*ce champs est obligatoire";
	    
	      //document.getElementById("email").focus();
	  }
	
});});

