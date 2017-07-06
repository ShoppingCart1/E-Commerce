 var app= angular.module('mivimRegister',[]);
 
   app.controller("RegisterCtrl", function($scope, $http) {
		  $scope.Register= function() {
			  $http({
		            url : '/registerUser',
		            method : "POST",
		            data : {
		                'email' : $scope.email,
		                'password' : $scope.password,
		                'username': $scope.username,
		                'mobile': $scope.mobile
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