(function () {
	'use strict';
	
    angular.module('app').factory('RegionService', RegionService);
    RegionService.$inject = ['$http'];
    
    function RegionService($http) {
    	var service = {};
        service.getCountries = getCountries;
        service.getStatesByCountry = getStatesByCountry;
        service.getCitiesByState = getCitiesByState;
        service.getLocationsByCity = getLocationsByCity;
        service.getDeliveryLocations = getDeliveryLocations;
        service.saveDeliveryLocation = saveDeliveryLocation;
        return service;
        
        function getCountries() {
        	
        }
        
        function getStatesByCountry() {
        	
        }
        
        function getCitiesByState() {
        	
        }
        
        function getLocationsByCity() {
        	return $http.get('/api/userservice/region/locations/Bangalore');
        }
        
        function getDeliveryLocations() {
        	return $http.get('/api/userservice/region/deliverylocations');
        }
        
        function saveDeliveryLocation(deliveryLocation) {
        	return $http.post('/api/userservice/region/deliverylocations', deliveryLocation);
        }
    }
})();
