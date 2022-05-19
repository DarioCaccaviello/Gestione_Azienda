$(document).ready(function(){
	$.ajax({
		url:"GestioneDipendentiProgettoAjax", /*La ServLet a cui fa riferimento*/ 
		dataType:"json",/*Tipologie del formato dati da passare*/ 
		type:"GET",/*tipo di richiesta*/
	}).done(function (response){
		alert("alert funziona");
		JSON.stringify(response);
		console.log(JSON.stringify(response));

	}).fail(function(){
		alert("NOPE");
	})
})

