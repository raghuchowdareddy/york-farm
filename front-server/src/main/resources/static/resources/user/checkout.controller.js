(function() {
	'use strict';
	
	angular.module('app').controller('CheckoutController', CheckoutController);
	CheckoutController.$inject = [ '$rootScope', '$location' ];

	function CheckoutController($rootScope, $location) {
		var checkoutCtrl = this;
	}
})();