(function() {
	'use strict';
	angular.module('app', ['ngRoute', 'ngCookies'])
		.config(config)
		.controller('HeaderController', HeaderController);
	
	config.$inject = ['$routeProvider', '$locationProvider'];
	function config($routeProvider, $locationProvider) {
		$routeProvider.when('/', {
			templateUrl : 'resources/default/default.view.html'
		}).otherwise({
			redirectTo : '/'
		});
	}
	
	HeaderController.$inject = ['UserService', '$location', '$rootScope'];
	function HeaderController($rootScope) {
		var vm = this;
		vm.user = null;
		init();
		
        function init() {
	        UserService.loggedUserDetail().then(function (response) {
	        	vm.user.response;
	        });
	        console.log(vm.user);
        }
	}
})();