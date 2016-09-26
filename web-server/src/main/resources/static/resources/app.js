(function() {
	'use strict';
	angular.module('app', [ 'ngRoute', 'ngCookies','ngAnimate', 'ngSanitize', 'ui.bootstrap' ]).config(config)
	config.$inject = [ '$routeProvider', '$locationProvider' ];
	function config($routeProvider, $locationProvider) {
		$routeProvider.when('/', {
			templateUrl : 'resources/default/default.view.html'
		}).when('/flowers', {
			controller : 'FlowerController',
			templateUrl : 'resources/flowers/flowers.view.html',
			controllerAs : 'flowerContrl'
		}).when('/friuts', {
			controller : 'FriutController',
			templateUrl : 'resources/friuts/friuts.view.html',
			controllerAs : 'fruitContrl'
		}).when('/vegetables', {
			controller : 'VegetableController',
			templateUrl : 'resources/vegetables/vegetables.view.html',
			controllerAs : 'vm'
		}).when('/signin', {
			controller : 'SecurityController',
			templateUrl : 'resources/user/security.view.html',
			controllerAs : 'vm'
		}).when('/signup', {
			controller : 'RegisterController',
			templateUrl : 'resources/user/register.view.html',
			controllerAs : 'vm'
		}).when('/signout', {
			resolve: {
				logout: ['AuthenticationService', function (AuthenticationService) {
					AuthenticationService.clearCredentials();
				}]
			}
		}).when('/settings', {
			controller : 'SettingsController',
			templateUrl : 'resources/admin/settings.view.html',
			controllerAs : 'vm'
		}).when('/product', {
			controller : 'ProductController',
			templateUrl : 'resources/admin/product.view.html',
			controllerAs : 'vm'
		}).when('/catalog', {
			controller : 'CatalogController',
			templateUrl : 'resources/admin/catalog.view.html',
			controllerAs : 'vm'
		}).when('/baggedItems',{
			controller : 'BaggedItemsController',
			templateUrl : 'resources/baggedItems/baggedItems.view.html',
			controllerAs : 'vm'
		}).otherwise({
			redirectTo : '/'
		});
	}

	run.$inject = [ '$rootScope', '$location', '$cookieStore', '$http',
			'UserService' ];
	function run($rootScope, $location, $cookieStore, $http, UserService) {
		$rootScope.globals = $cookieStore.get('globals') || {};
		if ($rootScope.globals.currentUser) {
			$http.defaults.headers.common['Authorization'] = 'Basic '
					+ $rootScope.globals.currentUser.authdata;
		}
		$rootScope.$on('$locationChangeStart', function(event, next, current) {
			var loggedIn = $rootScope.globals.currentUser;
			if (loggedIn) {
				UserService.getByUsername(
						$rootScope.globals.currentUser.username).then(
						function(response) {
							$rootScope.access = response.data.roles
									.indexOf('ROLE_ADMIN') == 1;
						});
			}
		});
	}
})();