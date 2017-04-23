(function() {
	'use strict';
	
	angular.module('app').controller('DefaultController', DefaultController);
	DefaultController.$inject = [ '$rootScope', '$scope', '$cookieStore', 'ProductService', 'UserService' ];
	
	function DefaultController($rootScope, $scope, $cookieStore, ProductService, UserService) {
		var defaultCtrl = this;
		defaultCtrl.flowers = [];
		defaultCtrl.fruits = [];
		defaultCtrl.vegetables = [];
		if(angular.isUndefined($rootScope.selectedProductItems) || $rootScope.selectedProductItems.length == 0) {
			$rootScope.selectedProductItems = [];
		}
		initController();
		defaultCtrl.add2Cart = add2Cart;
	
		function initController() {
			ProductService.getFlowers().then(function(response) {
				defaultCtrl.flowers = response.data;
			});
			ProductService.getFruits().then(function(response) {
				defaultCtrl.fruits = response.data;
			});
			ProductService.getVegetables().then(function(response) {
				defaultCtrl.vegetables = response.data;
			});
			if(angular.isUndefined($rootScope.selectedProductItems) || $rootScope.selectedProductItems.length == 0) {
				if(!angular.isUndefined($cookieStore.get('globals'))) {
					UserService.getDraftedProductsByUsername($cookieStore.get('globals').currentUser.username).then(function(response) {
						$rootScope.userOrder = response.data;
						angular.forEach($rootScope.userOrder.orderedItems, function(item, key) {
							$rootScope.selectedProductItems.push({
								'productId': item.productId,
								'productName': item.productName,
								'price': item.price,
								'quantity': item.quantity
							});
						});
					});
				}
			}
		}
		
		function add2Cart(selectedItem) {
			$rootScope.selectedProductItems.push({
				'productId': selectedItem.productId,
				'productName': selectedItem.productName,
				'price': selectedItem.price,
				'quantity': 1
			});
		}
	}
})();