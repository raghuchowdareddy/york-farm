(function () {
	'use strict';
    angular.module('app').factory('UserService', UserService);
    UserService.$inject = ['$http'];
    
    function UserService($http) {
    	var service = {};
        service.getAllAdmins = getAllAdmins;
        service.getSystemName = getSystemName;
        service.getByUsername = getByUsername;
        return service;
        
        function getByUsername(username) {
        	return $http.get('/api/user/loggedIn/' + username);
        }
        
	    function getAllAdmins() {
	    	return $http.get('/api/user/system/privilage');
	    }
	    
	    function getSystemName() {
	    	return $http.get('/api/user/system/admins');
	    }
    }
})();
