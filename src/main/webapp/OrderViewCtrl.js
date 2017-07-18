var app = angular.module('mivimOrderView', []);

app.controller("OrderViewCtrl", ["$scope","$routeParams", function($scope,$routeParams) {
	$scope.order=$routeParams.order;
}]);