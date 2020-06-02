/*$(document).ready(function()
{	

$("#exampleModal").fadeOut(function(){
	//alert("ggg");
	$('#hello').value="hello";
});
});
*/


//	$('.idcomm').value());
	/*$('.eBtn').on('click',function(event)
			{alert(document.getElementById("idcomm").value);
		$('.MyForm #exampleModal #hello').value="hello";
			
		//	$('.idcomm').value());
			});
});*/


$(document).ready(function()
		{
	/*$('.formcomm').on('submit',function(event)
			{ //event.preventDefault();
		console.log("hhh");
		var id=$('#idcomm').val();
		//alert(id);
		$('#hello').text(id);
		$('.MyForm #exampleModal').modal();
		event.preventDefault();
			});*/
	  
/*	function click(e)
	{var id=$("input:hidden").attr("id");
	//var id=$('#idcomm').val();
	e.preventDefault();
	alert(id);
	$('#hello').text(id);
	var event="click";
	event.preventDefault();
		
	}
	*/
	
	/*var bouton=$("button:submit[name=sub]").attr("id");
	console.log($('#bouton').val());
	console.log(bouton);*/
	
	//en cliquant sur le bouton modifier etat
	$('.ebtn').on('click',function(event)
			{ //on récupére son id 
		 var id = $(this).attr("id");
		  //alert(id);
		//var x= document.getElementById('id').value;$('#'+id)
		 //puisque l'id de bouton est le meme que l'input hidden on récupére l'élément input hidden 
		var x= $('#'+id+' input:hidden')[0];
		//puis on récupére sa valeur
		alert(x.value);
	/*var value=	$('input:hidden').val();
	alert(value);*/
		//var id=$("input:hidden").attr("id");
		//var id=$('#idcomm').val();
			
		//	alert('hello');
		//et on le stock dans l'élément hidden d'id hello
			$('#idCommande').val(x.value);
		
			});

		/*	$('.ebtn').on('click',function(event)
					{
				//alert("hhh");
				$('.MyForm #exampleModal').modal();
				console.log("hhh");
				var id=$('#idcomm').val();
				//alert(id);
				$('#hello').text(id);
					});*/
		});

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
	champ= document.getElementById("etat");
	erreur=document.getElementById("etat").value == "0";
	surligne(label,champ,erreur,evenement);
});});
	
