var app = angular.module('mivimMain', [ 'ngRoute', 'mivimHome','mivimNonSecured','mivimItemView','mivimRegister','mivimCart','mivimAddress','mivimPayment','mivimOrderView']);

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
	// route for the item view page
	.when('/itemview', {
		templateUrl : 'itemview.html',
		controller : 'ItemViewCtrl'
	})
	// route for the add cart page
	.when('/cartItem', {
		templateUrl : 'cartItem.html',
		controller : 'CartCtrl'
	})
	// route for the address page
	.when('/address', {
		templateUrl : 'address.html',
		controller : 'AddressCtrl'
	})
	// route for the payment page
	.when('/payment', {
		templateUrl : 'payment.html',
		controller : 'PaymentCtrl'
	})
	// route for the OrderView page
	.when('/orderView', {
		templateUrl : 'orderView.html',
		controller : 'OrderViewCtrl'
	})
	
	
	
});

