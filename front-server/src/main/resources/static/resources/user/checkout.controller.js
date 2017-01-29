(function() {
	'use strict';
	
	angular.module('app').controller('CheckoutController', CheckoutController);
	CheckoutController.$inject = [ '$rootScope', '$location' ,'$scope','CheckoutService'];

	function CheckoutController($rootScope, $location,$scope,CheckoutService) {
		var checkoutCtrl = this;
		$scope.userContactInfo={};
		$scope.userOrder={};
		$scope.userContactInfo.contactNumber=$rootScope.globals.currentUser.username;
		
		
		checkoutCtrl.saveOrder = saveOrder;
		checkoutCtrl.fetchOrders = fetchOrders;
		
		function saveOrder(){
			angular.forEach($rootScope.selectedProductItems, function(item,key){
				item.status = 'ordered';
			});
			
			$scope.userOrder.userContactInfo=$scope.userContactInfo;
			$scope.userOrder.items=$rootScope.selectedProductItems;
			console.log(">>>"+angular.toJson($scope.userOrder));
			
			CheckoutService.saveOrder($scope.userOrder);
		}
		function fetchOrders(){
				CheckoutService.fetchOrders().then(function(response){
					console.log(angular.toJson(response));
				})
		}
	}
})();