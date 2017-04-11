(function() {
	'use strict';
	
	angular.module('app').controller('SecurityController', SecurityController);
	SecurityController.$inject = [ 'UserService', 'AuthenticationService', 'FlashService', '$rootScope', '$scope', '$location' ];

	function SecurityController(UserService, AuthenticationService, FlashService, $rootScope, $scope, $location) {
		var securityCtrl = this;
		securityCtrl.login = login;
		securityCtrl.register = register;

		function login() {
			if(angular.isUndefined(securityCtrl.username)) {
				swal("Request...", "Please fill your credentials", "error");
				return;
			}
			AuthenticationService.login(securityCtrl.username, securityCtrl.password, function(response) {
				if (response.success) {
					AuthenticationService.setCredentials(securityCtrl.username, securityCtrl.password);
					if((!angular.isUndefined($rootScope.currentLocation)) && $rootScope.currentLocation != ''){
						$location.path($rootScope.currentLocation);
						$rootScope.currentLocation = null;
					}else{
						$location.path('/');
					}
				} else {
					FlashService.error(response.message);
					
				}
			});
		}
		
		function register() {
			UserService.saveUser(securityCtrl).then(function (response) {
				swal("Request...", "Thanks, You have successfully registered!", "info");
				$location.path('/login');
			});
		}
	}	
})();
