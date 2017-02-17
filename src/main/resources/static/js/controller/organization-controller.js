app.controller("organizationController", function($scope, $http) {
	var baseUrl = 'http://localhost:8080/organizations';
	$scope.org = {};
	$scope.orgs = [];

	$scope.listOrganizations = function() {
		$http({
			method : 'GET',
			url : baseUrl
		}).then(function(response) {
			$scope.orgs = response.data;
			console.log(response.data);
			console.log(response.status);
		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};

	$scope.saveUpdate = function() {
		if ($scope.org.id == null) {
			$scope.saveOrganization();
		} else {
			$scope.updateOrganization();
		}
		$scope.cancel();
	};

	$scope.saveOrganization = function() {
		$http({
			method : 'POST',
			url : baseUrl,
			data : $scope.org
		}).then(function(response) {
			console.log(response.headers('Location'));
			console.log(response.status);
			$scope.listOrganizations();
		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};

	$scope.updateOrganization = function() {
		$http({
			method : 'PUT',
			url : baseUrl,
			data : $scope.org
		}).then(function(response) {
			console.log(response.status);
			$scope.listOrganizations();
		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};

	$scope.prepareUpdate = function(org) {
		$scope.org = angular.copy(org);
	};

	$scope.cancel = function() {
		$scope.org = {};
	};

	$scope.listOrganizations();
});