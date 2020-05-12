
function format ( d ) {
    // `d` is the original data object for the row
   return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">'+
        '<tr>'+
            '<th >Adresse d\'expédition détaillé</th>'+
        '</tr>'+
            '<tr>'+
            '<td>'+ "ville d'expedition: " +d.nomVilleM+'</td>'+'<td>'+ "gouvernerat d'expedition: "+d.nomGouverneratM+'</td>'+
        '</tr>'+
        '<tr>'+
            '<th>Adresse de destination détaillé</th>'+
         '</tr>'+
         '<tr>'+
            '<td>'+ "ville de destination: " +d.nomVilleC+'</td>'+'<td>'+ "gouvernerat de destination: "+d.nomGouverneratC+'</td>'+
          
        '</tr>'+
        '<tr>'+
        '<th>Information sur les colis:</th>'+
        '</tr>'+
        '<tr>'+
        '<td>'+ "poids: " +d.poids+'</td>'+'<td>'+ "type de marchandise: "+d.desc_Colis+'</td>'+
        
        
    '</tr>'+
       
    '</table>';
}

function rgfr()
{
	 var data=JSON.stringify(demandes);
		
	 var otf=otf.OpenTextFile("/texte/data.txt" ,true);
	 otf.WriteLine(data);
	 otf.Close();
	  }
$(document).ready(function() {
	
	 var token = $("meta[name='_csrf']").attr("content");
	  var header = $("meta[name='_csrf_header']").attr("content");
	  $(document).ajaxSend(function(e, xhr, options) {
	      xhr.setRequestHeader(header, token);
	  });

		 var data=JSON.stringify(demandes);//console.log(Object.keys(data));
	//	var value=[];
    	//var data2=JSON.parse(data);
    //	console.log(data2[0]['poids']);
//console.log(data);
    	//names=Object.getOwnPropertyNames(data);
    	//Object.getOwnPropertyNames(data);
    	//names=Object.keys(data)[8];
   // console.log(object.Keys(data));


for(var i in data){
    var key = i;
    var val = data[i];
    for(var j in val){
        var sub_key = j;
        var sub_val = val[j];
      //  console.log(val);
    }
}


    	Object.keys(data).forEach(function(key) {
    	    var value = data[key];
    	  // console.log(value);
    	    // 
    	    return value;
    	});
    	
    var table = $('#example').DataTable( {
    
    	"ajax": "texte/data.txt",
        "columns": [
            {
                "className":'details-control',
                "orderable":      false,
                "data":           null,
                "defaultContent": ''
            },
            { "data":"date_com"},
            { "data": "nomEtat" },
            { "data": "adresse_marchand"},
            { "data":"adresse_client"},
            
        ]  ,"order": [[1, 'asc']]
    } );
     
    // Add event listener for opening and closing details
    $('#example tbody').on('click', 'td.details-control', function () {
        var tr = $(this).closest('tr');
        var row = table.row( tr );
 
        if ( row.child.isShown() ) {
            // This row is already open - close it
            row.child.hide();
            tr.removeClass('shown');
        }
        else {
            // Open this row
            row.child( format(row.data()) ).show();
            tr.addClass('shown');
        }
    } );
} );
