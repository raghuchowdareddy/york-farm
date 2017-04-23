(function () {
	'use strict';
	
    angular.module('app').factory('UserService', UserService);
    UserService.$inject = ['$http'];
    
    function UserService($http) {
    	var service = {};
        service.getByUsername = getByUsername;
        service.getDetailByUsername = getDetailByUsername;
        service.saveUser = saveUser;
        service.getDraftedProductsByUsername = getDraftedProductsByUsername;
        service.saveDraftedProducts = saveDraftedProducts;
        service.getOrderedProductsByUsername = getOrderedProductsByUsername;
        service.saveOrderedProducts = saveOrderedProducts;
        service.getLocationsByCity = getLocationsByCity;
        service.getDeliveryLocationsByLocation = getDeliveryLocationsByLocation;
        service.cancelOrderedProducts = cancelOrderedProducts;
        return service;
        
        function getByUsername(username) {
        	return $http.get('/api/userservice/user/loggedIn/' + username).success(function(data){
        		return data;
        	}).error(function(error){
        		swal("Warning..", "Username wrongly entered", "info");
        		return null;
        	});
        }
	    
	    function getDetailByUsername(username) {
	    	return $http.get('/api/userservice/user/' + username)
	    }
	    
	    function saveUser(user) {
	    	return $http.post('/api/userservice/user', user);
	    }
        
        function getDraftedProductsByUsername(username) {
        	return $http.get('/api/userservice/user/drafted/items/' + username);
        }
        
        function saveDraftedProducts(order) {
        	return $http.post('/api/userservice/user/drafted/items', order);
        }
        
        function getOrderedProductsByUsername(username) {
        	return $http.get('/api/userservice/user/ordered/items/' + username);
        }
        
        function saveOrderedProducts(order) {
        	return $http.post('/api/userservice/user/ordered/items', order);
        }
        
        function cancelOrderedProducts(order) {
        	return $http.post('/api/userservice/user/cancelled/items', order);
        }
        
        function getLocationsByCity() {
        	return $http.get('/api/userservice/region/locations/Bangalore');
        }
        
        function getDeliveryLocationsByLocation(locationId) {
        	return $http.get('/api/userservice/region/deliverylocations/location/' + locationId);
        }
        
        function getUserSelectedProductsByProduct(productId) {
        	return $http.get('/api/userservice/user/items/product/' + productId);
        }
    }
})();
