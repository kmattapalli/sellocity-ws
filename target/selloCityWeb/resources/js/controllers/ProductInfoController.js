tracker.controller('ProductInfoController', ['$scope','$location','$window', '$state','SalesPlayService',
     function($scope,$location, $window, $state,SalesPlayService) {
	  	//$scope.customerInfo={};
	  //	$scope.customerProduct={};
		$scope.customerInfoWrapper={};
	  	$scope.paintPoints;
		$scope.errors = [];
		
		$scope.salesPlay =SalesPlayService.getSalesPlayData();
		console.log("sales Map"+$scope.salesPlay.salesPlayMapping);
		$scope.paintPoints = $scope.salesPlay.salesPlayMapping;
		$scope.customerInfo = new Array($scope.paintPoints.length);
		$scope.nextPage = function(){
			$state.transitionTo("productdetails");
		};
	    $scope.addProductInfo = function(customerData,mappingId){
//	    	var test = $scope.customerProduct[0].productInfo;
//	    	var aa =  $scope.customerInfo[0];
	    	$scope.savingIndicator = true;
			SalesPlayService.addProductData(customerData,mappingId).then(
					function(response) {
						$scope.savingIndicator = false;
						$scope.errors = response.errors;
						if ($scope.errors.length == 0) {
							$scope.paintPoints = response.data;
							
							$state.transitionTo("productdetails");
						}
					});
			};
			$scope.previousAction = function(){
				$state.transitionTo("addsalesplay");
			};
		}

   	]);