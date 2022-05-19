<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento Progetti</title>
<!-- Link Esterni -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- FINE Link Esterni -->
<!--  Link Locali -->
<link href="CSS/css/bootstrap.min.css" rel="stylesheet" id="style">
<link href="CSS/Inserisciprogetti.css" rel="stylesheet" id="style">
</head>
<body>
<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
   <a class="navbar-brand" href="Homepage.jsp" style="max-width: 5%;">
    <img src="img/logo_transparent.png" class="img-fluid">
 </a>
  <a class="navbar-brand" href="Progetti.jsp">Progetti</a>
  <a class="navbar-brand" href="VisualizzaProgetti">Visualizza Progetti</a>
  <a class="navbar-brand" href="Logout">Logout</a>
</nav>
<!------------------------------------------------------------->

<h3>Inserimento Progetti</h3>
<div class="input-project">
<br>
<!-- NOME PROGETTO -->
<c:choose>
<c:when test="${progetto.nomeProgetto == null}">
<form name="reg" action="Progetti" method="POST">
</c:when>
<c:when test="${progetto.nomeProgetto!='null'}">
<form name="reg" action="ModificaProgetto" method="POST">
</c:when>
</c:choose>
<div class="form-group">
  <label for="nome">Nome Progetto:</label>
  <input type="text"  name="nomeProgetto" value="${progetto.nomeProgetto}">
</div>
<!-- COSTO PROGETTO -->
<div class="form-group">
  <label for="costo">Costo:</label>
  <input type="text" name="costo" value="${progetto.costo}">
</div>
<!-- DESCRIZIONE PROGETTO -->
<div class="form-group">
  <label for="descrizione">Descrizione progetto:</label>
  <textarea class="form-control" name="descrizione" rows="5" >"${progetto.descrizione}"</textarea>
</div>
<!-- FILE CARICO -->
  <div class="custom-file">
    <input type="file" class="custom-file-input" id="customFile" name="linkImg">
    <label class="custom-file-label" for="customFile" >Carica Immagine</label>
  </div>
  
 <button type="submit">Invia</button>
  
  
  
</form>
</div>









</body>
</html>