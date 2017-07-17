var app = angular.module('mivimHome', []);

app.controller("HomeCtrl", [ "$scope", "$http", '$location', '$window',
		function($scope, $http, $location, $window, $localStorage, $rootScope ) {

			var items = null;
			var item = null;
            var userData = null;
			$scope.getData = function() {

				var req = {
					method : 'POST',
					url : 'E-Commerce/getItemsData',
					data : {

					},
					headers : {
						'Content-Type' : 'application/json'
					},
					params : null

				}
				$http(req).then(function(response) {
					$scope.items = response.data;

				}, function(response) {

					console.log(response);

				});

			};
			$scope.getItemDataById = function(itemId) {

				var dto = {
					id : itemId
				};
				var req = {
					method : 'POST',
					url : 'E-Commerce/getItemDataById',
					data : {

					},
					headers : {
						'Content-Type' : 'application/json'
					},
					params : dto

				}
				$http(req).then(function(response) {
					$scope.item = response.data;
//					$localStorage.userData = response.data;
//                    var info = $localStorage.userData;
//                    $scope.item = response.data;
					$location.path("/itemview").search({item:  response.data[0]});
					if (!$scope.$$phase) {
						$scope.$apply();
					}

				}, function(response) {

					console.log(response);

				});

			};

		} ]);