(function() {
	'use strict';
	angular.module('app').controller('FlowerController', FlowerController);
	FlowerController.$inject = ['FlowerService'];
	
	function FlowerController(FlowerService) {
		var vm = this;
		vm.flowers = [];
		initController();
		
		function initController() {
			vm.flowers = FlowerService.getAll();
		}
	}
})();