var app = angular.module('mivimOrderView', []);

app.controller("OrderViewCtrl", [ "$scope", "$http", function($scope, $http) {

	$scope.getOrdersView = function() {

		var req = {
			method : 'POST',
			url : 'E-Commerce/ordersview',
			data : {

			},
			headers : {
				'Content-Type' : 'application/json'
			},
			params : null

		}
		$http(req).then(function(response) {
			$scope.order = response.data;

		}, function(response) {

			console.log(response);

		});

	}

} ]);