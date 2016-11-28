(function() {
	'use strict';
	
	angular.module('app').controller('DefaultController', DefaultController);
	DefaultController.$inject = ['ProductService'];
	
	function DefaultController(ProductService) {
		var defaultCtrl = this;
		defaultCtrl.flowers = [];
		defaultCtrl.fruits = [];
		defaultCtrl.vegetables = [];
		initController();
		
		function initController() {
			defaultCtrl.flowers = ProductService.getFlowers();
			defaultCtrl.fruits = ProductService.getFruits();
			defaultCtrl.vegetables = ProductService.getVegetables();
		}
	}
})();