(function() {
	'use strict';
	
	angular.module('app').factory('AuthenticationService', AuthenticationService);
	AuthenticationService.$inject = [ '$http', '$cookieStore', '$rootScope', '$timeout', 'UserService' ];

	function AuthenticationService($http, $cookieStore, $rootScope, $timeout, UserService) {
		var service = {};
		service.setDetails = setDetails;
		service.clearDetails = clearDetails;
		return service;

		function setDetails(name, mobileNo, emailId, pickLocation) {
			$rootScope.globals = {
				currentUser : {
					name : name,
					mobileNo : mobileNo,
					emailId : emailId,
					pickLocation : pickLocation
				}
			};
			console.log($rootScope.globals);
			$cookieStore.put('globals', $rootScope.globals);
		}

		function clearDetails() {
			$rootScope.globals = {};
			$cookieStore.remove('globals');
			$rootScope.access = null;
		}
	}
})();
