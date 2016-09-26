(function() {
	'use strict';
	angular.module('app').controller('BaggeditemsController', BaggeditemsController);
	BaggeditemsController.$inject = ['$rootScope'];
	
	
	function BaggeditemsController( $rootScope) {
		var vm = this;
		vm.allBaggedItems=[];
		initController();
		vm.show = show;
		function initController() {
			vm.allBaggedItems = $rootScope.selectedVegetables;
		}
		function show(){
			console.log("ghdslgjdsgj");
		}
		
	}
})();