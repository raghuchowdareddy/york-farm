(function() {
	'use strict';
	
	angular.module('app').controller('DefaultController', DefaultController);
	DefaultController.$inject = [ '$rootScope','$scope', '$cookieStore','ProductService' ];
	
	function DefaultController($rootScope,$scope, $cookieStore,ProductService) {
		var defaultCtrl = this;
		defaultCtrl.flowers = [];
		defaultCtrl.fruits = [];
		defaultCtrl.vegetables = [];
		defaultCtrl.value=[];
		
		if(angular.isUndefined($rootScope.selectedProductItems) || $rootScope.selectedProductItems.length == 0){
			$rootScope.selectedProductItems = [];
			$rootScope.subTotal = 0.00;
		}
		initController();
		defaultCtrl.add2Cart = add2Cart;
	
		function initController() {
			defaultCtrl.flowers = ProductService.getFlowers();
			defaultCtrl.fruits = ProductService.getFruits();
			defaultCtrl.vegetables = ProductService.getVegetables();
			if(!angular.isUndefined($cookieStore.get('globals'))){
				var obj = $cookieStore.get('globals');
				var tempobj;
				var flag = false;
				ProductService.getDraftedProductsByUser(obj.currentUser.username).then(function(response){
					if(angular.isUndefined($rootScope.selectedProductItems) || $rootScope.selectedProductItems.length == 0){
						$rootScope.selectedProductItems = response.data;
					}
				})
			}
		}
		
		function add2Cart(selectedItem) {
			$rootScope.selectedProductItems.push(selectedItem);
			$rootScope.subTotal=$rootScope.subTotal+selectedItem.price;
		}
	}
})();