(function() {
	'use strict';
	
	angular.module('app').controller('CartController', CartController);
	CartController.$inject = [ '$rootScope', '$scope', '$cookieStore', '$location' ,'$window', 'UserService', 'FlashService'];

	function CartController($rootScope, $scope, $cookieStore, $location, $window, UserService, FlashService) {
		init();
		$scope.shippingCost = 5.00;
		$scope.tax = 5.00;	
		var cartCtrl = this;
		cartCtrl.add = add;
		cartCtrl.substract = substract; 
		cartCtrl.deleteItem = deleteItem;
		cartCtrl.saveDraft = saveDraft;
		cartCtrl.checkout = checkout;
		cartCtrl.loadDraftedProducts = loadDraftedProducts;
		
		function init() {
			loadDraftedProducts();
			$scope.subTotal = 0;
			angular.forEach($rootScope.selectedProductItems, function(item, key) {
				$scope.subTotal = $scope.subTotal + (item.price * item.quantity);
			});
		}
		
		function add(item) {
			var currentQuantity = item.quantity;
			item.quantity = currentQuantity + 0.5;
			$scope.subTotal = $scope.subTotal + (item.price * 0.5);
		}
//		function add(item){
//			var currentQuantity = item.quantity;
//			item.quantity = currentQuantity + 0.5;
//			item.totalPrice = item.price*item.quantity;
//			$rootScope.subTotal = $rootScope.subTotal+item.price;
//			$rootScope.totalQuantity = $rootScope.totalQuantity+ 1;
//		}
		
		function substract(item) {
			var currentQuantity = item.quantity;
			if(currentQuantity == 1) {
				alert("Quantity should not be 0!!");
				return;
			}
			item.quantity = currentQuantity - 0.5;
			$scope.subTotal = $scope.subTotal - (item.price * 0.5);
		}
		
		function deleteItem(item, index) {
			$scope.subTotal = $scope.subTotal - (item.price * item.quantity);
			$rootScope.selectedProductItems.splice(index, 1);
		}
		
		function checkout(){
			if(angular.isUndefined($cookieStore.get('globals'))) {
				$rootScope.currentLocation = $location.path();
				swal("Request...", "Please login or register before draft or save your items", "error");
				$location.path('/login');
				return;
			}else{
				$location.path('/checkout');
			}
		}
		
		function saveDraft() {
			if(angular.isUndefined($cookieStore.get('globals'))) {
				$rootScope.currentLocation = $location.path();
				swal("Request...", "Please login or register before draft or save your items", "error");
				$location.path('/login');
				return;
			}
			else if(angular.isUndefined($rootScope.selectedProductItems) || $rootScope.selectedProductItems.length == 0) {
				swal("Warning...", "Please fill your cart", "warning");
				return;
			}
			else if(angular.isUndefined($rootScope.userOrder) || $rootScope.userOrder.length == 0) {
				$scope.order = [{
					'userId': $rootScope.user.userId,
					'userName': $rootScope.user.name,
					'mobileNumber': $rootScope.user.mobileNo,
					'emailAddress': $rootScope.user.emailId,
					'orderedItems': $rootScope.selectedProductItems
				}];
			} else {
				$scope.order = [{
					'orderId': $rootScope.userOrder.orderId,
					'status': $rootScope.userOrder.status,
					'userId': $rootScope.user.userId,
					'userName': $rootScope.user.name,
					'mobileNumber': $rootScope.user.mobileNo,
					'emailAddress': $rootScope.user.emailId,
					'orderedItems': $rootScope.selectedProductItems,
					'draftedDate': $rootScope.userOrder.draftedDate
				}];
			}
			UserService.saveDraftedProducts($scope.order).then(function(response) {
           		//$location.path('/#');
				UserService.getDraftedProductsByUsername($cookieStore.get('globals').currentUser.username).then(function(response) {
					$rootScope.userOrder = response.data;
					$rootScope.selectedProductItems = [];
					angular.forEach($rootScope.userOrder.orderedItems, function(item, key) {
						$rootScope.selectedProductItems.push({
							'productId': item.productId,
							'productName': item.productName,
							'price': item.price,
							'quantity': item.quantity
						});
					});
				});
				console.log(" orders drafted successfully");
			});
			
		}
		function loadDraftedProducts(){
			if(angular.isUndefined($rootScope.selectedProductItems) || $rootScope.selectedProductItems.length == 0) {
				$rootScope.selectedProductItems = [];
				UserService.getDraftedProductsByUsername($cookieStore.get('globals').currentUser.username).then(function(response) {
					$rootScope.userOrder = response.data;
					angular.forEach($rootScope.userOrder.orderedItems, function(item, key) {
						$rootScope.selectedProductItems.push({
							'productId': item.productId,
							'productName': item.productName,
							'price': item.price,
							'quantity': item.quantity
						});
					});
				});
			}
			
		}
	}
	
})();