(function() {
	'use strict';
	angular.module('app').controller('LoginController', LoginController);
	LoginController.$inject = [ 'UserService', 'AuthenticationService',
			'FlashService', '$rootScope', '$location' ];

	function LoginController(UserService, AuthenticationService, FlashService,
			$rootScope, $location) {
		var vm = this;
		vm.login = login;

		(function initController() {
			AuthenticationService.clearCredentials();
		});

		function login() {
			AuthenticationService.login(vm.username, vm.password, function(
					response) {
				if (response.success) {
					AuthenticationService.setCredentials(vm.username,
							vm.password);
					UserService.getByUsername(
							$rootScope.globals.currentUser.username).then(
							function(response) {
								$rootScope.loggedUser = response.data;
								$rootScope.access = $rootScope.loggedUser.roles.indexOf('ROLE_ADMIN') == 1;
							});
					$location.path('/');
				} else {
					FlashService.error(response.message);
				}
			});
		}
	}
})();