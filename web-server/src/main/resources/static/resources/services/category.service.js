(function () {
	'use strict';
	
    angular.module('app').factory('CategoryService', CategoryService);
    CategoryService.$inject = ['$http'];
    
    function CategoryService($http) {
    	var service = {};
        service.getAll = getAll;
        service.save = save;
        return service;
        
        function getAll() {
        	return $http.get('/api/inventory/category');
        }
        
        function save(category) {
        	return $http.post('/api/inventory/category', category);
        }
    }
})();