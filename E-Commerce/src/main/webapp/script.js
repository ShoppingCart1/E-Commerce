 var app= angular.module('Customer',['ngRoute']);
 
//configure our routes
 app.config(function($routeProvider) {
     $routeProvider

         // route for the login page
         .when('/login', {
             templateUrl : 'module/login/login.html',
             controller  : 'LoginCtrl'
         })

         // route for the SignUp page
         .when('/Register', {
             templateUrl : 'module/register/Register.html',
             controller  : 'RegisterCtrl'
         })
     // route for the home page
        .when('/home', {
         templateUrl : 'home.html',
         controller  : 'HomeCtrl'
     })
 });
 
 app.controller("LoginCtrl", function($scope) {
	  
 });;
 app.controller("RegisterCtrl", function($scope) {
	  
 });;
   app.controller("HomeCtrl", function($scope,$http) {
	   $http.get("item.json").then(function (response) {
		      $scope.myData = response.data.records;
		  });
   });