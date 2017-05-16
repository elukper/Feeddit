'use strict';

angular.module('feedditApp').controller('MainController', function($scope, LoginResolver) {

	$scope.username="";
	$scope.password="";
	$scope.errorMsg = "";


	$scope.authenticate = function(){

		$scope.errorMsg = "";

		if($scope.username!="" && $scope.password != "") {

		LoginResolver.Authenticate.auth({username: $scope.username, password: $scope.password},function(response){
			var url = "";
			for(var i = 0; i<response.length;i++){
				url = url + response[i];
			}
			console.log("TADA!");
		},function(errors){
			$scope.errorMsg = "Invalid authentication";
			console.log("Meh...");
		});
		} else {
			if($scope.username === "") {
				$scope.errorMsg = $scope.errorMsg + "Username must be provided<br/>";
			}
			if($scope.password === "") {
				$scope.errorMsg = $scope.errorMsg + "Password must be provided<br/>";
			}
		}
	};



});