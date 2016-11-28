(function () {
	'use strict';
	
    angular.module('app').factory('UserService', UserService);
    UserService.$inject = ['$http'];
    
    function UserService($http) {
    	var service = {};
        service.getAllAdmins = getAllAdmins;
        service.getSystemName = getSystemName;
        service.getByMobileNo = getByMobileNo;
        service.getByEmailId = getByEmailId;
        service.getByUsername = getByUsername;
        service.getDetailByUsername = getDetailByUsername;
        service.saveCustomer = saveCustomer;
        return service;
        
        function getByMobileNo(mobileNo) {
        	return $http.get('/api/user/loggedIn/mobile/' + mobileNo);
        }
        
        function getByEmailId(emailId) {
        	return $http.get('/api/user/loggedIn/email/' + emailId);
        }
        
        function getByUsername(username) {
        	return $http.get('/api/user/loggedIn/' + username);
        }
        
	    function getAllAdmins() {
	    	return $http.get('/api/user/system/privilage');
	    }
	    
	    function getSystemName() {
	    	return $http.get('/api/user/system/admins');
	    }
	    
	    function getDetailByUsername(username) {
	    	return $http.get('/api/user/customer/' + username)
	    }
	    
	    function saveCustomer(user) {
	    	return $http.post('/api/user/customer', user);
	    }
    }
})();
