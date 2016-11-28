(function () {
	'use strict';
	
    angular.module('app').factory('ProductService', ProductService);
    ProductService.$inject = ['$http'];
    
    function ProductService($http) {
    	var service = {};
        service.getAll = getAll;
        service.save = save;
        service.getByCategory = getByCategory;
        service.getFlowers = getFlowers;
        service.getFruits = getFruits;
        service.getVegetables = getVegetables;
        return service;
        
        function getAll() {
        	return $http.get('/api/inventory/product');
        }
        
        function save(product) {
        	return $http.post('/api/inventory/product', product);
        }
        
        function getByCategory(categoryName) {
        	return $http.get('/api/inventroy/product/' + categoryName);
        }
        
        function getFlowers() {
			return [
			        {'id':1, 'name':'Rose', 'description':'I am rose!!!', 'price':10.0, 'imageName':'roses.jpg'},
			        {'id':2, 'name':'Jasmine', 'description':'I am jasmine!!!', 'price':10.0, 'imageName':'jasmines.jpg'},
					{'id':3, 'name':'Rose', 'description':'I am rose!!!', 'price':10.0, 'imageName':'roses.jpg'},
					{'id':4, 'name':'Jasmine', 'description':'I am jasmine!!!', 'price':10.0, 'imageName':'jasmines.jpg'},
					{'id':5, 'name':'Rose', 'description':'I am rose!!!', 'price':10.0, 'imageName':'roses.jpg'},
					{'id':6, 'name':'Jasmine', 'description':'I am jasmine!!!', 'price':10.0, 'imageName':'jasmines.jpg'},
					{'id':7, 'name':'Rose', 'description':'I am rose!!!', 'price':10.0, 'imageName':'roses.jpg'},
					{'id':8, 'name':'Jasmine', 'description':'I am jasmine!!!', 'price':10.0, 'imageName':'jasmines.jpg'},
					{'id':9, 'name':'Rose', 'description':'I am rose!!!', 'price':10.0, 'imageName':'roses.jpg'}
				];
		}
        
        function getFruits() {
			return [
			        {'id':1, 'name':'Apple', 'description':'I am apple!!!', 'price':10.0, 'imageName':'apples.jpg'},
			        {'id':2, 'name':'Banana', 'description':'I am banana!!!', 'price':10.0, 'imageName':'bananas.jpg'},
					{'id':3, 'name':'Orange', 'description':'I am orange!!!', 'price':10.0, 'imageName':'oranges.jpg'},
					{'id':4, 'name':'Banana', 'description':'I am banana!!!', 'price':10.0, 'imageName':'bananas.jpg'},
					{'id':5, 'name':'Orange', 'description':'I am orange!!!', 'price':10.0, 'imageName':'oranges.jpg'},
					{'id':6, 'name':'Apple', 'description':'I am apple!!!', 'price':10.0, 'imageName':'apples.jpg'},
					{'id':7, 'name':'Orange', 'description':'I am orange!!!', 'price':10.0, 'imageName':'oranges.jpg'},
					{'id':8, 'name':'Apple', 'description':'I am apple!!!', 'price':10.0, 'imageName':'apples.jpg'},
					{'id':9, 'name':'Banana', 'description':'I am banana!!!', 'price':10.0, 'imageName':'bananas.jpg'}
				];
		}
        
        function getVegetables() {
			return [
			        {'id':1, 'name':'Tomato', 'description':'I am tomato!!!', 'price':10.0, 'imageName':'tomatoes.jpg'},
			        {'id':2, 'name':'Potato', 'description':'I am potato!!!', 'price':10.0, 'imageName':'potatoes.jpg'},
					{'id':3, 'name':'Onion', 'description':'I am onion!!!', 'price':10.0, 'imageName':'onion.jpg'},
					{'id':4, 'name':'Potato', 'description':'I am potatos!!!', 'price':10.0, 'imageName':'potatoes.jpg'},
					{'id':5, 'name':'Onion', 'description':'I am onion!!!', 'price':10.0, 'imageName':'onion.jpg'},
					{'id':6, 'name':'Tomato', 'description':'I am tomato!!!', 'price':10.0, 'imageName':'tomatoes.jpg'},
					{'id':7, 'name':'Onion', 'description':'I am onion!!!', 'price':10.0, 'imageName':'onion.jpg'},
					{'id':8, 'name':'Tomato', 'description':'I am tomato!!!', 'price':10.0, 'imageName':'tomatoes.jpg'},
					{'id':9, 'name':'Potato', 'description':'I am potatos!!!', 'price':10.0, 'imageName':'potatoes.jpg'}
				];
		}
    }
})();