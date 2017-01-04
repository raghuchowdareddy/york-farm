(function() {
	'use strict';
	angular.module('app', [ 'ngRoute', 'ngCookies','ngAnimate', 'ngSanitize', 'ui.bootstrap' ])
		.config(config)
		.run(run);

	config.$inject = [ '$routeProvider', '$locationProvider' ];
	function config($routeProvider, $locationProvider) {
		$routeProvider.when('/', {
			controller: 'DefaultController',
			templateUrl: 'resources/default/default.view.html',
			controllerAs: 'defaultCtrl'
		}).when('/login', {
			controller: 'SecurityController',
			templateUrl: 'resources/user/security.view.html',
			controllerAs: 'securityCtrl'
		}).when('/register', {
			controller: 'RegisterController',
			templateUrl: 'resources/user/register.view.html',
			controllerAs: 'registerCtrl'
		}).when('/category', {
			controller: 'CategoryController',
			templateUrl: 'resources/inventory/category.view.html',
			controllerAs: 'categoryCtrl'
		}).when('/product', {
			controller: 'ProductController',
			templateUrl: 'resources/inventory/product.view.html',
			controllerAs: 'productCtrl'
		}).when('/catalog', {
			controller: 'CatalogController',
			templateUrl: 'resources/inventory/catalog.view.html',
			controllerAs: 'catalogCtrl'
		}).when('/deliveryloc', {
			controller: 'DeliveryLocationController',
			templateUrl: 'resources/user/deliveryloc.view.html',
			controllerAs: 'deliveryLocationCtrl'
		}).otherwise({
			redirectTo: '/login'
		});
	}

	run.$inject = [ '$rootScope', '$location', '$cookieStore', '$http' ];
	function run($rootScope, $location, $cookieStore, $http) {
		$rootScope.globals = $cookieStore.get('globals') || {};
		if ($rootScope.globals.currentUser) {
			$http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata;
		}
		$rootScope.$on('$locationChangeStart', function(event, next, current) {
			var restrictedPage = $.inArray($location.path(), [ '/login', '/register' ]) === -1;
			var loggedIn = $rootScope.globals.currentUser;
			if (restrictedPage && !loggedIn) {
				$location.path('/login');
			}
		});
	}
})();
