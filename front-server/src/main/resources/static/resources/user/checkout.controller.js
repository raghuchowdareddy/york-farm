(function() {
	'use strict';
	
	angular.module('app').controller('CheckoutController', CheckoutController);
	CheckoutController.$inject = [ '$rootScope', '$location' , '$cookieStore', '$scope', 'UserService'];

	function CheckoutController($rootScope, $location, $cookieStore, $scope, UserService) {
		init();
		$scope.shippingCost = 5.00;
		$scope.tax = 5.00;
		if(angular.isUndefined($rootScope.selectedProductItems) || $rootScope.selectedProductItems.length == 0) {
			$rootScope.selectedProductItems = [];
		}
		var checkoutCtrl = this;
		checkoutCtrl.locations = [];
		checkoutCtrl.landmarksByLocation = landmarksByLocation;
		checkoutCtrl.landmarks = [];
		checkoutCtrl.orders = [];
		checkoutCtrl.saveOrder = saveOrder;
		checkoutCtrl.userDetail = {};
		checkoutCtrl.openItemsWindow = openItemsWindow;
		checkoutCtrl.cancelOrder = cancelOrder;
		checkoutCtrl.computeTotalAndQuantity = computeTotalAndQuantity;
		
		function init() {
			if(angular.isUndefined($cookieStore.get('globals'))) {
				$rootScope.currentLocation = $location.path();
				swal("Request...", "Please login or register before draft or save your items", "error");
				$location.path('/login');
				return;
			}
			$scope.subTotal = 0;
			$scope.totalQuantity = 0;
			computeTotalAndQuantity();
			UserService.getLocationsByCity().then(function(response) {
				checkoutCtrl.locations = response.data;
			});
			UserService.getOrderedProductsByUsername($cookieStore.get('globals').currentUser.username).then(function(response) {
					checkoutCtrl.orders = response.data;
			});
			UserService.getDraftedProductsByUsername($cookieStore.get('globals').currentUser.username).then(function(response) {
				if((response.data.length != 0) && ('DRAFTED'==response.data.status)){
				$scope.draftedOrder=response.data;
				angular.forEach(response.data.orderedItems, function(draftedItem){
					$rootScope.selectedProductItems.push({
						'productId': draftedItem.productId,
						'productName': draftedItem.productName,
						'price': draftedItem.price,
						'quantity': draftedItem.quantity
					});
				})
				computeTotalAndQuantity();
				}
			});
			
			
		}
		function computeTotalAndQuantity(){
			angular.forEach($rootScope.selectedProductItems, function(item, key) {
				$scope.subTotal = $scope.subTotal + (item.price * item.quantity);
				$scope.totalQuantity = $scope.totalQuantity + item.quantity;
			});
		}
		function landmarksByLocation() {
			UserService.getDeliveryLocationsByLocation(checkoutCtrl.locationId).then(function(response) {
				checkoutCtrl.landmarks = response.data;
			});
		}
		
		function saveOrder() {
			if(angular.isUndefined($rootScope.selectedProductItems) || $rootScope.selectedProductItems.length == 0) {
				swal("Warning...", "Please fill your cart", "warning");
				return;
			}
			if(angular.isUndefined(checkoutCtrl.locationId) || angular.isUndefined(checkoutCtrl.landmark)) {
				swal("Warning...", "Please fill your delivery location", "warning");
				return;
			}if(!angular.isUndefined($scope.draftedOrder) && $scope.draftedOrder.length !=0 ){
				$scope.order = [{
					'orderId': $scope.draftedOrder.orderId,
					'status': $scope.draftedOrder.status,
					'userId': $rootScope.user.userId,
					'userName': $rootScope.user.name,
					'mobileNumber': $rootScope.user.mobileNo,
					'emailAddress': $rootScope.user.emailId,
					'orderedItems': $rootScope.selectedProductItems,
					'deliveryLocationId': checkoutCtrl.landmark,
					'draftedDate': $scope.draftedOrder.draftedDate
				}];
				$scope.order.orderedItems= $rootScope.selectedProductItems;
			}
			else if(angular.isUndefined($scope.order) || $scope.order.length == 0) {
				$scope.order = [{
					'userId': $rootScope.user.userId,
					'userName': $rootScope.user.name,
					'mobileNumber': $rootScope.user.mobileNo,
					'emailAddress': $rootScope.user.emailId,
					'orderedItems': $rootScope.selectedProductItems,
					'deliveryLocationId': checkoutCtrl.landmark
				}];
			} 
			UserService.saveOrderedProducts($scope.order).then(function(response) {
           		$location.path('/#');
			});
		}
		
		function openItemsWindow(order) {
			$scope.order = order;
			$(document).ready(function() {
		        $("#myModal").modal('show');
		    });
		}
		
		function cancelOrder(order, index) {
			UserService.cancelOrderedProducts(order);
			checkoutCtrl.orders.splice(index,1);
		}
	}
})();