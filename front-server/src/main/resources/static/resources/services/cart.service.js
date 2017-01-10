(function () {
	'use strict';
	
    angular.module('app').factory('CartService', CartService);
    CartService.$inject = ['$http'];
    
    function CartService($http) {
    	var service = {};
        service.saveDraft = saveDraft;
        service.saveOrder = saveOrder;
        
        return service;
        
        function saveDraft(draftItems) {
        	console.log(draftItems);
        	return $http.post('/draftSelectedItems',draftItems);
        	//return $http.get('/api/inventory/product');
        }
        	
        function saveOrder(orderItem) {
        	console.log(orderItem);
        	//return $http.post('/api/inventory/product', product);
        }
       
    }
})();