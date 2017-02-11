(function() {
	'use strict';
	
	angular.module('app').controller('CheckoutController', CheckoutController);
	CheckoutController.$inject = [ '$rootScope', '$location' ,'$scope','CheckoutService','CartService'];

	function CheckoutController($rootScope, $location,$scope,CheckoutService,CartService) {
		init();
		var checkoutCtrl = this;
		$scope.userContactInfo={};
		$scope.userOrder={};
		$scope.orderItems=[];
		if(angular.isUndefined($rootScope.globals.currentUser)){
			$scope.userContactInfo.contactNumber ="";
		}else{
			$scope.userContactInfo.contactNumber = $rootScope.globals.currentUser.username;
		}
		checkoutCtrl.saveOrder = saveOrder;
		checkoutCtrl.fetchOrders = fetchOrders;
		checkoutCtrl.cancelOrder = cancelOrder;
		checkoutCtrl.calculateTotalPriceAndQuantity = calculateTotalPriceAndQuantity;
		checkoutCtrl.loadCities = loadCities;
		checkoutCtrl.loadLocations = loadLocations;
		checkoutCtrl.openItemsWindow = openItemsWindow;
		checkoutCtrl.loadLandMarks = loadLandMarks;
		
		function init(){
			var user;
			if(angular.isUndefined($rootScope.globals.currentUser)){
				 user = "";
			}else{
				user = $rootScope.globals.currentUser.username;
			}
			CartService.initCart();//load cart details if any 
			if(angular.isUndefined($rootScope.selectedProductItems)){
				$rootScope.selectedProductItems=[];
			}
			loadCities();
			loadLocations();
			fetchOrders(user);
		}
		function loadCities(){
			CheckoutService.loadAllCities().then(function(res){
				$scope.cities = res.data;
			});
		}
		function loadLocations(){
			CheckoutService.loadLocations().then(function(res){
				$scope.locations = res.data;
			})
		}
		function loadLandMarks(){
			//$scope.userContactInfo.locationName = $scope.selectedLocation.locationName;
			CheckoutService.loadLandMarks($scope.userContactInfo.locationId).then(function(res){
				$scope.landMarks = res.data;
			})
		}
		function openItemsWindow(order){
			$scope.deliveryAddress = order.userContactInfo;
			$scope.orderItems = order.items;
			CheckoutService.loadLocation(order.userContactInfo.locationId).then(function(res){
				$scope.deliveryAddress.locationName = res.data.locationName;
				$(document).ready(function(){
					
			        $("#myModal").modal('show');
			    });
			})
			}
		function saveOrder(){
			$scope.userOrder.items=[];
			if($rootScope.selectedProductItems.length==0){
				return;
			}
			angular.forEach($rootScope.selectedProductItems, function(item,key){
				item.status = 'ordered';
			});
			$scope.userOrder.userContactInfo=$scope.userContactInfo;
			$scope.userOrder.items=$rootScope.selectedProductItems;
			$scope.userOrder.status='In Progress';
			
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
					if($scope.userOrders.length > 0){
						$scope.userContactInfo = $scope.userOrders[0].userContactInfo;
						loadLandMarks();
					}else{
						//load user contact info
					}
					
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
		 CheckoutService.cancelOrder(order).then(function(res){
			 $scope.userOrders.splice(index,1);
		 })
	 }
	}
})();