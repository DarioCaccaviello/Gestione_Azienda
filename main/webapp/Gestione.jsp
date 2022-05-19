<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Azienda</title>
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
<link href="CSS/Gestione.css" rel="stylesheet" id="style">
<script type="text/javascript" src=""></script>
<!-- FINE Link Locali -->
</head>
<body>
<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
   <a class="navbar-brand" href="Homepage.jsp" style="max-width: 10%;">
    <img src="img/logo_transparent.png" class="img-fluid">
 </a>
  <a class="navbar-brand" href="Homepage.jsp">Home</a>
  <a class="navbar-brand" href="VisualizzaDB">Visualizza Dipendenti</a>
  <a class="navbar-brand" href="Form.jsp">Inserisci Dipedenti</a>
  <a class="navbar-brand" href="Progetti.jsp">Progetti</a>
  <a class="navbar-brand" href="Logout">Logout</a>
</nav>
<h4>Benvenuto <%= request.getParameter("us_email")%> </h4>
</body>
</html>