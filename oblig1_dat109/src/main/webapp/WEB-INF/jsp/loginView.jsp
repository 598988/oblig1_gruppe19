<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/simple.css">
</head>
<body>
	<p style="color:red">${redirectMessage}</p>
	
	<form action="login" method="post">
		<fieldset><legend>slange og stige spillet</legend>
		
		<h1>velg antall spillere</h1>
		
			spillere: <input type="submit" name="antallSpillere" value="2"/><br>
			
			spillere: <input type="submit" name="antallSpillere" value="3"/><br>
			
			spillere: <input type="submit" name="antallSpillere" value="4"/><br>
			
		</fieldset>
	</form>
</body>
</html>

