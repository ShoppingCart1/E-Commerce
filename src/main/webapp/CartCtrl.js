var app= angular.module('mivimCart',[]);
 
   app.controller("CartCtrl",["$scope",'$routeParams','$http','$location','$rootScope',function($scope,$routeParams,$http,$location,$rootScope) {
	   
	   $scope.item=$routeParams.item;

	   $scope.buy = function(item) {
			  var dto=item;
//			  var cart={itemId: $scope.itemId, quantity: $scope.quantity,totalPrice: $scope.totalPrice}; 
					$location.path("/address").search({item:  dto});
					if (!$scope.$$phase) {
						$scope.$apply();
					}

				}, function(response) {

					console.log(response);

				}; 
		$scope.removeItem = function(item) {
					 var dto= item;
					 var req = {
								method : 'POST',
								url : 'E-Commerce/removeCartItem',
								data : {

								},
								headers : {
									'Content-Type' : 'application/json'
								},
								params : dto

							}
							$http(req).then(function(response) {
								$scope.items = response.data;
								console.log($($scope.items).length);
								var cnt= $($scope.items).length;
								$rootScope.itemCart={count: cnt};
								$location.path("/cartItem").search({item:  response.data});
								if (!$scope.$$phase) {
									$scope.$apply();
								}


							}, function(response) {

								console.log(response);

							});

				 };
				 
				 $scope.getCart= function() {
						var req = {
								method : 'POST',
								url : 'E-Commerce/getCart',
								data : {

								},
								headers : {
									'Content-Type' : 'application/json'
								},
								params : null

							}
							$http(req).then(function(response) {
								$scope.items = response.data;
								console.log($($scope.items).length);
								var cnt= $($scope.items).length;
								$rootScope.itemCart={count: cnt};
								$location.path("/cartItem").search({item:  response.data});
								if (!$scope.$$phase) {
									$scope.$apply();
								}

							}, function(response) {

								console.log(response);

							});

					};
   }]);