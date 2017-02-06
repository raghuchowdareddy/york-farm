(function() {
	'use strict';
	
	angular.module('app').controller('CheckoutController', CheckoutController);
	CheckoutController.$inject = [ '$rootScope', '$location' ,'$scope','CheckoutService'];

	function CheckoutController($rootScope, $location,$scope,CheckoutService) {
		init();
		var checkoutCtrl = this;
		$scope.userContactInfo={};
		$scope.userOrder={};
		if(angular.isUndefined($rootScope.globals.currentUser)){
			$scope.userContactInfo.contactNumber ="";
		}else{
			$scope.userContactInfo.contactNumber = $rootScope.globals.currentUser.username;
		}
		checkoutCtrl.saveOrder = saveOrder;
		checkoutCtrl.fetchOrders = fetchOrders;
		checkoutCtrl.cancelOrder = cancelOrder;
		checkoutCtrl.calculateTotalPriceAndQuantity = calculateTotalPriceAndQuantity;
		
		function init(){
			var user;
			if(angular.isUndefined($rootScope.globals.currentUser)){
				 user = "";
			}else{
				user = $rootScope.globals.currentUser.username;
			}
			fetchOrders(user);
		}
		function saveOrder(){
			$scope.userOrder.items=[];
			angular.forEach($rootScope.selectedProductItems, function(item,key){
				item.status = 'ordered';
				//$scope.userOrder.items.push(item);
			});
			
			$scope.userOrder.userContactInfo=$scope.userContactInfo;
			$scope.userOrder.items=$rootScope.selectedProductItems;
			$scope.userOrder.status='ordered';
			if(!angular.isUndefined($rootScope.globals.currentUser.username)){
				$scope.userOrder.userName=$rootScope.globals.currentUser.username;
			}
			calculateTotalPriceAndQuantity($scope.userOrder.items);
			CheckoutService.saveOrder($scope.userOrder).then(function(res){
				fetchOrders($scope.userOrder.userName);
				$rootScope.selectedProductItems=[];
			})
		}
		function fetchOrders(username){
				CheckoutService.fetchOrders(username).then(function(response){
					$scope.userOrders = response.data;
				});
		}
		function calculateTotalPriceAndQuantity(items){
			var totalKgs = 0;
			var totalPrice = 0;
			angular.forEach(items,function(item,key){
				totalKgs+=item.quantity;
				totalPrice+=(item.price*item.quantity);
			});
			$scope.userOrder.price = totalPrice;
			$scope.userOrder.quantity = totalKgs;
		}
		
	 function cancelOrder(order,index){
		 
	 }
	}
})();