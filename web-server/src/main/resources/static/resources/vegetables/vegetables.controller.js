(function() {
	'use strict';
	
	angular.module('app').controller('VegetableController', VegetableController);
	VegetableController.$inject = ['VegetableService','$rootScope','$q'];
	
	function VegetableController(VegetableService, $rootScope) {
		var _this = this;
		_this.vegetables = [];
		$rootScope.selectedVegetables = [];
		_this.add2Bag = add2Bag;
		_this.show = show;
		
		initController();
		
		function initController() {
			_this.vegetables = VegetableService.getAll();
		};
		
		function add2Bag(selectedVegetable) {
			$rootScope.selectedVegetables.push(selectedVegetable);
		};
		function show(){
			console.log("hi");
		};
		
	}
})();