(function() {
	'use strict';
	angular.module('app').controller('VegetableController', VegetableController);
	VegetableController.$inject = ['VegetableService','$rootScope'];
	
	function VegetableController(VegetableService, $rootScope) {
		var vm = this;
		vm.vegetables = [];
		$rootScope.selectedVegetables = [];
		vm.add2Bag = add2Bag;
		initController();
		
		function initController() {
			vm.vegetables = VegetableService.getAll();
		}
		
		function add2Bag(selectedVegetable) {
			$rootScope.selectedVegetables.push(selectedVegetable);
		}
	}
})();