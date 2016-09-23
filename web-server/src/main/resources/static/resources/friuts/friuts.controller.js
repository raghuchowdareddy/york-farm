(function() {
	'use strict';
	angular.module('app').controller('FriutController', FriutController);
	FriutController.$inject = ['FriutService'];
	
	function FriutController(FriutService) {
		var vm = this;
		vm.friuts = [];
		initController();
		
		function initController() {
			vm.friuts = FriutService.getAll();
		}
	}
})();