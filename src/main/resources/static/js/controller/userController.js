app.controller('userController', function($scope, $http) {
	var baseUrl = '/users';
	$scope.users = [];

	$scope.listUsers = function() {
		$http({
			method : 'GET',
			url : baseUrl
		}).then(function(response) {
			$scope.users = response.data;
			console.log(response.data);
			console.log(response.status);
		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.listUsers();
});