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
			controllerAs : 'vegContrl'
		}).when('/baggeditems',{
			controller : 'BaggeditemsController',
			templateUrl : 'resources/baggeditems/baggeditems.view.html',
			controllerAs : 'baggedContrl'
			
		}).otherwise({
			redirectTo : '/'
		});
	}
})();