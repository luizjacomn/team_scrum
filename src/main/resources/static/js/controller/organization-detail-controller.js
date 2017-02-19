app.controller('organizationDetailController', function($scope, $routeParams, $http) {
	var baseUrl = 'organizations/' + $routeParams.id;
	$scope.org = {};
	
	$http.get(baseUrl).then(function(response) {
		$scope.org = response.data;
	}, function(response) {
		console.log(response);
	});
});