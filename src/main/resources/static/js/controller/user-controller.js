app.controller('userController', function($scope, $http) {
	$scope.user = {};
	$scope.users = [];
	$scope.success = false;
	var baseUrl = '/users';
	
	$scope.saveUser = function() {
		$http({
			method : 'POST',
			url : baseUrl,
			data : $scope.user
		}).then(function(response) {
			console.log(response.headers('Location'));
			console.log(response.status);
			$scope.success = true;
			$scope.clean();
		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};

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
	
	$scope.clean = function() {
		$scope.user = {};
	}
	
	$scope.listUsers();
});