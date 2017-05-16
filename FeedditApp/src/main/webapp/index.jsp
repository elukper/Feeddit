<!doctype html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
<meta charset="utf-8">
<title>Spring MVC Tutorial Series by Crunchify.com</title>
<style type="text/css">
body {
	background-image: url('https://crunchify.com/bg.png');
}
div.transbox {
  margin: 30px;
  background-color: #ffffff;
  opacity: 0.4;
}
</style>
</head>
<body ng-app="feedditApp" ng-controller="MainController">
	<br>
	<div style="text-align:center" >
		<form >
  			Username:<br>
  			<input type="text" name="username" ng-model="username">
  			<br>
  			Password:<br>
  			<input type="text" name="password" ng-model="password">
  			<br><br>
  			<input type="submit" value="Submit" ng-click="authenticate()">
		</form> 
	</div>
	<div class="transbox" ng-bind-html="errorMsg">${error}</div>
	
	<div>
		<form action="<c:url value="/authenticateuser"/>" method="post" enctype="multipart/form-data" >
  			Username:<br>
  			<input type="text" name="username">
  			<br>
  			Password:<br>
  			<input type="text" name="password">
  			<br><br>
  			<input type="submit" value="Submit" >
		</form> 
	</div>
	
	
	
	<script src="resources/angular.js"></script>
	<script src="resources/angular-route.js"></script>
	<script src="resources/angular-resource.js"></script>
		<script src="resources/angular-sanitize.js"></script>
	<script type ="text/javascript" src="resources/scripts/main.js"></script>
	<script type ="text/javascript" src="resources/scripts/main.service.js"></script>
	<script type ="text/javascript" src="resources/scripts/main.controller.js"></script>
	
</body>
</html>