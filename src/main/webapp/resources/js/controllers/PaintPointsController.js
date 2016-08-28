tracker.controller('PaintPointsController', ['$scope','$location','$window', '$state','SalesPlayService',
     function($scope,$location, $window, $state,SalesPlayService) {

		$scope.errors = [];
		
		$scope.salesPlay =SalesPlayService.getSalesPlayData();
	    $scope.addPaintPoints = function(customerInfo){
	    	console.log("AAAAsdsad");
			$scope.savingIndicator = true;
			SalesPlayService.addPaintPoints(customerInfo,$scope.salesPlay.spId).then(
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