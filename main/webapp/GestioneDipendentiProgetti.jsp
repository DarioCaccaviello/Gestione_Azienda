<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Dipendneti Progetti</title>
<!-- Link Esterni -->
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js "></script>
<!-- FINE Link Esterni -->
<!--  Link Locali -->
<link href="CSS/css/bootstrap.min.css" rel="stylesheet" id="style">
<link href="CSS/visualizzaDB.css" rel="stylesheet" id="style">
<script type="text/javascript" src="JS/Login.js"></script>
<script type="text/javascript" src="JS/Ajax.js"></script>

<!-- FINE Link Locali -->
</head>
<body>

<!-- TABELLA 1  -->
<div class=container-fluid>
		<div class="col-xl-6">

			<table class=table>
				<thead>
					<tr>
						<th scope="col">NOME</th>
						<th scope="col">COGNOME</th>
						<th scope="col">EMAIL</th>
					</tr>
					</thead>
				<tbody>
					<c:forEach items="${persone}" var="persone">
						<tr>
							<td>${persone.nome}</td>
							<td>${persone.cognome}</td>
							<td>${persone.email}</td>
						</tr>
						<tr>
						<td>
						<form method="POST" action="GestioneDipendentiProgetto" >
						<input type="hidden" name="cf" value="${persone.cf}">
						<input type="hidden" name="nomeProgg" value="${progetto.nomeProgetto}">
                        <button  type="submit" name="ASSOCIA">ASSSOCIA</button>						
						</form>
						<td>
						</tr>
					</c:forEach>
				</tbody> 
			</table>
		</div>
		<!------------------ TABELLA 2  -------------------->
		<div class="col-xl-6">
			<table class=table>
				<thead>
					<tr>
						<th scope="col">NOME</th>
						<th scope="col">COGNOME</th>
						<th scope="col">EMAIL</th>
					</tr>
					</thead>
				<tbody>
					<c:forEach items="${persone2}" var="persone2">
						<tr>
							<td>${persone2.nome}</td>
							<td>${persone2.cognome}</td>
							<td>${persone2.email}</td>
						</tr>
						<tr>
						<td>
						<form method="POST" action="GestioneDipendentiProgetto" >
						<input type="hidden" name="cf" value="${persone2.cf}">
						<input type="hidden" name="nomeProgg" value="${progetto.nomeProgetto}">
                        <button  type="submit" name="Dissocia">Dissocia</button>						
						</form>
						<td>
						</tr>
					</c:forEach>
				</tbody> 
			</table>
		</div>
</div>
</body>
</html>