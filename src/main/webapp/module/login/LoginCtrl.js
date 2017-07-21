 var app= angular.module('mivimNonSecured',[]);
 
   app.controller("LoginCtrl", function($scope,$http,$location,$window) {
	   $scope.sendPost = function() {
		   var dto = { email: $scope.email, password:$scope.password };
		   var req = {
    			   method: 'POST',
    			   url: 'E-Commerce/authentication',
    			   data:{
    				   
    			   },headers: {
    			     'Content-Type': 'application/json'
    			   }, 
    			   params: dto
    			  }
	        $http(req).then(function(response) {
	            console.log(response.data);
	            window.location.reload();
	            $location.path("/");
	           
	        }, function(response) {
	            
	            console.log(response);
	          
	        });
	 
	    };
	   
   });