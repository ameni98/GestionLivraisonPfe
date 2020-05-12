// JavaScript Document
	 
	$(function() {
		
	    function Toast(type, css, msg) {
	        this.type = type;
	        this.css = css;
	        this.msg = message;}
	    
	    toastr.options.positionClass = 'toast-top-full-width';
	    toastr.options.extendedTimeOut = 0; //1000;
	    toastr.options.timeOut = 1000;
	    toastr.options.fadeOut = 250;
	    toastr.options.fadeIn = 250;
		toastr.options.closeButton = true;
		toastr.options.closeMethod = 'fadeOut';
		toastr.options.closeDuration = 1000;
		toastr.options.closeEasing = 'swing';
	
	 /*   function delayToasts( t) {
	        window.setTimeout(function () {
	        	showToast(t); });
	    }
*/
	    function showToast( t) {
	        toastr.options.positionClass = t.css;
	        toastr[t.type](t.msg);
	       // i++;
	       // delayToasts();
	    }
	    if(message!=null)
	    	{
	   if(message.length!=0)
	    	{
		   if(message=="Oups!Erreur est survenue")
			   {
			   t1= new Toast('error', 'toast-top-right',message);
			   showToast(t1); 
			  
			   }
		   else
			   {    t2= new Toast('success', 'toast-top-right',message),
			   showToast(t2); 
			   }
	    	
	    	}}
	   
	    
	});