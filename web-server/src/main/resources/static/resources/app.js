(function() {
	'use strict';
	angular.module('app', [ 'ngRoute', 'ngCookies' ]).config(config);

	config.$inject = [ '$routeProvider', '$locationProvider' ];
	function config($routeProvider, $locationProvider) {
		$routeProvider.when('/', {
			templateUrl : 'resources/default/default.view.html'
		}).when('/flowers', {
			controller : 'FlowerController',
			templateUrl : 'resources/flowers/flowers.view.html',
			controllerAs : 'vm'
		}).when('/friuts', {
			controller : 'FriutController',
			templateUrl : 'resources/friuts/friuts.view.html',
			controllerAs : 'vm'
		}).when('/vegetables', {
			controller : 'VegetableController',
			templateUrl : 'resources/vegetables/vegetables.view.html',
			controllerAs : 'vm'
		}).when('/signin', {
			controller : 'LoginController',
			templateUrl : 'resources/user/login.view.html',
			controllerAs : 'vm'
		}).when('/signup', {
			controller : 'RegisterController',
			templateUrl : 'resources/user/register.view.html',
			controllerAs : 'vm'
		}).when('/cart', {
			controller : 'CartController',
			templateUrl : 'resources/cart/cart.view.html',
			controllerAs : 'vm'
		}).otherwise({
			redirectTo : '/'
		});
	}
})();