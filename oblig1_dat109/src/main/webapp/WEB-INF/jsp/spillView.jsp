<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Antall Spillere</title>
	<link rel="stylesheet" href="css/simple.css">
</head>
<body>
	<p>Slange og stige spillet
	
	  <fieldset><legend>Spillere</legend>
	 <p> Antall spiller:<c:out value="${antallSpillere}"/><br> 
	  <table><tr>
			<th>navn</th>
			<th>rute</th>
		</tr>
		<c:forEach var="spiller" items="${spillere.spillere}"><tr>	
			<td>${spiller.navn}</td>
			<td>${spiller.verdi}</td>
		</tr></c:forEach>
	 </table><br></fieldset>
	
	
	<form action="spill" method="post">
	<button type="submit" value="spill">Trill terning</button>	
	
	<fieldset>
	<table>
	<tr>
	<c:forEach begin="1" end="${brett}" step="1" varStatus="rute">
	<c:set var="val" value="${spiller1.verdi}"/>
	<c:set var="val1" value="${spiller2.verdi}"/>
	<c:set var="val2" value="${spiller3.verdi}"/>
	<c:set var="val3" value="${spiller4.verdi}"/>
  		<c:choose>
   		<c:when test="${val.equals(rute.count)}">
   		
   			<td style="background-color:lightblue;">${rute.count} ${spiller1.navn} </td>
			<c:if test="${(rute.count mod 10) == 0}"> 
			<tr></tr>
			</c:if>
   		
   		</c:when>
   			<c:when test="${val1.equals(rute.count)}">
   		
   			<td style="background-color:yellow;">${rute.count} ${spiller2.navn} </td>
			<c:if test="${(rute.count mod 10) == 0}"> 
			<tr></tr>
			</c:if>
   		
   		</c:when>
		<c:when test="${val2.equals(rute.count)}">
			<td style="background-color:#aaffaa;">${rute.count} ${spiller3.navn}</td>
			<c:if test="${(rute.count mod 10) == 0}"> 
			<tr></tr>
			</c:if>
			
			</c:when>
			<c:when test="${val3.equals(rute.count)}">
			<td style="background-color:red;">${rute.count} ${spiller4.navn}</td>
			<c:if test="${(rute.count mod 10) == 0}"> 
			<tr></tr>
			</c:if>
			
			</c:when>
			<c:otherwise>
			
				<td>${rute.count}</td>
			<c:if test="${(rute.count mod 10) == 0}"> 
			<tr></tr>
			</c:if>
			
			</c:otherwise>
			</c:choose>
	</c:forEach>
	</tr>
	</table>
	
	</fieldset>	
	</form>
	<form action="logout" method="post">
	  <fieldset>
	  		<p><input type="submit" value="Tilbake til start Menyen" /></p>
	  </fieldset>
	</form>
	
	
</body>

</html>