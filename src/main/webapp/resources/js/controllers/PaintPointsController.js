tracker.controller('PaintPointsController', ['$scope','$location','$window', '$state','SalesPlayService','salesPlayId','loadedData',
     function($scope,$location, $window, $state,SalesPlayService,salesPlayId,loadedData) {
		$scope.errors = [];
		$scope.customerInfo = loadedData.data;
	    $scope.addPaintPoints = function(paintPoints){
	    	if( !paintPoints.painPoint1 && !paintPoints.painPoint2 && !paintPoints.painPoint3 && !paintPoints.painPoint4){
	    		alert("Enter atleast one pain point");
	    		return
	    	} 
			$scope.savingIndicator = true;
			SalesPlayService.addPaintPoints(paintPoints,salesPlayId).then(
					function(response) {
						$scope.savingIndicator = false;
						$scope.errors = response.errors;
						if ($scope.errors.length == 0) {
							$scope.salesPlay = response.data;
							SalesPlayService.setSalesPlayData($scope.salesPlay);
							$state.transitionTo("productinfo",{playId:salesPlayId});
						}
					});
			};
			$scope.previousAction = function(){
				$state.transitionTo("editsalesplay",{playId:salesPlayId});
			};


		}
   	]);