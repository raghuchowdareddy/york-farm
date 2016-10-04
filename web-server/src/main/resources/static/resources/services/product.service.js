(function () {
	'use strict';
	
    angular.module('app').factory('ProductService', ProductService);
    ProductService.$inject = ['$http'];
    
    function ProductService($http) {
    	var service = {};
        service.getAll = getAll;
        service.save = save;
        return service;
        
        function getAll() {
        	return $http.get('/api/inventory/product');
        }
        
        function save(product) {
        	return $http.post('/api/inventory/product', product);
        }
    }
})();