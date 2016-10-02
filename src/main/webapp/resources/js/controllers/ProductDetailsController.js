tracker.controller('ProductDetailsController', ['$scope','$location','$window', '$state','SalesPlayService','loadedData',
     function($scope,$location, $window, $state,SalesPlayService,loadedData) {
	  	//$scope.customerInfo={};
	  //	$scope.customerProduct={};
	
		$scope.returnMessage=[];
		$scope.customerInfoWrapper={};
	  	$scope.paintPoints;
		$scope.errors = [];
		
		$scope.salesPlay =loadedData.data;
		
		$scope.paintPoints = $scope.salesPlay.scSalesplayMappings;
		
		$scope.customerInfo = new Array($scope.paintPoints.length);
	
		
	    $scope.createProductValues = function(customerData,mappingId,index){
//	    	var test = $scope.customerProduct[0].productInfo;
//	    	var aa =  $scope.customerInfo[0];
	    	$scope.savingIndicator = true;
			SalesPlayService.addProductDetails(customerData,mappingId).then(
					function(response) {
						$scope.savingIndicator = false;
						$scope.errors = response.errors;
						if ($scope.errors.length == 0) {
							$scope.returnMessage[index]="Successfully added Product Details";
	
					}
					});
			};
			$scope.previousAction = function(){
				$state.transitionTo("productinfo",{playId:$scope.salesPlay.spid});
			};
			$scope.nextAction = function(){
				$state.transitionTo("productbenefits",{playId:$scope.salesPlay.spid});
			};
		}
   	]);