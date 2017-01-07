(function() {
	'use strict';
	
	angular.module('app').controller('CartController', CartController);
	CartController.$inject = [ '$rootScope','$scope', '$location' ,'$window'];

	function CartController($rootScope, $scope,$location,$window) {
		init();
		$scope.shippingCost=5.00;
		$scope.tax=5.00;
		var cartCtrl = this;
		cartCtrl.add = add;
		cartCtrl.substract = substract;
		cartCtrl.deleteItem = deleteItem;
		
		function init(){
		//do something
		}
		function add(item){
			var currentQuantity = item.quantity;
			item.quantity = currentQuantity + 1;
			item.totalPrice = item.price*item.quantity;
			$rootScope.subTotal = $rootScope.subTotal+item.price;
		}
		function substract(item){
			var currentQuantity = item.quantity;
			if(currentQuantity==1){
				alert("Quantity should not be 0!!");
				return;
			}
			item.quantity = currentQuantity - 1;
			item.totalPrice = item.price*item.quantity;
			$rootScope.subTotal = $rootScope.subTotal-item.price;
		}
		function deleteItem(item,index){
			var deleteItem = $window.confirm('Are you sure you want to delete '+item.name+"!!");
			if(deleteItem){
				$rootScope.subTotal = $rootScope.subTotal-item.totalPrice;
				$rootScope.selectedProductItems.splice(index,1);
				
			}
			console.log($rootScope.selectedProductItems);
		}
	}
	
})();