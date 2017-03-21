(function() {
	'use strict';
	
	angular.module('app').controller('MyOrderController', MyOrderController);
	MyOrderController.$inject = [ '$rootScope', '$location' , '$scope', 'UserService'];

	function MyOrderController($rootScope, $location, $scope, UserService) {
		init();
		var myOrderCtrl = this;
		myOrderCtrl.orders = [];
		
		function init() {
			if(angular.isUndefined($rootScope.selectedProductItems) || $rootScope.selectedProductItems.length == 0) {
				if(!angular.isUndefined($cookieStore.get('globals'))) {
					UserService.getOrderedProductsByUsername($cookieStore.get('globals').currentUser.username).then(function(response) {
						myOrderCtrl.orders = response.data;
					});
				}
			}
		}
	}
})();