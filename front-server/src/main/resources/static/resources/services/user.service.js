(function () {
	'use strict';
	
    angular.module('app').factory('UserService', UserService);
    UserService.$inject = ['$http'];
    
    function UserService($http) {
    	var service = {};
        service.getByUsername = getByUsername;
        service.getDetailByUsername = getDetailByUsername;
        service.saveUser = saveUser;
        return service;
        
        function getByUsername(username) {
        	return $http.get('/api/userservice/user/loggedIn/' + username);
        }
	    
	    function getDetailByUsername(username) {
	    	return $http.get('/api/userservice/user/' + username)
	    }
	    
	    function saveUser(user) {
	    	return $http.post('/api/userservice/user', user);
	    }
    }
})();
