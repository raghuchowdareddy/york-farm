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
		
		function init() {
			$rootScope.subTotal = 0;
			$rootScope.totalQuantity = 0;
			if(!angular.isUndefined($cookieStore.get('globals'))) {
				UserService.getDraftedProductsByUsername($cookieStore.get('globals').currentUser.username).then(function(response) {
					angular.forEach(response.data.orderedItems, function(item, key) {
						$rootScope.selectedProductItems.push({
							'productId': item.productId,
							'productName': item.productName,
							'price': item.price,
							'quantity': item.quantity
						});
					});
				})
			}
			angular.forEach($rootScope.selectedProductItems, function(item, key) {
				$rootScope.subTotal = $rootScope.subTotal + (item.price * item.quantity);
				$rootScope.totalQuantity = $rootScope.totalQuantity + item.quantity;
			});
		}
		
		function add(item) {
			var currentQuantity = item.quantity;
			item.quantity = currentQuantity + 1;
			$rootScope.subTotal = $rootScope.subTotal + (item.price * item.quantity);
			$rootScope.totalQuantity = $rootScope.totalQuantity + 1;
		}
		
		function substract(item) {
			var currentQuantity = item.quantity;
			if(currentQuantity == 1){
				alert("Quantity should not be 0!!");
				return;
			}
			item.quantity = currentQuantity - 1;
			$rootScope.subTotal = $rootScope.subTotal + (item.price * item.quantity);
			$rootScope.totalQuantity = $rootScope.totalQuantity - 1;
		}
		
		function deleteItem(item, index) {
			CartService.deleteDraft(item).then(function(response) {
				if (response) {
					$rootScope.subTotal = $rootScope.subTotal - (item.price * item.quantity);
					$rootScope.selectedProductItems.splice(index, 1);
					$rootScope.totalQuantity = $rootScope.totalQuantity - item.quantity;
					FlashService.success('Registration successful', true);
				}
			});
		}
		
		function saveDraft() {
			if(angular.isUndefined($cookieStore.get('globals'))) {
				$rootScope.currentLocation = $location.path();
				swal("Request...", "Please login or register before draft or save your items ", "error");
				$location.path('/login');
				return;
			}
			$scope.userOrder = [{
				'userId': $rootScope.user.userId,
				'userName': $rootScope.user.name,
				'mobileNumber': $rootScope.user.mobileNo,
				'emailAddress': $rootScope.user.emailId,
				'orderedItems': $rootScope.selectedProductItems
			}];
			console.log(JSON.stringify($scope.userOrder));
			UserService.saveDraftedProducts($scope.userOrder).then(function(response) {
				if (response) {
            		$location.path('/#');
            	} else {
            		FlashService.error(response.message);
            	}
				UserService.getDraftedProductsByUsername($cookieStore.get('globals').currentUser.username).then(function(response) {
					$rootScope.selectedProductItems = response.data;
				});
			});
		}
	}
	
})();