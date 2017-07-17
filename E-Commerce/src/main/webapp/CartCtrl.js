var app= angular.module('mivimCart',[]);
 
   app.controller("CartCtrl",["$scope",'$routeParams','$http','$location',function($scope,$routeParams,$http,$location) {
	   
	   if(!$routeParams.item || $routeParams.item === "[object Object]" ) {
	    	$location.path("/home");
	    	return;
	    }
	   
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
				$scope.remove = function(item) {
					var dto = item;
						var req = {
							method : 'POST',
							url : 'E-Commerce/removecart',
							data : {

							},
							headers : {
								'Content-Type' : 'application/json'
							},
							params : null

						}
						$http(req).then(function(response) {
							$scope.item = response.data;
							

						}, function(response) {

							console.log(response);

						});
				}

   }]);