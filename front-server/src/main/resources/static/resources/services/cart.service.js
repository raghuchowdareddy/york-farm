(function () {
	'use strict';
	
    angular.module('app').factory('CartService', CartService);
    CartService.$inject = ['$http','$rootScope','$cookieStore','ProductService'];
    
    function CartService($http,$rootScope,$cookieStore,ProductService) {
    	var service = {};
        service.saveDraft = saveDraft;
        service.saveOrder = saveOrder;
        service.deleteDraft = deleteDraft;
        service.initCart = initCart;
        
        return service;
        
        function initCart(){
        	$rootScope.totalQuantity=0;
        	$rootScope.subTotal=0;
        	if(angular.isUndefined($rootScope.selectedProductItems) || $rootScope.selectedProductItems.length==0){
				if(!angular.isUndefined($cookieStore.get('globals'))){
					var obj = $cookieStore.get('globals');
					ProductService.getDraftedProductsByUser(obj.currentUser.username).then(function(response){
						$rootScope.selectedProductItems = response.data;
						angular.forEach($rootScope.selectedProductItems, function(item,key){
							item.totalPrice = item.price*item.quantity;
							$rootScope.subTotal = $rootScope.subTotal+item.totalPrice;
							$rootScope.totalQuantity = $rootScope.totalQuantity+item.quantity;
						});
					})
				}
			}
			else{
				angular.forEach($rootScope.selectedProductItems, function(item,key){
					item.totalPrice = item.price*item.quantity;
					$rootScope.subTotal = $rootScope.subTotal+item.totalPrice;
					$rootScope.totalQuantity = $rootScope.totalQuantity+item.quantity;
				});
			}
        }
        function saveDraft(draftItems) {
        	return $http.post('/draftSelectedItems',draftItems);
        	//return $http.get('/api/inventory/product');
        }
        function deleteDraft(deleteItem){
        	return $http.post('/deleteItem',deleteItem);
        }
        	
        function saveOrder(orderItem) {
        	console.log(orderItem);
        	//return $http.post('/api/inventory/product', product);
        }
       
    }
})();