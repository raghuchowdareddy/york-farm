(function() {
	'use strict';
	
	angular.module('app', [ 'ngRoute', 'ngCookies','ngAnimate', 'ngSanitize', 'ui.bootstrap' ])
		.config(config)
		.run(run)
		//.component('userModalComponent', { templateUrl: 'resources/default/userModal.view.html' })
		.controller('ModalInstanceController', ModalInstanceController)
		.controller('UserModalController', UserModalController);
	
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
		}).when('/product', {
			controller : 'ProductController',
			templateUrl : 'resources/admin/product.view.html',
			controllerAs : 'productCtrl'
		}).when('/catalog', {
			controller : 'CatalogController',
			templateUrl : 'resources/admin/catalog.view.html',
			controllerAs : 'catalogCtrl'
		}).when('/baggedItems',{
			controller : 'BaggedItemsController',
			templateUrl : 'resources/baggedItems/baggedItems.view.html',
			controllerAs : 'baggedItemsCtrl'
		}).otherwise({
			redirectTo : '/'
		});
	}
	
	ModalInstanceController.$inject = [ '$uibModalInstance', 'AuthenticationService' ];
	function ModalInstanceController($uibModalInstance, AuthenticationService) {
		var $userModalCtrl = this;
		$userModalCtrl.ok = function () {
			if ($userModalCtrl.mobileNumber != null || $userModalCtrl.emailId != null) {
				AuthenticationService.setDetails(null, $userModalCtrl.mobileNumber, $userModalCtrl.emailId, null);
				$uibModalInstance.close();
			}
		};
	}
	
	UserModalController.$inject = [ '$uibModal', '$log', '$scope', '$rootScope' ];
	function UserModalController($uibModal, $log, $scope, $rootScope) {
		var $userModalCtrl = this;
		var loggedIn = $rootScope.globals.currentUser;
		if (loggedIn == undefined) {
			$uibModal.open({
				animation: $userModalCtrl.animationsEnabled,
				templateUrl: 'resources/default/userModal.view.html',
				controller: 'ModalInstanceController',
				controllerAs: '$userModalCtrl'
			});
		}
	}

	run.$inject = [ '$rootScope', '$location', '$cookieStore', '$http', 'UserService' ];
	function run($rootScope, $location, $cookieStore, $http, UserService) {
		$rootScope.globals = $cookieStore.get('globals') || {};
		if ($rootScope.globals.currentUser) {
			$http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata;
		}
		$rootScope.$on('$locationChangeStart', function(event, next, current) {
			var loggedIn = $rootScope.globals.currentUser;
			if (loggedIn != undefined) {
				//UserService.getByUsername($rootScope.globals.currentUser.username).then(function(response) {
				//	$rootScope.access = response.data.roles.indexOf('ROLE_ADMIN') == 1;
				//});
			}
		});
	}
})();
