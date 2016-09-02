(function() {
	'use strict';
	angular.module('app', ['ngRoute', 'ngCookies']).config(config);
	config.$inject = ['$routeProvider', '$locationProvider'];
	function config($routeProvider, $locationProvider) {
		$routeProvider.when('/', {
			templateUrl : 'resources/default/default.view.html'
		}).otherwise({
			redirectTo : '/'
		});
	}
})();