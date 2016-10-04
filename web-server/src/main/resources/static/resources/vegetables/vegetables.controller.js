(function() {
	'use strict';
	
	angular.module('app').controller('VegetableController', VegetableController);
	VegetableController.$inject = ['VegetableService','$rootScope','$q'];
	
	function VegetableController(VegetableService, $rootScope) {
		var vegetableCtrl = this;
		vegetableCtrl.vegetables = [];
		$rootScope.selectedVegetables = [];
		vegetableCtrl.add2Bag = add2Bag;
		vegetableCtrl.show = show;
		
		initController();
		
		function initController() {
			vegetableCtrl.vegetables = VegetableService.getAll();
		};
		
		function add2Bag(selectedVegetable) {
			$rootScope.selectedVegetables.push(selectedVegetable);
		};
		function show(){
			console.log("hi");
		};
		
	}
})();