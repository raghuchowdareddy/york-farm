(function () {
    'use strict';

    angular.module('app').controller('SecurityController', SecurityController);
    SecurityController.$inject = [ '$location' ];
    
    function SecurityController($location) {
        var securityCtrl = this;
        securityCtrl.authenticate = authenticate;
        (function initController() {
            
        })();

        function authenticate() {
        	
        };
    }
})();
