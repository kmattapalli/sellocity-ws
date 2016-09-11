tracker.controller('ProductDetailsController', ['$scope','$location','$window', '$state','SalesPlayService','loadedData',
     function($scope,$location, $window, $state,SalesPlayService,loadedData) {
	  	//$scope.customerInfo={};
	  //	$scope.customerProduct={};
		$scope.customerInfoWrapper={};
	  	$scope.paintPoints;
		$scope.errors = [];
		
		$scope.salesPlay =loadedData.data;
	
		var temp = $scope.salesPlay.salesPlayMapping[0];
	    $scope.createProductValues = function(customerData,mappingId){
//	    	var test = $scope.customerProduct[0].productInfo;
//	    	var aa =  $scope.customerInfo[0];
	    	$scope.savingIndicator = true;
			SalesPlayService.addProductDetails(customerData,mappingId).then(
					function(response) {
						$scope.savingIndicator = false;
						$scope.errors = response.errors;
						if ($scope.errors.length == 0) {
							$scope.paintPoints = response.data;
							
							//$state.transitionTo("productdetails");
						}
					});
			};
			$scope.previousAction = function(){
				$state.transitionTo("addsalesplay");
			};
		}
   	]);