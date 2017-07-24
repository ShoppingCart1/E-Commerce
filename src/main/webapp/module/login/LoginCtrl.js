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
				if(response.data.status==="200"){
					console.log(response.data);
		            console.log(response.data.status);
					window.location.reload();
					$window.alert("Hello User");
					$location.path("/");
				}
				else {
					
					
					var errorMessage="Username or password error";
					$scope.errorMessage = errorMessage;
					$window.alert("Wrong email or password");
					$location.path("/login");

				}
	           
	        }, function(response) {
	            
	            console.log(response);
	          
	        });
	 
	    };
	   
   });