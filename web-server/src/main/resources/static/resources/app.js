(function() {
	'use strict';
	
	angular.module('app', [ 'ngRoute', 'ngCookies','ngAnimate', 'ngSanitize', 'ui.bootstrap' ])
		.config(config)
		.run(run);
	
	config.$inject = [ '$routeProvider', '$locationProvider' ];
	function config($routeProvider, $locationProvider) {
		$routeProvider.when('/', {
			templateUrl : 'resources/default/default.view.html'
		}).when('/flowers', {
			controller : 'FlowerController',
			templateUrl : 'resources/flowers/flowers.view.html',
			controllerAs : 'flowerCtrl'
		}).when('/friuts', {
			controller : 'FriutController',
			templateUrl : 'resources/friuts/friuts.view.html',
			controllerAs : 'fruitCtrl'
		}).when('/vegetables', {
			controller : 'VegetableController',
			templateUrl : 'resources/vegetables/vegetables.view.html',
			controllerAs : 'vegetableCtrl'
		}).when('/signin', {
			controller : 'SecurityController',
			templateUrl : 'resources/user/security.view.html',
			controllerAs : 'securityCtrl'
		}).when('/products', {
			controller : 'ProductController',
			templateUrl : 'resources/admin/product.view.html',
			controllerAs : 'productCtrl'
		}).when('/cataloges', {
			controller : 'CatalogController',
			templateUrl : 'resources/admin/catalog.view.html',
			controllerAs : 'catalogCtrl'
		}).when('/baggedItems',{
			controller : 'BaggedItemsController',
			templateUrl : 'resources/baggedItems/baggedItems.view.html',
			controllerAs : 'baggedItemsCtrl'
		}).when('/signout', {
			resolve: {
				logout: ['AuthenticationService', function (AuthenticationService) {
					AuthenticationService.clearCredentials();
				}]
			}
		}).otherwise({
			redirectTo : '/'
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
				UserService.getByMobileNo($rootScope.globals.currentUser.username).then(function(response) {
					$rootScope.dtoUser = response.data;
					$rootScope.access = response.data.roles.indexOf('ROLE_ADMIN') == 1;
				});
			}
		});
	}
})();
