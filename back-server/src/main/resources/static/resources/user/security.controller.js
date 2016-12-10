(function () {
    'use strict';

    angular.module('app').controller('SecurityController', SecurityController);
    SecurityController.$inject = [ '$location', 'AuthenticationService', 'FlashService' ];
    
    function SecurityController($location, AuthenticationService, FlashService) {
        var securityCtrl = this;
        securityCtrl.authenticate = authenticate;
        (function initController() {
        	AuthenticationService.clearCredentials();
        })();

        function authenticate() {
        	securityCtrl.dataLoading = true;
        	AuthenticationService.login(securityCtrl.username, securityCtrl.password, function (response) {
        		if (response.success) {
                    AuthenticationService.setCredentials(securityCtrl.username, securityCtrl.password);
                    $location.path('/');
                } else {
                    FlashService.Error(response.message);
                    securityCtrl.dataLoading = false;
                }
        	})
        };
    }
})();
