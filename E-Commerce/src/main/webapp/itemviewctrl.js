var app= angular.module('mivimItemView',[]);
 
   app.controller("ItemViewCtrl",["$scope", '$routeParams', function($scope, $routeParams) {
	   
	   
	   $scope.item=$routeParams.item;
	
	  	  
   }]);