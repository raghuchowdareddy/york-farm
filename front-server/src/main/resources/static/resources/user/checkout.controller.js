(function() {
	'use strict';
	
	angular.module('app').controller('CheckoutController', CheckoutController);
	CheckoutController.$inject = [ '$rootScope', '$location' ,'$scope','CheckoutService'];

	function CheckoutController($rootScope, $location,$scope,CheckoutService) {
		var checkoutCtrl = this;
		$scope.userContactInfo={};
		$scope.userOrder={};
		
		$scope.userContactInfo.contactNumber=$rootScope.globals.currentUser.username;
		
		
		checkoutCtrl.saveOrder = saveOrder;
		checkoutCtrl.fetchOrders = fetchOrders;
		
		function saveOrder(){
			$scope.userOrder.items=[];
			angular.forEach($rootScope.selectedProductItems, function(item,key){
				item.status = 'ordered';
				//$scope.userOrder.items.push(item);
			});
			
			$scope.userOrder.userContactInfo=$scope.userContactInfo;
			$scope.userOrder.items=$rootScope.selectedProductItems;
			console.log(">>>"+angular.toJson($scope.userOrder));
			
//			var UserSelectedItem=[ 
//			                        {'userMobileNo':9686379363, 'itemName':'Onion', 'costPerKg':10, 
//			                         'quantity':1, 'createDat':'2017-01-29-17.18.39',
//			                        'status':'ordered', 'userSelectItemId':1}, 
//			                        {'userMobileNo':9686379363, 'itemName':'Onion', 'costPerKg':10, 
//				                         'quantity':1, 'createDat':'2017-01-29-17.18.39',
//				                        'status':'ordered', 'userSelectItemId':2}
//			          ]; 
//			$scope.userOrder.items=UserSelectedItem;                 
			    
			CheckoutService.saveOrder($scope.userOrder);
		}
		function fetchOrders(){
				CheckoutService.fetchOrders().then(function(response){
					console.log(angular.toJson(response));
				})
		}
	}
})();