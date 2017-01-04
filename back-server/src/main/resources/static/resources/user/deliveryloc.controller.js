(function () {
    'use strict';

    angular.module('app')
    	.controller('DeliveryLocationController', DeliveryLocationController);
    
    DeliveryLocationController.$inject = [ '$log', '$scope', '$location', 'InventoryService' ];
    function DeliveryLocationController($log, $scope, $location, InventoryService) {
        var deliveryLocationCtrl = this;
        deliveryLocationCtrl.countries = [];
        deliveryLocationCtrl.states = [];
        deliveryLocationCtrl.cities = [];
        deliveryLocationCtrl.locations = [];
        
        (function initController() {
        	
        })();
    }
})();
