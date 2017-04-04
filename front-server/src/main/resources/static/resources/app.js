(function() {
	'use strict';
	
	angular.module('app', [ 'ngRoute', 'ngCookies' ])
		.config(config)
		.run(run);
	
	config.$inject = [ '$routeProvider', '$locationProvider' ];
	function config($routeProvider, $locationProvider) {
		$routeProvider.when('/', {
			controller: 'DefaultController',
			templateUrl: 'resources/default/default.view.html',
			controllerAs: 'defaultCtrl'
		}).when('/login', {
			controller : 'SecurityController',
			templateUrl : 'resources/user/security.view.html',
			controllerAs : 'securityCtrl'
		}).when('/logout', {
			resolve: {
				logout: ['AuthenticationService', function (AuthenticationService) {
					AuthenticationService.clearCredentials();
				}]
			}
		}).when('/cart', {
			controller: 'CartController',
			templateUrl: 'resources/user/cart.view.html',
			controllerAs: 'cartCtrl'
		}).when('/checkout', {
			controller: 'CheckoutController',
			templateUrl: 'resources/user/checkout.view.html',
			controllerAs: 'checkoutCtrl'
		}).otherwise({
			redirectTo: '/'
		});
	}

	run.$inject = [ '$rootScope', '$location', '$cookieStore', '$http', 'UserService' ];
	function run($rootScope, $location, $cookieStore, $http, UserService) {
		$rootScope.globals = $cookieStore.get('globals') || {};
		if ($rootScope.globals.currentUser) {
			$http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata;
		}
		$rootScope.$on('$locationChangeStart', function(event, next, current) {
			var loggedIn = $rootScope.globals.currentUser;
			if (loggedIn) {
				UserService.getDetailByUsername($rootScope.globals.currentUser.username).then(function(response) {
					$rootScope.user = response.data;
					$rootScope.access = response.data.roles.indexOf('ROLE_ADMIN') == 1;
				});
			}
		});
	}
})();