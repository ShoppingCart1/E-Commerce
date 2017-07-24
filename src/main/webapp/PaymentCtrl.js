var app= angular.module('mivimPayment',[]);

app.controller('PaymentCtrl',["$scope","$routeParams","$http","$location", function($scope,$routeParams,$http,$location) {
	
	 $scope.order=$routeParams.order;
	 
	
	 
	 $scope.placeOrder = function(order) {
			

			var req = {
				method : 'POST',
				url : 'E-Commerce/placeOrder',
				data : {id:order.id,userId:order.userId,subTotal:order.subTotal,grandTotal:order.grandTotal,paymentMode:order.paymentMode,shippingAddressId:order.shippingAddressId,billingAddressId:null,listItems:order.listItems},
				headers : {
					'Content-Type' : 'application/json'
				}
				

			}

			$http(req).then(function(response) {
				console.log(response.data);
				$location.path("/orderView");
			}, function(response) {
				// fail case
				console.log(response);
			});

		};
	
}]);