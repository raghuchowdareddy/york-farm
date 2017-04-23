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
		$scope.userOrders = {};
		checkoutCtrl.saveOrder = saveOrder;
		checkoutCtrl.userDetail = {};
		checkoutCtrl.openItemsWindow = openItemsWindow;
		checkoutCtrl.cancelOrder = cancelOrder;
		checkoutCtrl.loadDraftedProducts = loadDraftedProducts;
		
		function init() {
			loadDraftedProducts();
			$scope.subTotal = 0;
			$scope.totalQuantity = 0;
			angular.forEach($rootScope.selectedProductItems, function(item, key) {
				$scope.subTotal = $scope.subTotal + (item.price * item.quantity);
				$scope.totalQuantity = $scope.totalQuantity + item.quantity;
			});
			UserService.getLocationsByCity().then(function(response) {
				checkoutCtrl.locations = response.data;
			});
			UserService.getOrderedProductsByUsername($cookieStore.get('globals').currentUser.username).then(function(response) {
				$scope.userOrders = response.data;
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
			}
			if(angular.isUndefined($rootScope.userOrder) || $rootScope.userOrder.length == 0) {
				$scope.order = [{
					'userId': $rootScope.user.userId,
					'userName': $rootScope.user.name,
					'mobileNumber': $rootScope.user.mobileNo,
					'emailAddress': $rootScope.user.emailId,
					'orderedItems': $rootScope.selectedProductItems,
					'deliveryLocationId': checkoutCtrl.landmark
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
					'deliveryLocationId': checkoutCtrl.landmark,
					'draftedDate': $rootScope.userOrder.draftedDate
			
				}];
			}
			UserService.saveOrderedProducts($scope.order).then(function(response) {
				UserService.getOrderedProductsByUsername($cookieStore.get('globals').currentUser.username).then(function(response) {
					$scope.userOrders = response.data;
				});
				$rootScope.selectedProductItems=[];
           		//$location.path('/#');
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
	

		
		function openItemsWindow(order) {
			$scope.order = order;
			$(document).ready(function() {
		        $("#myModal").modal('show');
		    });
		}
		
		function cancelOrder(order, index) {
			$scope.order = [{
				'orderId': order.orderId,
				'status': order.status,
				'userId': order.userId,
				'userName': order.userName,
				'mobileNumber': order.mobileNumber,
				'emailAddress': order.emailAddress,
				'orderedItems': $rootScope.selectedProductItems,
				'deliveryLocationId': order.deliveryLocationId,
				'draftedDate': order.draftedDate,
				'orderedDate': order.orderedDate
			}];
		    var message = confirm("Are you sure you want to delete order!!");
		    if (message == true) {
				UserService.cancelOrderedProducts($scope.order);
				checkoutCtrl.orders.splice(index,1);
		    } else {
		        return;
		    }
		}
	}
})();