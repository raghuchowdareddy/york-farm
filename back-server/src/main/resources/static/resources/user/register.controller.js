(function () {
    'use strict';

    angular.module('app').controller('RegisterController', RegisterController);
    RegisterController.$inject = [ '$location' ];
    
    function RegisterController($location) {
        var registerCtrl = this;
        registerCtrl.submit = submit;
        (function initController() {
            
        })();

        function submit() {
        	
        };
    }
})();
