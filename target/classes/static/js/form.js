/**
 * 
 */
$(document).ready(function()
{
	$('.eBtn').on('click',function(event)
			{
		$('.MyForm #exampleModal').modal();
			});
	
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