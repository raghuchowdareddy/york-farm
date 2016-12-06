(function () {
    'use strict';

    angular.module('app').controller('RegisterController', RegisterController);
    RegisterController.$inject = [ '$location', 'UserService' ];
    
    function RegisterController($location, UserService) {
        var registerCtrl = this;
        registerCtrl.submit = submit;
        (function initController() {
            
        })();

        function submit() {
        	registerCtrl.dataLoading = true;
        	UserService.saveUser(registerCtrl.user).then(function (response) {
            	if (response) {
            		FlashService.success('Registration successful', true);
            		$location.path('/login');
            	} else {
            		FlashService.error(response.message);
            		registerCtrl.dataLoading = false;
            	}
            });
        };
    }
})();
