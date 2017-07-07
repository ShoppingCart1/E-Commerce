var app= angular.module('mivimHome',[]);
 
   app.controller("HomeCtrl",["$scope","$http", function($scope, $http) {
	   
	   var items= null;
	   
	   
	   $scope.getData = function() {
		  
		   var req = {
    			   method: 'POST',
    			   url: 'E-Commerce/getItemsData',
    			   data:{
    				   
    			   },headers: {
    			     'Content-Type': 'application/json'
    			   },
    			   params: null
    			   
    			}
	        $http(req).then(function(response) {
	        	$scope.items = response.data;
	           
	        }, function(response) {
	            
	            console.log(response);
	          
	        });
	 
	    };
	    $scope.getItemDataById = function(itemId) {
	    	
	    	var dto={id:itemId};
			   var req = {
	    			   method: 'POST',
	    			   url: 'E-Commerce/getItemDataById',
	    			   data:{
	    				   
	    			   },headers: {
	    			     'Content-Type': 'application/json'
	    			   },
	    			   params: dto
	    			   
	    			}
		        $http(req).then(function(response) {
		        	$scope.items = response.data;
		           
		        }, function(response) {
		            
		            console.log(response);
		          
		        });
		 
		    };
	  	  
   }]);