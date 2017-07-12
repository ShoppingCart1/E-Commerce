var app= angular.module('mivimCart',[]);
 
   app.controller("CartCtrl",["$scope",'$routeParams',function($scope,$routeParams) {
	   
	   $scope.item=$routeParams.item;

	  	  
   }]);