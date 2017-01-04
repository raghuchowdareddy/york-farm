(function () {
	'use strict';
	
    angular.module('app').factory('InventoryService', InventoryService);
    InventoryService.$inject = ['$http'];
    
    function InventoryService($http) {
    	var service = {};
    	service.getAllCategories = getAllCategories;
    	service.saveCategory = saveCategory;
    	service.getAllProducts = getAllProducts;
    	service.saveProduct = saveProduct;
        return service;
        
        function getAllCategories() {
        	return $http.get('/api/inventoryservice/category');
        }
        
        function saveCategory(category) {
        	return $http.post('/api/inventoryservice/category', category);
        }
        
        function getAllProducts() {
        	return $http.get('/api/inventoryservice/product');
        }
        
        function saveProduct(product) {
        	return $http.post('/api/inventoryservice/product', product);
        }
    }
})();
