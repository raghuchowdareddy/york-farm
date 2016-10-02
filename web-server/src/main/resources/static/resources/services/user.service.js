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
        return service;
        
        function getByMobileNo(mobileNo) {
        	return $http.get('/api/user/loggedIn/mobile/' + mobileNo);
        }
        
        function getByEmailId(emailId) {
        	return $http.get('/api/user/loggedIn/email/' + emailId);
        }
        
	    function getAllAdmins() {
	    	return $http.get('/api/user/system/privilage');
	    }
	    
	    function getSystemName() {
	    	return $http.get('/api/user/system/admins');
	    }
    }
})();
