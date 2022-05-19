<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visualizza Progetti</title>
<!-- Link Esterni -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- FINE Link Esterni -->
<!--  Link Locali -->
<link href="CSS/css/bootstrap.min.css" rel="stylesheet" id="style">
<link href="CSS/visualizzaDB.css" rel="stylesheet" id="style">
<script type="text/javascript" src="JS/Login.js"></script>
<!-- FINE Link Locali -->
</head>
<body>
	<!-- NAVBAR -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="Homepage.jsp" style="max-width: 5%;">
			<img src="img/logo_transparent.png" class="img-fluid">
		</a> <a class="navbar-brand" href="Progetti.jsp">Progetti</a> <a
			class="navbar-brand" href="InserisciProgetti.jsp">Inserisci
			Progetti</a> <a class="navbar-brand" href="Logout">Logout</a>
	</nav>
	<!------------------------------------------------------------->
	<!-- CARD PROGETTI -->
	<c:forEach var="progetto" items="${progetto}">
		<div class="container">
			<div class="row">
				<div class="col col-md-3">
					<div class="card" style="width: 18rem;">
						<img src="img/logo_transparent.png" class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-title">${progetto.nomeProgetto}</h5>
							<p class="card-text">${progetto.descrizione}</p>
							<p class="card-text">${progetto.costo}</p>
							
							<!-- Modifica -->
							<form method="GET" action="ModificaProgetto">
							<input type="hidden" name="nomeProgetto" value="${progetto.nomeProgetto}">
							<input type="submit" class="btn btn-primary"  value="Modifica">		 					
							</form>
							<!-- Elimina -->
							<form method="GET" action="EliminaProgetto">
							<input type="hidden" name="nomeProgetto" value="${progetto.nomeProgetto}"> 
							<input type="submit" class="btn btn-primary" value="Elimina">
								</form>
					 <!-- Dettagli Dipendenti -->
						<form action="GestioneDipendentiProgetto">	
						 <input type="hidden" value="${progetto.nomeProgetto}" name="nomeProgetto">
                         <input type="submit"  class="btn btn-primary" name="Dettagli_Dipendenti" value="Dettagli Dipendenti">
                         </form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</body>
</html>