(function() {
	'use strict';
	angular.module('app', [ 'ngRoute', 'ngCookies' ])
		.config(config)
		.run(run);

	config.$inject = [ '$routeProvider', '$locationProvider' ];
	function config($routeProvider, $locationProvider) {
		$routeProvider.when('/', {
			controller : 'DefaultController',
			templateUrl : 'resources/default/default.view.html',
			controllerAs : 'defaultCtrl'
		}).when('/login', {
			controller : 'SecurityController',
			templateUrl : 'resources/user/security.view.html',
			controllerAs : 'securityCtrl'
		}).when('/register', {
			controller : 'RegisterController',
			templateUrl : 'resources/user/register.view.html',
			controllerAs : 'registerCtrl'
		}).otherwise({
			redirectTo : '/login'
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
