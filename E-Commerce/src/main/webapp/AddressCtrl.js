var app= angular.module('mivimAddress',[]);

app.filter('unique', function () {

	  return function (items, filterOn) {

	    if (filterOn === false) {
	      return items;
	    }

	    if ((filterOn || angular.isUndefined(filterOn)) && angular.isArray(items)) {
	      var hashCheck = {}, newItems = [];

	      var extractValueToCompare = function (item) {
	        if (angular.isObject(item) && angular.isString(filterOn)) {
	          return item[filterOn];
	        } else {
	          return item;
	        }
	      };

	      angular.forEach(items, function (item) {
	        var valueToCheck, isDuplicate = false;

	        for (var i = 0; i < newItems.length; i++) {
	          if (angular.equals(extractValueToCompare(newItems[i]), extractValueToCompare(item))) {
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
 
   app.controller('AddressCtrl',["$scope","$http","$routeParams",function($scope,$http,$routeParams) {
	   
	   $scope.item=$routeParams.item;
	   
	   $http.get("cities.json").then(function (response) {
		      $scope.myData = response.data.records;
		      $scope.myData1 = response.data.records;
		
		  });
	   $scope.addressSubmit= function(item) {
			  
			  var dto = { addressLine1: $scope.addressLine1, addressLine2:$scope.addressLine2,city:$scope.city.name,state:$scope.state.state, pincode: $scope.pincode }; 
			  var obj={listItems: item, address: dto};
			  var req = {
	    			   method: 'POST',
	    			   url: 'E-Commerce/saveAddress',
	    			   data:{
	    				   
	    			   },headers: {
	    			     'Content-Type': 'application/json'
	    			   }, 
	    			   params: obj
	    			  }
			  $http(req).then(function(response) {
		            console.log(response.data);
		            $scope.message = response.data;
		            alert("Address is saved");
		            $location.path("/payment")
		        }, function(response) {
		            //fail case
		            console.log(response);
		            $scope.message = response;
		        });
		 
		    };
	   
	   $scope.getCities= function() {
		   var obj= $scope.state;
	    	  $scope.selectedState= obj.state;
	      }
	  	  
   }]);