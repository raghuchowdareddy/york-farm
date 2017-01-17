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
        service.getDraftedProductsByUser = getDraftedProductsByUser;
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
        function getDraftedProductsByUser(userMobileNo){
        	return $http.get('/getDraftedItems/'+userMobileNo);
        }
        
        function getFlowers() {
			return [
			        {'id':1, 'name':'Rose', 'description':'I am rose!!!', 'price':10.0, 'imageName':'roses.jpg','quantity':1.0},
			        {'id':2, 'name':'Jasmine', 'description':'I am jasmine!!!', 'price':10.0, 'imageName':'jasmines.jpg','quantity':1.0},
					{'id':3, 'name':'Rose', 'description':'I am rose!!!', 'price':10.0, 'imageName':'roses.jpg','quantity':1.0},
					{'id':4, 'name':'Jasmine', 'description':'I am jasmine!!!', 'price':10.0, 'imageName':'jasmines.jpg','quantity':1.0},
					{'id':5, 'name':'Rose', 'description':'I am rose!!!', 'price':10.0, 'imageName':'roses.jpg','quantity':1.0},
					{'id':6, 'name':'Jasmine', 'description':'I am jasmine!!!', 'price':10.0, 'imageName':'jasmines.jpg','quantity':1.0},
					{'id':7, 'name':'Rose', 'description':'I am rose!!!', 'price':10.0, 'imageName':'roses.jpg','quantity':1.0},
					{'id':8, 'name':'Jasmine', 'description':'I am jasmine!!!', 'price':10.0, 'imageName':'jasmines.jpg','quantity':1.0},
					{'id':9, 'name':'Rose', 'description':'I am rose!!!', 'price':10.0, 'imageName':'roses.jpg','quantity':1.0}
				];
		}
        
        function getFruits() {
			return [
			        {'id':1, 'name':'Apple', 'description':'I am apple!!!', 'price':10.0, 'imageName':'apples.jpg','quantity':1.0},
			        {'id':2, 'name':'Banana', 'description':'I am banana!!!', 'price':10.0, 'imageName':'bananas.jpg','quantity':1.0},
					{'id':3, 'name':'Orange', 'description':'I am orange!!!', 'price':10.0, 'imageName':'oranges.jpg','quantity':1.0},
					{'id':4, 'name':'Banana', 'description':'I am banana!!!', 'price':10.0, 'imageName':'bananas.jpg','quantity':1.0},
					{'id':5, 'name':'Orange', 'description':'I am orange!!!', 'price':10.0, 'imageName':'oranges.jpg','quantity':1.0},
					{'id':6, 'name':'Apple', 'description':'I am apple!!!', 'price':10.0, 'imageName':'apples.jpg','quantity':1.0},
					{'id':7, 'name':'Orange', 'description':'I am orange!!!', 'price':10.0, 'imageName':'oranges.jpg','quantity':1.0},
					{'id':8, 'name':'Apple', 'description':'I am apple!!!', 'price':10.0, 'imageName':'apples.jpg','quantity':1.0},
					{'id':9, 'name':'Banana', 'description':'I am banana!!!', 'price':10.0, 'imageName':'bananas.jpg','quantity':1.0}
				];
		}
        
        function getVegetables() {
			return [
			        {'id':1, 'name':'Tomato', 'description':'I am tomato!!!', 'price':10.0, 'imageName':'tomatoes.jpg','quantity':1.0},
			        {'id':2, 'name':'Potato', 'description':'I am potato!!!', 'price':10.0, 'imageName':'potatoes.jpg','quantity':1.0},
					{'id':3, 'name':'Onion', 'description':'I am onion!!!', 'price':10.0, 'imageName':'onion.jpg','quantity':1.0},
					{'id':4, 'name':'Potato', 'description':'I am potatos!!!', 'price':10.0, 'imageName':'potatoes.jpg','quantity':1.0},
					{'id':5, 'name':'Onion', 'description':'I am onion!!!', 'price':10.0, 'imageName':'onion.jpg','quantity':1.0},
					{'id':6, 'name':'Tomato', 'description':'I am tomato!!!', 'price':10.0, 'imageName':'tomatoes.jpg','quantity':1.0},
					{'id':7, 'name':'Onion', 'description':'I am onion!!!', 'price':10.0, 'imageName':'onion.jpg','quantity':1.0},
					{'id':8, 'name':'Tomato', 'description':'I am tomato!!!', 'price':10.0, 'imageName':'tomatoes.jpg','quantity':1.0},
					{'id':9, 'name':'Potato', 'description':'I am potatos!!!', 'price':10.0, 'imageName':'potatoes.jpg','quantity':1.0}
				];
		}
    }
})();