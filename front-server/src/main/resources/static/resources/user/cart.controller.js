(function() {
	'use strict';
	
	angular.module('app').controller('CartController', CartController);
	CartController.$inject = [ '$rootScope','$scope','$cookieStore','$location' ,'$window','CartService','FlashService','ProductService'];

	function CartController($rootScope, $scope,$cookieStore,$location,$window,CartService,FlashService,ProductService) {
		init();
		$scope.shippingCost=5.00;
		$scope.tax=5.00;
	
		var cartCtrl = this;
		cartCtrl.add = add;
		cartCtrl.substract = substract;
		cartCtrl.deleteItem = deleteItem;
		cartCtrl.saveDraft = saveDraft;
		
		
		function init(){
			$rootScope.subTotal = 0;
			$rootScope.totalQuantity = 0;
			CartService.initCart();
		}
		function add(item){
			var currentQuantity = item.quantity;
			item.quantity = currentQuantity + 1;
			item.totalPrice = item.price*item.quantity;
			$rootScope.subTotal = $rootScope.subTotal+item.price;
			$rootScope.totalQuantity = $rootScope.totalQuantity+ 1;
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
			$rootScope.totalQuantity = $rootScope.totalQuantity-1;
		}
		function deleteItem(item,index){
			//var deleteItem = $window.confirm('Are you sure you want to delete '+item.name+"!!");
			//if(deleteItem){
			CartService.deleteDraft(item).then(function(response){
					if (response) {
						$rootScope.subTotal = $rootScope.subTotal-item.totalPrice;
						$rootScope.selectedProductItems.splice(index,1);
						$rootScope.totalQuantity = $rootScope.totalQuantity-item.quantity;
						FlashService.success('Registration successful', true);
	            	} else {
	            		console.log("cart response false");
	            	}
				})
			console.log($rootScope.selectedProductItems);
		}
		function saveDraft(){
			if(angular.isUndefined($cookieStore.get('globals'))){
				$rootScope.currentLocation = $location.path();
				console.log($rootScope.currentLocation);
				swal("Request...", "Please login or register before draft or save your items ", "error");
				$location.path('/login');
				return;
			}
			$scope.user =[];
			var log = [];
			$scope.userSelectItems = [];
			angular.forEach($rootScope.selectedProductItems, function(item,key){
				$scope.userSelectItems.push({'userSelectItemId':item.userSelectItemId,'userMobileNo':$rootScope.globals.currentUser.username,'itemName':item.name,
					'price':item.price,'quantity':item.quantity,'imageName':item.imageName,status:"drafted"})
			},log);
			
			CartService.saveDraft($scope.userSelectItems).then(function(response){
				if (response) {
					FlashService.success('Registration successful', true);
            		$location.path('/#');
            	} else {
            		FlashService.error(response.message);
            		registerCtrl.dataLoading = false;
            	}
				//reload drafted products from db
				ProductService.getDraftedProductsByUser($cookieStore.get('globals').currentUser.username).then(function(response){
						$rootScope.selectedProductItems = response.data;
				})
			})
			
		}
	}
	
})();