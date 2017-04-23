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
			$scope.subTotal = 0;
			angular.forEach($rootScope.selectedProductItems, function(item, key) {
				$scope.subTotal = $scope.subTotal + (item.price * item.quantity);
			});
		}
		
		function add(item) {
			var currentQuantity = item.quantity;
			item.quantity = currentQuantity + 0.5;
			$scope.subTotal = $scope.subTotal + (item.price * item.quantity);
		}
		
		function substract(item) {
			var currentQuantity = item.quantity;
			if(currentQuantity == 1) {
				alert("Quantity should not be 0!!");
				return;
			}
			item.quantity = currentQuantity - 0.5;
			$scope.subTotal = $rootScope.subTotal + (item.price * item.quantity);
		}
		
		function deleteItem(item, index) {
			$scope.subTotal = $rootScope.subTotal - (item.price * item.quantity);
			$rootScope.selectedProductItems.splice(index, 1);
		}
		
		function saveDraft() {
			if(angular.isUndefined($cookieStore.get('globals'))) {
				$rootScope.currentLocation = $location.path();
				swal("Request...", "Please login or register before draft or save your items", "error");
				$location.path('/login');
				return;
			}
			if(angular.isUndefined($rootScope.selectedProductItems) || $rootScope.selectedProductItems.length == 0) {
				swal("Warning...", "Please fill your cart", "warning");
				return;
			}
			if(angular.isUndefined($rootScope.userOrder) || $rootScope.userOrder.length == 0) {
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
           		$location.path('/#');
			});
			UserService.getDraftedProductsByUsername($cookieStore.get('globals').currentUser.username).then(function(response) {
				$rootScope.selectedProductItems = response.data;
			});
		}
	}
	
})();