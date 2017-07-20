var app= angular.module('mivimItemView',[]);
 
   app.controller("ItemViewCtrl",["$scope","$http", '$routeParams','$window','$location', function($scope,$http, $routeParams,$window,$location) {
	   
	   
	   $scope.item=$routeParams.item;
	   
	   $scope.checking = function(item) {
		  var dto=item;
		   //var dto = { id: "1", itemName:"Item1 Name",unitPrice:"23232",inventary: "30",itemDescription:"This is an item Description" }; 
			var req = {
				method : 'POST',
				url : 'E-Commerce/addcart',
				data : {

				},
				headers : {
					'Content-Type' : 'application/json'
				},
				params : dto

			}
			$http(req).then(function(response) {
				$scope.items = response.data;
				$location.path("/cartItem").search({item:  response.data});
				if (!$scope.$$phase) {
					$scope.$apply();
				}

			}, function(response) {

				console.log(response);

			});

		};

	  	  
   }]);