(function() {
	'use strict';
	angular.module('app').factory('FriutService', FriutService);
	FriutService.$inject = ['$http'];
	
	function FriutService($http) {
		var service = {};
		service.getAll = getAll;
		return service;
		
		function getAll() {
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
	}
})();