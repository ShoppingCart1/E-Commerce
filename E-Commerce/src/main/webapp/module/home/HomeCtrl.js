var app= angular.module('mivimHome',[]);
 
   app.controller("HomeCtrl", function($scope, $http) {
	   $http.get("item.json").then(function(response) {
			$scope.myData = response.data.records;
		});	  
   });