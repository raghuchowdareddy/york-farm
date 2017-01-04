(function () {
    'use strict';

    angular.module('app')
    	.controller('ProductController', ProductController)
    	.component('productModalComponent', { templateUrl: 'resources/inventory/product.modal.html' })
    	.controller('ProductModalInstanceController', ProductModalInstanceController);
    
    ProductController.$inject = [ '$uibModal', '$log', '$scope', '$location', 'InventoryService' ];
    function ProductController($uibModal, $log, $scope, $location, InventoryService) {
        var productCtrl = this;
        productCtrl.products = [];
        productCtrl.add = add;
        
        (function initController() {
        	InventoryService.getAllProducts().then(function(response) {
        		productCtrl.products = response.data;
        	});
        })();
        
        function add() {
			$uibModal.open({
				animation: productCtrl.animationsEnabled,
				templateUrl: 'resources/inventory/product.modal.html',
				controller: 'ProductModalInstanceController',
				controllerAs: 'productModalInstanceCtrl'
			});
		}
    }
    
    ProductModalInstanceController.$inject = [ '$uibModalInstance', 'InventoryService' ];
	function ProductModalInstanceController($uibModalInstance, InventoryService) {
		var productModalInstanceCtrl = this;
		productModalInstanceCtrl.categories = [];
		productModalInstanceCtrl.save = save;
		
		(function initController() {
        	InventoryService.getAllCategories().then(function(response) {
        		productModalInstanceCtrl.categories = response.data;
        	});
        })();
		
		function save() {
			InventoryService.saveProduct(productModalInstanceCtrl);
		}
	}
})();
