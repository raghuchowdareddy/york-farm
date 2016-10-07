(function() {
	'use strict';
	angular.module('app')
		.controller('ProductController', ProductController)
		.component('productModalComponent', { templateUrl: 'resources/admin/product.modal.html' })
		.controller('ProductModalInstanceController', ProductModalInstanceController);
	
	ProductController.$inject = [ '$uibModal', '$log', '$scope', 'ProductService' ];
	function ProductController($uibModal, $log, $scope, ProductService) {
		var productCtrl = this;
		productCtrl.products = [];
		initController();
		productCtrl.add = add;
		
		function initController() {
			ProductService.getAll().then(function(response) {
				productCtrl.products = response.data;
			});
		}
		
		function add() {
			$uibModal.open({
				animation: productCtrl.animationsEnabled,
				templateUrl: 'resources/admin/product.modal.html',
				controller: 'ProductModalInstanceController',
				controllerAs: 'productModalInstanceCtrl'
			});
		}
	}
	
	ProductModalInstanceController.$inject = [ '$uibModalInstance', 'ProductService', 'CategoryService' ];
	function ProductModalInstanceController($uibModalInstance, ProductService, CategoryService) {
		var productModalInstanceCtrl = this;
		productModalInstanceCtrl.categories = [];
		initController();
		productModalInstanceCtrl.save = save;
		
		function initController() {
			CategoryService.getAll().then(function(response) {
				productModalInstanceCtrl.categories = response.data;
			});
		}
		
		function save() {
			ProductService.save(productModalInstanceCtrl);
		}
	}
})();