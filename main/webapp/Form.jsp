<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form</title>
<!-- Link Esterni -->
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/mvc/3.0/jquery.validate.unobtrusive.min.js"></script>
<!-- FINE Link Esterni -->
<!--  Link Locali -->
<link href="CSS/css/bootstrap.min.css" rel="stylesheet" id="style">
<link href="CSS/Form.css" rel="stylesheet" id="style">
<script type="text/javascript" src="JS/Validation.js"></script>
<!-- FINE Link Locali -->
</head>
<body>
	<h3>Registrazione Dipendenti</h3>
	<div class="super-parent">
		<div class="parent" id="parent">
			<div class="div1">
				<!-- NOME -->

				<c:choose>
					<c:when test="${persona.nome == null}">
						<form name="reg" action="Controller" method="POST">
					</c:when>
					<c:when test="${persona.nome!='null'}">
						<form name="reg" action="Modifica" method="POST">
					</c:when>
				</c:choose>

				<br>
				<div class="row">
					<label for="nome">Nome</label>
				</div>
				<input type="text" name="nome" value="${persona.nome}">
				<!-- COGNOME -->
				<div class="row">
					<div class="col-25">
						<label for="cognome">Cognome</label>
					</div>
					<input type="text" name="cognome" value="${persona.cognome}">
					<div class="row">
						<div class="col-25">
							<div class="row">
								<div class="col-25"></div>
								<!-- SEX RADIO BUTTON -->
								<div class="row">
									<div class="col-25">
										<label>Sesso :</label>
										<br>
										<c:if test="${persona.sesso != null}">
										<c:if test="${persona.sesso eq 'uomo'}">
										<label>Uomo</label>
										<input type="radio" value="uomo" name="sesso" checked>
										<label>Donna</label>
										<input type="radio" value="donna" name="sesso">
										</c:if>
										<c:if test="${persona.sesso eq 'donna'}">
										<label>Donna</label>
										<input type="radio" value="uomo" name="sesso" checked>
										<label>Donna</label>
										<input type="radio" value="donna" name="sesso">
										</c:if>
										</c:if>
										<c:if test="${persona.sesso == null}">
										<label>Uomo</label>
										<input type="radio" value="uomo" name="sesso">
										<label>Donna</label>
										<input type="radio" value="donna" name="sesso">		
										</c:if>
									</div>
								</div>
								<!-- CODICE FISCALE -->
								<label for="labelCf" class="cf" id="labelCf">Codice Fiscale</label>
							</div>
							<input type="text" name="cf" id="cf" onclick="controlloCf();" value="${persona.cf}">
							<div class="row">
								<!-- Stipendio -->
								<label for="stipendio" class="stipendio">Stipendio</label>
							</div>
							<input type="text" name="stipendio" value="${persona.stipendio}">
								<!-- DATA -->
								<label>Data di nascita  
							<input type="date" onchange="return controlloData();" name="data" value="${persona.dataNascita}">
							</label>
							<div class="row"></div>
							
							<br>
						 <label id="errorData"></label>
							
						</div>
						<!-- LUOGO DI NASCITA -->
						<div class="row">
							<label>Luogo di Nascita</label> <input type="text"
								name="luogoDiNascita" value="${persona.luogoDiNascita}">
						</div>
					</div>
				</div>
			</div>
			<!-- Username -->
			<div class="row">
				<br> <label for="username" class="username" id="username">Username</label>
			</div>
			<input type="text" id="username" name="username"
				value="${persona.username}"> <br>
			<!-- Password -->
			<div class="row">
				<label for="password" class="password" id="password">Password</label>
			</div>
			<input type="text" id="password" name="password"
				value="${persona.password}"> <br>
			<!-- Mail -->
			<div class="row">
				<label for="email" id="email" class="email">E-Mail</label>
			</div>
			<input type="text" id="email" name="email" value="${persona.email}">
			<br>
			<!-- Ruolo -->
			<div class="row">
			<label>Ruolo
			<label>${permesso}</label>
			<select name="ruolo">
			<c:if test="${permesso eq 'admin'}">
				<c:if test="${persona.nome==null}">
					<option value="0">Scegli il tuo ruolo</option>
					<option value="guest">guest</option>
					<option value="admin">admin</option>
			</c:if>
					<c:if test="${persona.nome!=null}">
					<c:if test="${persona.tipo=='admin'}">
					<option value="admin">admin</option>
					<option value="guest">guest</option>
					</c:if>
					<c:if test="${persona.tipo=='guest'}">
					<option value="guest">guest</option>
					<option value="admin">admin</option>
					</c:if>
			</c:if>
			</c:if>
			</select>
			</label>
			</div>
		</div>
		<button type="submit">Invia</button>
		</form>
	</div>

</body>
</html>