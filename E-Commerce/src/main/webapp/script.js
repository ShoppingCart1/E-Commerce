var app = angular.module('mivimMain', [ 'ngRoute', 'mivimNonSecured','mivimItemView','mivimRegister','mivimHome' ]);

// configure our routes
app.config(function($routeProvider) {
	$routeProvider
	//route for default page
	.when('/', {
		templateUrl : 'home.html',
		controller : 'HomeCtrl'
	})
	// route for the login page
	.when('/login', {
		templateUrl : 'module/login/login.html',
		controller : 'LoginCtrl'
	})

	// route for the SignUp page
	.when('/Register', {
		templateUrl : 'module/register/Register.html',
		controller : 'RegisterCtrl'
	})
	// route for the home page
	.when('/home', {
		templateUrl : 'home.html',
		controller : 'HomeCtrl'
	})
	// route for the home page
	.when('/itemview', {
		templateUrl : 'itemview.html',
		controller : 'ItemViewCtrl'
	})
	
});

