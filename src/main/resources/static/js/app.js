var app = angular.module('app', [ 'ngRoute' ]);

app.config(function($routeProvider, $locationProvider) {
	$routeProvider
	.when('/organizations', {
		templateUrl : 'fragments/organization.html',
		controller : 'organizationController'
	})
	.when('/organizations/:id', {
		templateUrl : 'fragments/organization-detail.html',
		controller : 'organizationDetailController'
	})
	.when('/users', {
		templateUrl : 'fragments/users/list.html',
		controller : 'userController'
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