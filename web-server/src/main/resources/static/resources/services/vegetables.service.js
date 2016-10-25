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
			        {'id':1, 'name':'Tomato', 'description':'I am tomato!!!', 'priceperkg':10.0, 'imageName':'tomatoes.jpg','selectedQuantity':'0.5kg'},
			        {'id':2, 'name':'Potato', 'description':'I am potato!!!', 'priceperkg':10.0, 'imageName':'potatoes.jpg','selectedQuantity':'1.0kg'},
					{'id':3, 'name':'Onion', 'description':'I am onion!!!', 'priceperkg':10.0, 'imageName':'onion.jpg','selectedQuantity':'0.5kg'},
					{'id':4, 'name':'Potato', 'description':'I am potatos!!!', 'priceperkg':10.0, 'imageName':'potatoes.jpg','selectedQuantity':'0.5kg'},
					{'id':5, 'name':'Onion', 'description':'I am onion!!!', 'priceperkg':10.0, 'imageName':'onion.jpg','selectedQuantity':'0.5kg'},
					{'id':6, 'name':'Tomato', 'description':'I am tomato!!!', 'priceperkg':10.0, 'imageName':'tomatoes.jpg','selectedQuantity':'0.5kg'},
					{'id':7, 'name':'Onion', 'description':'I am onion!!!', 'priceperkg':10.0, 'imageName':'onion.jpg','selectedQuantity':'2.0kg'},
					{'id':8, 'name':'Tomato', 'description':'I am tomato!!!', 'priceperkg':10.0, 'imageName':'tomatoes.jpg','selectedQuantity':'3.0kg'},
					{'id':9, 'name':'Potato', 'description':'I am potatos!!!', 'priceperkg':10.0, 'imageName':'potatoes.jpg','selectedQuantity':'4.0kg'}
				];
		}
	}
})();