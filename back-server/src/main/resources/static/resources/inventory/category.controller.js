(function () {
    'use strict';

    angular.module('app')
    	.controller('CategoryController', CategoryController)
    	.component('categoryModalComponent', { templateUrl: 'resources/inventory/category.modal.html' })
    	.controller('CategoryModalInstanceController', CategoryModalInstanceController);
    
    CategoryController.$inject = [ '$uibModal', '$log', '$scope', '$location', 'InventoryService' ];
    function CategoryController($uibModal, $log, $scope, $location, InventoryService) {
        var categoryCtrl = this;
        categoryCtrl.categories = [];
        categoryCtrl.add = add;
        
        (function initController() {
        	InventoryService.getAllCategories().then(function(response) {
        		categoryCtrl.categories = response.data;
        	});
        })();
        
        function add() {
			$uibModal.open({
				animation: categoryCtrl.animationsEnabled,
				templateUrl: 'resources/inventory/category.modal.html',
				controller: 'CategoryModalInstanceController',
				controllerAs: 'categoryCtrlModalInstanceCtrl'
			});
		}
    }
    
    CategoryModalInstanceController.$inject = [ '$uibModalInstance', '$scope', 'InventoryService' ];
	function CategoryModalInstanceController($uibModalInstance, $scope, InventoryService) {
		var categoryCtrlModalInstanceCtrl = this;
		categoryCtrlModalInstanceCtrl.save = save;
		
		function save() {
			InventoryService.saveCategory(this.categorySubmitted);		
			$uibModalInstance.close();
		}
	}
})();
