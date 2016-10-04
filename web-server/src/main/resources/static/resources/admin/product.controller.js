(function() {
	'use strict';
	angular.module('app')
		.controller('ProductController', ProductController)
		.component('productModalComponent', { templateUrl: 'resources/admin/product.modal.html' })
		.controller('ProductModalInstanceController', ProductModalInstanceController);
	
	ProductController.$inject = [ '$uibModal', '$log', '$scope', 'ProductService', 'CategoryService' ];
	function ProductController($uibModal, $log, $scope, ProductService, CategoryService) {
		var productCtrl = this;
		productCtrl.categories = [];
		productCtrl.products = [];
		initController();
		productCtrl.add = add;
		productCtrl.loadAllCategories = loadAllCategories;
		
		function initController() {
			ProductService.getAll().then(function(response) {
				productCtrl.products = response.data;
			});
		}
		
		function loadAllCategories() {
			CategoryService.getAll().then(function(response) {
				productCtrl.categories = response.data;
			});
		}
		
		function add() {
			$uibModal.open({
				animation: productCtrl.animationsEnabled,
				templateUrl: 'resources/admin/product.modal.html',
				controller: 'ProductModalInstanceController',
				controllerAs: 'productCtrl'
			});
		}
	}
	
	ProductModalInstanceController.$inject = [ '$uibModalInstance' ];
	function ProductModalInstanceController($uibModalInstance) {
		var productCtrl = this;
		productCtrl.save = function () {
			
		};
	}
})();