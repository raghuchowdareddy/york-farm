(function() {
	'use strict';
	angular.module('app', [ 'ngRoute', 'ngCookies','ngAnimate', 'ngSanitize', 'ui.bootstrap' ])
		.config(config);

	config.$inject = [ '$routeProvider', '$locationProvider' ];
	function config($routeProvider, $locationProvider) {
		$routeProvider.when('/', {
			controller: 'DefaultController',
			templateUrl: 'resources/default/default.view.html',
			controllerAs: 'defaultCtrl'
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
		}).when('/order', {
			controller: 'OrderController',
			templateUrl: '/resources/user/order.view.html',
			controllerAs: 'orderCtrl'
		}).otherwise({
			redirectTo: '/'
		});
	}
})();
