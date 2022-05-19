<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visualizza DB</title>
<!-- Link Esterni -->
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- FINE Link Esterni -->
<!--  Link Locali -->
<link href="CSS/css/bootstrap.min.css" rel="stylesheet" id="style">
<link href="CSS/visualizzaDB.css" rel="stylesheet" id="style">
<script type="text/javascript" src="JS/Login.js"></script>
<!-- FINE Link Locali -->
</head>
<body>
<div class=container-fluid>

<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
   <a class="navbar-brand" href="Homepage.jsp" style="max-width: 5%;">
    <img src="img/logo_transparent.png" class="img-fluid">
 </a>
  <a class="navbar-brand" href="Homepage.jsp">Home</a>
  <a class="navbar-brand" href="Form.jsp">Inserisci Dipedenti</a>
  <a class="navbar-brand" href="#">Progetti</a>
  <a class="navbar-brand" href="Logout">Logout</a>
</nav>
<!-----RICERCHE------>
<div class="col-xl-2">
<div class="form-outline">
<form action="RicercaNC">
Ricerca Nome e Cognome
<input type="search" class="form-control" placeholder="Inserire il Nome " aria-label="Search" name="nome"/>
<input type="search" class="form-control" placeholder="Inserire il Cognome " aria-label="Search" name="cognome"/>
<button type="submit" name="RicercaNC">Ricerca per nome e cognome</button>
 </form>
</div>
</div>
<!--ricerca cf-->
<div class="col-xl-2">
<div class="form-outline">
<form action="RicercaNC">
Ricerca Codice Fiscale
<input type="search" class="form-control" placeholder="Inserire il Codice Fiscale " aria-label="Search" name="cf"/>
<button type="submit" name="RicercaCF">Ricerca per Codice Fiscale</button>
 </form>
</div>
</div>
<!------------>
<!-- TABELLA ADMIN-->
<label>${permesso}</label>
<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">Nome</th>
      <th scope="col">Cognome</th>
      <th scope="col">Codice Fiscale</th>
      <th scope="col">Stipendio</th>
      <th scope="col">Permesso</th>
    </tr>
  </thead>
<c:if test="${permesso=='admin'}"> 
<c:forEach var="persona" items="${persone}">
<tr>
    <td>${persona.nome}</td>
    <td>${persona.cognome}</td>
    <td>${persona.cf}</td>
    <td>${persona.stipendio}</td>
    <td>${persona.tipo}</td>
    
<!-- Tasto Modifica   -->
<td>
<form method="GET" action="Modifica">
<input type="hidden" name="cf" value="${persona.cf}"> 
<input type="submit" value="Modifica">
</form>
<td>
<!-- Tasto Elimina   -->
<td>
<form method="GET" action="Elimina">
<input type="hidden" name="cf" value="${persona.cf}"> 
<input type="submit" value="Elimina">
</form>
<td>



</tr>
</c:forEach>
</c:if>
<!-------------------------------------------------------------->
<c:if test="${permesso=='guest'}"> 
<tr>
    <td>${persona.nome}</td>
    <td>${persona.cognome}</td>
    <td>${persona.cf}</td>
    <td>${persona.stipendio}</td>
    <td>${persona.tipo}</td>
</tr>
<td>
</c:if>  
</table>
<!----------------------------------------------------------------------->
<form action="Controller" method="GET">
			<nav aria-label="Page navigation example">
  <ul class="pagination">
     <li class="page-item"><button class="page-link" name="paginaback" type="submit">PAGINA PRECEDENTE</button></li>
    <li class="page-item"><button class="page-link" name="paginahome"type="submit">PAGINA INIZIALE</button></li>
    <li class="page-item"><button class="page-link" name="paginafinale"type="submit">PAGINA FINALE</button></li>
    <li class="page-item"><button class="page-link" name="paginanext"type="submit">PAGINA SUCCESSIVA</button></li>
  </ul>
</nav>
</form>

</body>
</html>