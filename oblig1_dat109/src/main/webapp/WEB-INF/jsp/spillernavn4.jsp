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
	
	<form action="spillernavn4" method="post">
	  <fieldset><legend>Spillere</legend>
	  	<c:forEach begin="1" end="${antallSpillere}" step="1" varStatus="loop">
	  	<p></p>
	      SpillerNavn <c:out value="${loop.count}"/> :<input type="text" name="navn${loop.count}"/>
	    </c:forEach>
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