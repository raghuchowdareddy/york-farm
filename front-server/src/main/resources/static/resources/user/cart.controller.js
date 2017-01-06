(function() {
	'use strict';
	
	angular.module('app').controller('CartController', CartController);
	CartController.$inject = [ '$rootScope','$scope', '$location' ];

	function CartController($rootScope, $scope,$location) {
		var cartCtrl = this;
		cartCtrl.add = add;
		cartCtrl.substract = substract;
		init();
		function init(){
		//do something
		}
		function add(item){
			var currentQuantity = item.quantity;
			item.quantity = currentQuantity + 1;
			item.totalPrice = item.price*item.quantity;
		}
		function substract(item){
			var currentQuantity = item.quantity;
			if(currentQuantity==1){
				alert("Quantity should not be 0!!");
				return;
			}
			item.quantity = currentQuantity - 1;
			item.totalPrice = item.price*item.quantity;
		}
	}
	
})();