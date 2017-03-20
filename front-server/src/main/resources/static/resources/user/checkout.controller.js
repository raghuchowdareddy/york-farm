(function() {
	'use strict';
	
	angular.module('app').controller('CheckoutController', CheckoutController);
	CheckoutController.$inject = [ '$rootScope', '$location' , '$scope', 'UserService'];

	function CheckoutController($rootScope, $location, $scope, UserService) {
		init();
		$scope.shippingCost = 5.00;
		$scope.tax = 5.00;
		var checkoutCtrl = this;
		checkoutCtrl.locations = [];
		checkoutCtrl.landmarksByLocation = landmarksByLocation;
		checkoutCtrl.landmarks = [];
		checkoutCtrl.saveOrder = saveOrder;
		
		function init() {
			$scope.subTotal = 0;
			angular.forEach($rootScope.selectedProductItems, function(item, key) {
				$scope.subTotal = $scope.subTotal + (item.price * item.quantity);
			});
			UserService.getLocationsByCity().then(function(response) {
				checkoutCtrl.locations = response.data;
			});
		}
		
		function landmarksByLocation() {
			UserService.getDeliveryLocationsByLocation(checkoutCtrl.locationId).then(function(response) {
				checkoutCtrl.landmarks = response.data;
			});
		}
		
		function saveOrder() {
			$scope.order = [{
				'orderId': $rootScope.userOrder.orderId,
				'status': $rootScope.userOrder.status,
				'userId': $rootScope.user.userId,
				'userName': $rootScope.user.name,
				'mobileNumber': $rootScope.user.mobileNo,
				'emailAddress': $rootScope.user.emailId,
				'orderedItems': $rootScope.selectedProductItems,
				'deliveryLocationId': checkoutCtrl.landmark,
				'createdDate': $rootScope.userOrder.createdDate
			}];
			UserService.saveOrderedProducts($scope.order).then(function(response) {
           		$location.path('/#');
			});
		}
	}
})();