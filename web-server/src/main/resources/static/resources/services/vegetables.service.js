(function() {
	'use strict';
	
	angular.module('app').factory('VegetableService', VegetableService);
	VegetableService.$inject = ['$http'];
	
	function VegetableService($http) {
		var service = {};
		service.getAll = getAll;
		return service;
		
		function getAll() {
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