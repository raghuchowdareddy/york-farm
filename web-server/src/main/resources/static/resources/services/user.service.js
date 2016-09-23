(function () {
	'use strict';
    angular.module('app').factory('UserService', UserService);
    UserService.$inject = ['$http'];
    
    function UserService($http) {
    	console.log('UserService');
    	var service = {};
        service.loggedUserDetail = loggedUserDetail;
        return service;
        
	    function loggedUserDetail() {
	    	console.log('loggedUserDetail');
	    	return $http.get('/api/oauth2/user/loggedIn').then(handleSuccess, handleError('Error getting logged user detail'));
	    }
	    
	    function handleSuccess(res) {
	    	res.data;
	    }
	    
	    function handleError(error) {
	    	
	    }
    }
})();
