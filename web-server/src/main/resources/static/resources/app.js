(function() {
	'use strict';
	
	angular.module('app', [ 'ngRoute', 'ngCookies','ngAnimate', 'ngSanitize', 'ui.bootstrap' ])
		.config(config)
		.run(run)
		.component('userModalComponent', { templateUrl: 'resources/default/userModal.view.html' })
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
	
	ModalInstanceController.$inject = [ '$uibModalInstance' ];
	function ModalInstanceController($uibModalInstance) {
		var $userModalCtrl = this;
		$userModalCtrl.ok = function () {
			console.log('Mobile Number = ' + $userModalCtrl.mobileNumber);
			console.log('Email ID = ' + $userModalCtrl.emailId);
			$uibModalInstance.close();
		};
	}
	
	UserModalController.$inject = [ '$uibModal', '$log','$scope' ];
	function UserModalController($uibModal, $log, $scope) {
		var $userModalCtrl = this;
		$userModalCtrl.animationsEnabled = true;
		$uibModal.open({
			animation: $userModalCtrl.animationsEnabled,
			templateUrl: 'resources/default/userModal.view.html',
			controller: 'ModalInstanceController',
			controllerAs: '$userModalCtrl'
		});
		
		$userModalCtrl.openComponentModal = function () {
			$uibModal.open({
				animation: $userModalCtrl.animationsEnabled,
				component: 'userModalComponent'
			});
		};
		
		$userModalCtrl.toggleAnimation = function () {
			$userModalCtrl.animationsEnabled = !$userModalCtrl.animationsEnabled;
		};
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
				UserService.getByUsername($rootScope.globals.currentUser.username).then(function(response) {
					$rootScope.access = response.data.roles.indexOf('ROLE_ADMIN') == 1;
				});
			}
		});
	}
})();
