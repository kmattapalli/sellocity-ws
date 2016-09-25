tracker.controller('SalesPlayEditController', ['$scope','$location','$window', '$state','SalesPlayService','loadedData',
     function($scope,$location, $window, $state,SalesPlayService,loadedData) {
		$scope.customerInfo=loadedData.data;

	    $scope.addSalesPlay = function(customerInfo){

			var clientLogo = $scope.clientLogo;
			$scope.savingIndicator = true;
			SalesPlayService.addSalesPlay(customerInfo,clientLogo).then(
					function(response) {
						$scope.savingIndicator = false;
						$scope.errors = response.errors;
						if ($scope.errors.length == 0) {
							$scope.salesPlay = response.data;
							SalesPlayService.setSalesPlayData($scope.salesPlay);
							SalesPlayService.setSalesPlayName(customerInfo.salesPlayName);
							$state.transitionTo("addsalesplay",{playId:$scope.salesPlay.spid});
						}
					});
			};
		
		}
   	]);