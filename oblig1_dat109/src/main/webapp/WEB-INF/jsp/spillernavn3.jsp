<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Antall Spillere</title>
	<link rel="stylesheet" href="css/simple.css">
</head>

<body>
	<p>Antall spiller:<c:out value="${antallSpillere}"/><br>
	
	<form action="spillernavn3" method="post">
	  <fieldset><legend>Spillere</legend>
	  	
	  	
	      spillerNavn 1:<input type="text" name="navn1"/>
	      
	      spillerNavn 2:<input type="text" name="navn2"/>
	      
	      spillerNavn 3:<input type="text" name="navn3"/>
	      
	     <p><input type="submit" value="gå til spillet" /></p>
	  </fieldset>
	</form>
	
	<form action="logout" method="post">
	  <fieldset>
	  		<p><input type="submit" value="Tilbake til start Menyen" /></p>
	  </fieldset>
	</form>
</body>

</html>