(function() {
	'use strict';
	
	angular.module('app').controller('FriutController', FriutController);
	FriutController.$inject = ['FriutService'];
	
	function FriutController(FriutService) {
		var fritCtrl = this;
		fritCtrl.friuts = [];
		initController();
		
		function initController() {
			fritCtrl.friuts = FriutService.getAll();
		}
	}
})();
