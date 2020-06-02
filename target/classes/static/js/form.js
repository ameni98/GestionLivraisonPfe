/**
 * 
 */
$(document).ready(function()
{
	$('.eBtn').on('click',function(event)
			{
		$('.MyForm #exampleModal').modal();
			});
	
	 
/*$('.bouton').on('click',function(event)
		{
	$('.MyForm #exampleModal').modal();
	//alert("hello");

 	});*/
});
function réinisialise(champ,label)
{ champ.className="form-control";
label.className="";
label.textContent ="";
	
	}
function surligne(label,champ, erreur,evenement)
{
   if(erreur)
   {   evenement.preventDefault();
	   champ.className="inval form-control";
   label.className="control-label error-label";
   label.textContent ="*ce champs est obligatoire";
}
   else{
      champ.className="form-control";
   label.className="";
   label.textContent ="";}
}
$(document).ready(function(){
	//contole de saisie pour input datedebut e date fin
document.getElementById("form").addEventListener("submit", function(evenement) { 
	
	label= document.getElementById("labelControle");
	champ= document.getElementById("vehi");
	erreur=document.getElementById("vehi").value == "";
	
	surligne(label,champ,erreur,evenement);
	// evenement.preventDefault();
	label1= document.getElementById("labelControl");
	champ1= document.getElementById("idChauffeur");
	erreur1=document.getElementById("idChauffeur").value == "";
	surligne(label1,champ1,erreur1,evenement);

	
	label= document.getElementById("labeleControl");
	champ= document.getElementById("date");
	erreur=document.getElementById("date").value == "";
	surligne(label,champ,erreur,evenement);
	 //evenement.preventDefault();
	 
});
	 
	 document.getElementById("close").addEventListener("click", function(evenement) { 
	 
	 label= document.getElementById("labelControle");
		champ= document.getElementById("vehi");	
		réinisialise(champ,label);
		 evenement.preventDefault();
		label= document.getElementById("labelControl");
		champ= document.getElementById("idChauffeur");
		
		réinisialise(champ,label);
		 evenement.preventDefault();
		
		label= document.getElementById("labeleControl");
		champ= document.getElementById("date");
		réinisialise(champ,label);
	 });
	/*if (document.getElementById("vehi").value == "") {
		//	alert(document.getElementById("inputDateDeb1").value); 
			  evenement.preventDefault();
	      console.log("sxdfcv2");
	      document.getElementById("vehi").className="inval form-control";;
	      document.getElementById("labelControle").className="control-label error-label";
	      document.getElementById("labelControle").textContent ="*ce champs est obligatoire";
	    
	      //document.getElementById("email").focus();
	  }*/
	/*if (document.getElementById("idChauffeur").value == "") {
		//	alert(document.getElementById("inputDateDeb1").value); 
			  evenement.preventDefault();
	      console.log("sxdfcv2");
	      document.getElementById("idChauffeur").className="inval form-control";;
	      document.getElementById("labelControl").className="control-label error-label";
	      document.getElementById("labelControl").textContent ="*ce champs est obligatoire";
	    
	      //document.getElementById("email").focus();
	  }
 if(document.getElementById("date").value == "") {
		//	alert(document.getElementById("inputDateDeb1").value); 
			  evenement.preventDefault();
	      console.log("sxdfcv2");
	      document.getElementById("date").className="inval form-control";;
	      document.getElementById("labeleControl").className="control-label error-label";
	      document.getElementById("labeleControl").textContent ="*ce champs est obligatoire";
	    
	      //document.getElementById("email").focus();
	  }*/
	
	
});



/*
function cliquable(e)
{
//alert(elem);
    var id=e.getAttribute("id");
   var td= e.firstElementChild.firstElementChild;
   if(td.checked==true )
  
   {//	 alert("hjbhj");
  	// document.getElementById("myCheck").checked = true;
  	 td.checked=false;
  	td.setAttribute("checked", false);
  
  	 
   }
   else{td.checked=true;
  	 td.setAttribute("checked", true);
  	 var elem=	document.getElementById('btnDis');
  	alert(elem);
  	elem.disable=false;
  	//.disable=false;
  	   	 
  	 
   }
}*/



