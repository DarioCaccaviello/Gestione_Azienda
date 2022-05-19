    //Codice Fiscale
    
    function controlloCf(){
   
    var cf = document.getElementById("cf")
    var labelCf = document.getElementById("labelCf");
    var cfExp = new RegExp('^[a-zA-Z]{6}\\d\\d[a-zA-Z]\\d\\d[a-zA-Z]\\d\\d\\d[a-zA-Z]$','i');
    if (cf.value == "") {
        labelCf.innerHTML = "Inserisci un Codice fiscale Valido";
        labelCf.style.color = "red";
        //cf.style.borderColor = "red";
    } else {
        labelCf.innerHTML = "";
        //cf.style.borderColor = "";
    }
    if (!cfExp.test(cf.value)) {
        labelCf.innerHTML = "CF non inserito in modo corretto ";
        //cf.style.borderColor = "red";
    } else {
        labelCf.innerHTML = "";
       //cf.style.borderColor = "";
    }
    };
    
   //Date di Nascita
function controlloData(){
    var data = document.reg.data.value;
  	var inputdata =document.reg.data;
    var errorData = document.getElementById("errorData");
  
    var oggi = new Date();
    var compleanno = new Date(data);
    var anno = oggi.getFullYear() - compleanno.getFullYear();
    var mese = (oggi.getMonth()+1) - (compleanno.getMonth()+1);
    var giorno = oggi.getDate()-compleanno.getDate();
    
 if(data === "") 
    {
        errorData.innerHTML = "Specificare una data";
        errorData.style.color = "red";
        inputdata.style.borderColor = "red";
        return false;
    }else{
		errorData.innerHTML = "";
        inputdata.style.borderColor = "";
   if(anno>=18 && (mese>=0 && giorno>=0))
      {
	    errorData.innerHTML="";
	    inputdata.style.borderColor="";
	    return true;
     }else{
         errorData.innerHTML="non sei maggiorenne";
	     errorData.style.color = "red";
         inputdata.style.borderColor = "red";
	     return false;
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
