app.controller("organizationController", function($scope, $http) {
	$scope.org = {};
	$scope.orgs = [];
	var baseUrl = '/organizations';

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
	
	$scope.findAddressByZipCode = function() {
		var zipCodeUrl = 'http://viacep.com.br/ws/' + $scope.org.zipCode + '/json';
		$http({
			method : 'GET',
			url : zipCodeUrl
		}).then(function(response) {
			$scope.setAddress(response.data);
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

	$scope.setAddress = function(address) {
		if(address != null) {
			$scope.org.street = address.logradouro;
			$scope.org.complement = address.complemento;
			$scope.org.neighborhood = address.bairro;
			$scope.org.city = address.localidade;
			$scope.org.state = address.uf;
			$scope.org.zipCode = address.cep;
		}
	}
	
	$scope.listOrganizations();
});