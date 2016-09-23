(function() {
	'use strict';
	angular.module('app').factory('FlowerService', FlowerService);
	FlowerService.$inject = ['$http'];
	
	function FlowerService($http) {
		var service = {};
		service.getAll = getAll;
		return service;
		
		function getAll() {
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
	}
})();