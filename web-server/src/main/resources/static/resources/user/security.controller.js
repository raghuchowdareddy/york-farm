(function() {
	'use strict';
	angular.module('app').controller('SecurityController', SecurityController);
	SecurityController.$inject = [ 'UserService', 'AuthenticationService',
			'FlashService', '$rootScope', '$location' ];

	function SecurityController(UserService, AuthenticationService, FlashService,
			$rootScope, $location) {
		var vm = this;
		vm.login = login;

		function login() {
			AuthenticationService.login(vm.username, vm.password, function(
					response) {
				if (response.success) {
					AuthenticationService.setCredentials(vm.username,
							vm.password);
					$location.path('/');
				} else {
					FlashService.error(response.message);
				}
			});
		}
	}
})();