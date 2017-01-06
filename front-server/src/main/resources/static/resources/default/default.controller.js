(function() {
	'use strict';
	
	angular.module('app').controller('DefaultController', DefaultController);
	DefaultController.$inject = [ '$rootScope', 'ProductService' ];
	
	function DefaultController($rootScope, ProductService) {
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
		}
		
		function add2Cart(selectedItem) {
			$rootScope.selectedProductItems.push(selectedItem);
			$rootScope.subTotal=$rootScope.subTotal+selectedItem.price;
		}
	}
})();