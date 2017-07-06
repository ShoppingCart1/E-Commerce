 var app= angular.module('mivimNonSecured',[]);
 
   app.controller("LoginCtrl", function($scope,$http) {
	   $scope.sendPost = function() {
	        $http({
	            url : 'authentication',
	            method : "POST",
	            data : {
	                'email' : $scope.email,
	                'password' : $scope.password
	            }
	        }).then(function(response) {
	            console.log(response.data);
	            $scope.message = response.data;
	        }, function(response) {
	            //fail case
	            console.log(response);
	            $scope.message = response;
	        });
	 
	    };
	   
   });