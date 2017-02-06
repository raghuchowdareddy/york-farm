(function () {
	'use strict';
	
    angular.module('app').factory('CheckoutService', CheckoutService);
    CheckoutService.$inject = ['$http'];
    
    function CheckoutService($http) {
    	var service = {};
        service.saveOrder = saveOrder;
        service.fetchOrders = fetchOrders;
        service.deleteOrder = deleteOrder;
        return service;
        
        function saveOrder(order) {
        	console.log(order);
        	return $http.post('/orderItems',order);
        }
        function deleteOrder(order){
        	return $http.post('/deleteItems',deleteItem);
        }
        function fetchOrders(username){
        	return $http.get('/fetchOrdersByUserName/'+username);
        }
       
    }
})();