tracker.controller('PaintPointsController', ['$scope','$location','$window', '$state','SalesPlayService','salesPlayId',
     function($scope,$location, $window, $state,SalesPlayService,salesPlayId) {
		$scope.errors = [];
	    $scope.addPaintPoints = function(customerInfo){

			$scope.savingIndicator = true;
			SalesPlayService.addPaintPoints(customerInfo,salesPlayId).then(
					function(response) {
						$scope.savingIndicator = false;
						$scope.errors = response.errors;
						if ($scope.errors.length == 0) {
							$scope.salesPlay = response.data;
							SalesPlayService.setSalesPlayData($scope.salesPlay);
							$state.transitionTo("productinfo");
						}
					});
			};
			$scope.previousAction = function(){
				$state.transitionTo("home");
			};
		
		}
   	]);