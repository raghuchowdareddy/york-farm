(function() {
	'use strict';
	angular.module('app').controller('VegetableController', VegetableController);
	VegetableController.$inject = ['VegetableService'];
	
	function VegetableController(VegetableService) {
		var vm = this;
		vm.vegetables = [];
		initController();
		
		function initController() {
			vm.vegetables = VegetableService.getAll();
		}
	}
})();