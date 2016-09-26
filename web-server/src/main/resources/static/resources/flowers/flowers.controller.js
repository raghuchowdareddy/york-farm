(function() {
	'use strict';
	
	angular.module('app').controller('FlowerController', FlowerController);
	FlowerController.$inject = ['FlowerService'];
	
	function FlowerController(FlowerService) {
		var flowerCtrl = this;
		flowerCtrl.flowers = [];
		initController();
		
		function initController() {
			flowerCtrl.flowers = FlowerService.getAll();
		}
	}
})();
