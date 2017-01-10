(function() {
	'use strict';
	
	angular.module('app').controller('CartController', CartController);
	CartController.$inject = [ '$rootScope','$scope', '$location' ,'$window','CartService','FlashService'];

	function CartController($rootScope, $scope,$location,$window,CartService,FlashService) {
		init();
		$scope.shippingCost=5.00;
		$scope.tax=5.00;
	
		var cartCtrl = this;
		cartCtrl.add = add;
		cartCtrl.substract = substract;
		cartCtrl.deleteItem = deleteItem;
		cartCtrl.saveDraft = saveDraft;
		
		
		function init(){
			
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
		function saveDraft(){
			$scope.user =[];
			var log = [];
			$scope.userSelectedItems = [];
//			$scope.cart={'user':$scope.user,'userSelectedItem':$rootScope.selectedProductItems,
//					'shippingCost':$scope.shippingCost,"tax":$scope.tax,'subTotal':$rootScope.subTotal};
			angular.forEach($rootScope.selectedProductItems, function(item,key){
				$scope.userSelectedItems.push({'userMobileNo':1234567890,'itemName':item.name,
					'costPerKg':item.price,'quantity':item.quantity,'isDrafted':1})
				console.log($scope.userSelectedItems);
			},log);
			
			CartService.saveDraft($scope.userSelectedItems).then(function(response){
				if (response) {
					console.log("cart response");
            		FlashService.success('Registration successful', true);
            		$location.path('/#');
            	} else {
            		console.log("cart response false");
            		FlashService.error(response.message);
            		registerCtrl.dataLoading = false;
            	}
			})
			
		}
	}
	
})();