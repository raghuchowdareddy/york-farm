(function() {
	'use strict';
	
	angular.module('app').controller('SecurityController', SecurityController);
	SecurityController.$inject = [ 'UserService', 'AuthenticationService', 'FlashService', '$rootScope', '$location' ];

	function SecurityController(UserService, AuthenticationService, FlashService, $rootScope, $location) {
		var securityCtrl = this;
		securityCtrl.login = login;
		securityCtrl.register = register;

		function login() {
			AuthenticationService.login(securityCtrl.username, securityCtrl.password, function(response) {
				if (response.success) {
					AuthenticationService.setCredentials(securityCtrl.username, securityCtrl.password);
					$location.path('/');
				} else {
					FlashService.error(response.message);
				}
			});
		}
		
		function register() {
			UserService.saveUser(securityCtrl).then(function (response) {
				Service.saveUser(registerCtrl.user).then(function (response) {
	            	if (response) {
	            		FlashService.success('Registration successful', true);
	            		$location.path('/login');
	            	} else {
	            		FlashService.error(response.message);
	            		registerCtrl.dataLoading = false;
	            	}
			});
		}
	}
})();
