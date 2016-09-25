tracker.controller('ProductInfoController', ['$scope','$location','$window', '$state','SalesPlayService','loadedData',
     function($scope,$location, $window, $state,SalesPlayService,loadedData) {

	  	$scope.paintPoints;
		$scope.returnMessage="";
		$scope.errors = [];
		$scope.salesPlay = loadedData.data;

		$scope.paintPoints = $scope.salesPlay.scSalesplayMappings;
	
		$scope.customerInfo = $scope.salesPlay.scSalesplayMappings;
	
	    $scope.addProductInfo = function(customerData,mappingId){

	    	$scope.savingIndicator = true;
			SalesPlayService.addProductData(customerData,mappingId).then(
					function(response) {
						$scope.savingIndicator = false;
						$scope.errors = response.errors;
						if ($scope.errors.length == 0) {
							$scope.returnMessage="Succssfully added Product";
						}						
					});
			};
			$scope.previousAction = function(){
				$state.transitionTo("addsalesplay",{playId:$scope.salesPlay.spid});
			};
			$scope.nextAction = function(){
				$state.transitionTo("productdatadetails",{playId:$scope.salesPlay.spid});
			};
		}

   	]);