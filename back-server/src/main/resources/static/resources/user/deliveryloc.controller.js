(function () {
    'use strict';

    angular.module('app')
    	.controller('DeliveryLocationController', DeliveryLocationController)
    	.component('deliveryLocationModalComponent', { templateUrl: 'resources/user/deliveryloc.modal.html' })
    	.controller('DeliveryLocationModalInstanceController', DeliveryLocationModalInstanceController);
    
    DeliveryLocationController.$inject = [ '$uibModal', '$log', '$scope', '$location', 'RegionService' ];
    function DeliveryLocationController($uibModal, $log, $scope, $location, RegionService) {
        var deliveryLocationCtrl = this;
        deliveryLocationCtrl.countries = [];
        deliveryLocationCtrl.states = [];
        deliveryLocationCtrl.cities = [];
        deliveryLocationCtrl.locations = [];
        deliveryLocationCtrl.add = add;
        
        (function init() {
        	RegionService.getDeliveryLocations().then(function(response) {
        		deliveryLocationCtrl.locations = response.data;
        	});
        })();
        
        function add() {
			$uibModal.open({
				animation: deliveryLocationCtrl.animationsEnabled,
				templateUrl: 'resources/user/deliveryloc.modal.html',
				controller: 'DeliveryLocationModalInstanceController',
				controllerAs: 'deliveryLocationModalInstanceCtrl'
			});
		}
    }
    
    DeliveryLocationModalInstanceController.$inject = [ '$uibModalInstance', 'RegionService' ];
	function DeliveryLocationModalInstanceController($uibModalInstance, RegionService) {
		var deliveryLocationModalInstanceCtrl = this;
		deliveryLocationModalInstanceCtrl.locations = [];
		deliveryLocationModalInstanceCtrl.save = save;
		
		(function initController() {
			RegionService.getLocationsByCity().then(function(response) {
				deliveryLocationModalInstanceCtrl.locations = response.data;
        	});
        })();
		
		function save() {
			RegionService.saveDeliveryLocation(this.deliveryLocationSubmitted);
		}
	}
})();
