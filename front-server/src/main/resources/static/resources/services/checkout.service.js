(function () {
	'use strict';
	
    angular.module('app').factory('CheckoutService', CheckoutService);
    CheckoutService.$inject = ['$http'];
    
    function CheckoutService($http) {
    	var service = {};
        service.saveOrder = saveOrder;
        service.fetchOrders = fetchOrders;
        service.cancelOrder = cancelOrder;
        service.loadAllCities = loadAllCities;
        service.loadLocations = loadLocations;
        service.loadLocation = loadLocation;
        service.loadLandMarks = loadLandMarks;
        return service;
        
        function saveOrder(order) {
        	console.log(order);
        	return $http.post('/orderItems',order);
        }
        function cancelOrder(order){
        	return $http.post('/cancelOrder/'+order.userOrderId);
        }
        function fetchOrders(username){
        	return $http.get('/fetchOrdersByUserName/'+username);
        }
        function loadAllCities(){
        	console.log("local cities...")
        	return $http.get('/api/userservice/region/cities/Karnataka');
        }
        function loadLocations(){
        	return $http.get('/api/userservice/region/locations/Bangalore')
        }
        function loadLocation(id){
        	return $http.get('/api/userservice/region/location/'+id)
        }
        function loadLandMarks(locationid){
        	return $http.get('/api/userservice/region/locationlandmarks/'+locationid)
        }
        
       
    }
})();