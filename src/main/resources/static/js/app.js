var app = angular.module('app', [ 'ngRoute' ]);

app.config(function($routeProvider, $locationProvider) {
	$routeProvider
		.when('/organizations', {
			templateUrl : 'fragments/organization.html',
			controller : 'organizationController'
		})
		.when('/addresses', {
			templateUrl : 'fragments/address.html',
			controller : 'addressController'
		 })
		.otherwise({
			redirectTo : '/'
		});
	
	$locationProvider.html5Mode(true);
});