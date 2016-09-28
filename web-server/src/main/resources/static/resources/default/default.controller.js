angular.module('app')
	.controller('ModalDemoCtrl', [ '$uibModal', '$log','$scope', function ($uibModal, $log,$scope) {
		var $ctrl = this;
		$ctrl.items = ['item1', 'item2', 'item3'];
		$ctrl.baggedItems = [];
		$ctrl.animationsEnabled = true;

		$ctrl.openBaggedCart = function (baggedItems) {
			$ctrl.baggedItems = baggedItems;
			console.log("open"+$ctrl.baggedItems);
			var modalInstance = $uibModal.open({
				animation: $ctrl.animationsEnabled,
				ariaLabelledBy: 'modal-title',
				ariaDescribedBy: 'modal-body',
				templateUrl: 'resources/default/modalContent.html',
				controller: 'ModalInstanceCtrl',
				controllerAs: '$ctrl',
				resolve: {
					items: function () {
						return $ctrl.items;
					},
					baggedItems : function() {
						return $ctrl.baggedItems;
					}
				}
			});

			modalInstance.result.then(function (selectedItem) {
				$ctrl.selected = selectedItem;
				console.log($ctrl.selected);
			}, function () {
				$log.info('Modal dismissed at: ' + new Date());
			});
		};

		$ctrl.openComponentModal = function () {
			var modalInstance = $uibModal.open({
				animation: $ctrl.animationsEnabled,
				component: 'modalComponent',
				resolve: {
					items: function () {
						return $ctrl.items;
					}
				}
			});

			modalInstance.result.then(function (selectedItem) {
				$ctrl.selected = selectedItem;
			}, function () {
				$log.info('modal-component dismissed at: ' + new Date());
			});
		};

		$ctrl.toggleAnimation = function () {
			$ctrl.animationsEnabled = !$ctrl.animationsEnabled;
		};
	}]);

	// Please note that $uibModalInstance represents a modal window (instance) dependency.
	// It is not the same as the $uibModal service used above.

	angular.module('app').controller('ModalInstanceCtrl', function ($uibModalInstance, items,baggedItems) {
		var $ctrl = this;
		$ctrl.items = items;
		$ctrl.baggedItems = baggedItems;
		$ctrl.selected = {
			item: $ctrl.items[0]
		};

		$ctrl.ok = function () {
			$uibModalInstance.close($ctrl.selected.item);
		};

		$ctrl.cancel = function () {
			$uibModalInstance.dismiss('cancel');
		};
	});

	// Please note that the close and dismiss bindings are from $uibModalInstance.

	angular.module('app').component('modalComponent', {
		templateUrl: 'resources/default/modalContent.html',
		bindings: {
			resolve: '<',
			close: '&',
			dismiss: '&'
		},
		controller: function () {
			var $ctrl = this;
			$ctrl.$onInit = function () {
				$ctrl.items = $ctrl.resolve.items;
				$ctrl.selected = {
						item: $ctrl.items[0]
				};
			};
			$ctrl.ok = function () {
				$ctrl.close({$value: $ctrl.selected.item});
			};
			$ctrl.cancel = function () {
				$ctrl.dismiss({$value: 'cancel'});
			};
		}
	});