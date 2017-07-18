var app = angular.module('mivimAddress', []);

app.filter('unique', function() {

	return function(items, filterOn) {

		if (filterOn === false) {
			return items;
		}

		if ((filterOn || angular.isUndefined(filterOn))
				&& angular.isArray(items)) {
			var hashCheck = {}, newItems = [];

			var extractValueToCompare = function(item) {
				if (angular.isObject(item) && angular.isString(filterOn)) {
					return item[filterOn];
				} else {
					return item;
				}
			};

			angular.forEach(items, function(item) {
				var valueToCheck, isDuplicate = false;

				for (var i = 0; i < newItems.length; i++) {
					if (angular.equals(extractValueToCompare(newItems[i]),
							extractValueToCompare(item))) {
						isDuplicate = true;
						break;
					}
				}
				if (!isDuplicate) {
					newItems.push(item);
				}

			});
			items = newItems;
		}
		return items;
	};
});

app.controller('AddressCtrl', [ "$scope", "$http", "$routeParams", "$location",
		function($scope, $http, $routeParams, $location) {

			$scope.item = $routeParams.item;
			$scope.addressSubmit = function(item) {

				var addrObj = {
					addressLine1 : $scope.addressLine1,
					addressLine2 : $scope.addressLine2,
					city : $scope.city.name,
					state : $scope.state.state,
					pincode : $scope.pincode
				};
				

				var req = {
					method : 'POST',
					url : 'E-Commerce/address',
					data : {orderItemDto : item, addressDto: addrObj },
					headers : {
						'Content-Type' : 'application/json'
					},

				}

				$http(req).then(function(response) {
					console.log(response.data);
					// $scope.message = response.data;
					$location.path("/payment").search({
						order : response.data
					});
					if (!$scope.$$phase) {
						$scope.$apply();
					}
				}, function(response) {
					// fail case
					console.log(response);
				});

			};

			$http.get("cities.json").then(function(response) {
				$scope.myData = response.data.records;
				$scope.myData1 = response.data.records;

			});

			$scope.getCities = function() {
				var obj = $scope.state;
				$scope.selectedState = obj.state;
			}

		} ]);