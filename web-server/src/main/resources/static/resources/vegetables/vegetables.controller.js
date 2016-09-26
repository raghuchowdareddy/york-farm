(function() {
	'use strict';
	
	angular.module('app').controller('VegetableController', VegetableController);
	VegetableController.$inject = ['VegetableService','$rootScope','$q'];
	
	function VegetableController(VegetableService, $rootScope) {
		var vegetableCtrl = this;
		vegetableCtrl.vegetables = [];
		initController();
		
		function initController() {
			vegetableCtrl.vegetables = VegetableService.getAll();
		}
		
	}
})();