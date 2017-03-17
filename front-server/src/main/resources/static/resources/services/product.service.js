(function () {
	'use strict';
	
    angular.module('app').factory('ProductService', ProductService);
    ProductService.$inject = ['$http'];
    
    function ProductService($http) {
    	var service = {};
        service.getFlowers = getFlowers;
        service.getFruits = getFruits;
        service.getVegetables = getVegetables;
        return service;
        
        function getFlowers() {
        	return $http.get('/api/inventoryservice/catalog/weekly/category/Flowers');
			/*return [
			        {'id':1, 'name':'Rose', 'description':'I am rose!!!', 'price':10.0, 'imageName':'rose.jpg','quantity':1.0},
			        {'id':2, 'name':'Jasmine', 'description':'I am jasmine!!!', 'price':10.0, 'imageName':'jasmine.jpg','quantity':1.0},
					{'id':3, 'name':'Rose', 'description':'I am rose!!!', 'price':10.0, 'imageName':'rose.jpg','quantity':1.0},
					{'id':4, 'name':'Jasmine', 'description':'I am jasmine!!!', 'price':10.0, 'imageName':'jasmine.jpg','quantity':1.0},
					{'id':5, 'name':'Rose', 'description':'I am rose!!!', 'price':10.0, 'imageName':'rose.jpg','quantity':1.0},
					{'id':6, 'name':'Jasmine', 'description':'I am jasmine!!!', 'price':10.0, 'imageName':'jasmine.jpg','quantity':1.0},
					{'id':7, 'name':'Rose', 'description':'I am rose!!!', 'price':10.0, 'imageName':'rose.jpg','quantity':1.0},
					{'id':8, 'name':'Jasmine', 'description':'I am jasmine!!!', 'price':10.0, 'imageName':'jasmine.jpg','quantity':1.0},
					{'id':9, 'name':'Rose', 'description':'I am rose!!!', 'price':10.0, 'imageName':'rose.jpg','quantity':1.0}
				];*/
		}
        
        function getFruits() {
        	return $http.get('/api/inventoryservice/catalog/weekly/category/Fruits');
			/*return [
			        {'id':1, 'name':'Apple', 'description':'I am apple!!!', 'price':10.0, 'imageName':'apple.jpg','quantity':1.0},
			        {'id':2, 'name':'Banana', 'description':'I am banana!!!', 'price':10.0, 'imageName':'banana.jpg','quantity':1.0},
					{'id':3, 'name':'Orange', 'description':'I am orange!!!', 'price':10.0, 'imageName':'orange.jpg','quantity':1.0},
					{'id':4, 'name':'Banana', 'description':'I am banana!!!', 'price':10.0, 'imageName':'banana.jpg','quantity':1.0},
					{'id':5, 'name':'Orange', 'description':'I am orange!!!', 'price':10.0, 'imageName':'orange.jpg','quantity':1.0},
					{'id':6, 'name':'Apple', 'description':'I am apple!!!', 'price':10.0, 'imageName':'apple.jpg','quantity':1.0},
					{'id':7, 'name':'Orange', 'description':'I am orange!!!', 'price':10.0, 'imageName':'orange.jpg','quantity':1.0},
					{'id':8, 'name':'Apple', 'description':'I am apple!!!', 'price':10.0, 'imageName':'apple.jpg','quantity':1.0},
					{'id':9, 'name':'Banana', 'description':'I am banana!!!', 'price':10.0, 'imageName':'banana.jpg','quantity':1.0}
				];*/
		}
        
        function getVegetables() {
        	return $http.get('/api/inventoryservice/catalog/weekly/category/Vegetables');
			/*return [
			        {'id':1, 'name':'Tomato', 'description':'I am tomato!!!', 'price':10.0, 'imageName':'tomato.jpg','quantity':1.0},
			        {'id':2, 'name':'Potato', 'description':'I am potato!!!', 'price':10.0, 'imageName':'potato.jpg','quantity':1.0},
					{'id':3, 'name':'Onion', 'description':'I am onion!!!', 'price':10.0, 'imageName':'onion.jpg','quantity':1.0},
					{'id':4, 'name':'Potato', 'description':'I am potatos!!!', 'price':10.0, 'imageName':'potato.jpg','quantity':1.0},
					{'id':5, 'name':'Onion', 'description':'I am onion!!!', 'price':10.0, 'imageName':'onion.jpg','quantity':1.0},
					{'id':6, 'name':'Tomato', 'description':'I am tomato!!!', 'price':10.0, 'imageName':'tomato.jpg','quantity':1.0},
					{'id':7, 'name':'Onion', 'description':'I am onion!!!', 'price':10.0, 'imageName':'onion.jpg','quantity':1.0},
					{'id':8, 'name':'Tomato', 'description':'I am tomato!!!', 'price':10.0, 'imageName':'tomato.jpg','quantity':1.0},
					{'id':9, 'name':'Potato', 'description':'I am potatos!!!', 'price':10.0, 'imageName':'potato.jpg','quantity':1.0}
				];*/
		}
    }
})();