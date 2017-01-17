(function() {
	'use strict';
	
	angular.module('app').controller('DefaultController', DefaultController);
	DefaultController.$inject = [ '$rootScope', '$cookieStore','ProductService' ];
	
	function DefaultController($rootScope, $cookieStore,ProductService) {
		var defaultCtrl = this;
		defaultCtrl.flowers = [];
		defaultCtrl.fruits = [];
		defaultCtrl.vegetables = [];
		if(angular.isUndefined($rootScope.selectedProductItems) || $rootScope.selectedProductItems.length == 0){
			$rootScope.selectedProductItems = [];
			$rootScope.subTotal = 0.00;
		}
		initController();
		defaultCtrl.add2Cart = add2Cart;
		
		function initController() {
			defaultCtrl.flowers = ProductService.getFlowers();
			defaultCtrl.fruits = ProductService.getFruits();
			defaultCtrl.vegetables = ProductService.getVegetables();
			if(!angular.isUndefined($cookieStore.get('globals'))){
				var obj = $cookieStore.get('globals');
				ProductService.getDraftedProductsByUser(obj.currentUser.username).then(function(response){
					$rootScope.selectedProductItems = response.data;
					console.log(angular.toJson($rootScope.selectedProductItem));
				})
			}
		}
		
		function add2Cart(selectedItem) {
			$rootScope.selectedProductItems.push(selectedItem);
			$rootScope.subTotal=$rootScope.subTotal+selectedItem.price;
		}
	}
})();