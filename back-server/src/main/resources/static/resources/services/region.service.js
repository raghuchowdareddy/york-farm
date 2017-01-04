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
        return service;
        
        function getCountries() {
        	
        }
        
        function getStatesByCountry() {
        	
        }
        
        function getCitiesByState() {
        	
        }
        
        function getLocationsByCity() {
        	
        }
    }
})();
