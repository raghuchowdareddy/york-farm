(function () {
    'use strict';

    angular.module('app')
    	.controller('CatalogController', CatalogController)
    	.component('catalogModalComponent', { templateUrl: 'resources/inventory/catalog.modal.html' })
    	.controller('CatalogModalInstanceController', CatalogModalInstanceController);
    
    CatalogController.$inject = [ '$uibModal', '$log', '$scope', '$location', 'InventoryService' ];
    function CatalogController($uibModal, $log, $scope, $location, InventoryService) {
        var catalogCtrl = this;
        catalogCtrl.catalogs = [];
        catalogCtrl.add = add;
        
        (function initController() {
        	InventoryService.getAllCataloges().then(function(response) {
        		catalogCtrl.catalogs = response.data;
        	});
        })();
        
        function add() {
        	$uibModal.open({
				animation: catalogCtrl.animationsEnabled,
				templateUrl: 'resources/inventory/catalog.modal.html',
				controller: 'CatalogModalInstanceController',
				controllerAs: 'catalogModalInstanceCtrl'
			});
		}
    }
    
    CatalogModalInstanceController.$inject = [ '$uibModalInstance', 'InventoryService' ];
	function CatalogModalInstanceController($uibModalInstance, InventoryService) {
		var catalogModalInstanceCtrl = this;
		catalogModalInstanceCtrl.products = [];
		catalogModalInstanceCtrl.save = save;
		catalogModalInstanceCtrl.addProduct = addProduct;
		
		(function initController() {
			InventoryService.getAllProducts().then(function(response) {
				catalogModalInstanceCtrl.products = response.data;
        	});
        })();
		
		function save() {
			InventoryService.saveCatalog(this.catalogSubmitted);
		}
		
		function addProduct() {
			if(angular.isUndefined(this.catalogSubmitted)) {
				this.catalogSubmitted = [];
			}
			if(angular.isUndefined(this.catalogSubmitted.catalogProducts) || this.catalogSubmitted.catalogProducts.length == 0) {
				this.catalogSubmitted.catalogProducts = [];
			}
			var product = {'productId':'0', 'quantity': '', 'price':''};
			this.catalogSubmitted.catalogProducts.push(product);
		}
	}
})();