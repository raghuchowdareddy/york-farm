(function() {
	'use strict';
	
	angular.module('app').controller('CartController', CartController);
	CartController.$inject = [ '$rootScope', '$location' ];

	function CartController($rootScope, $location) {
		var cartCtrl = this;
	}
})();