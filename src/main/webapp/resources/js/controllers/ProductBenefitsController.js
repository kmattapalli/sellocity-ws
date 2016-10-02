tracker.controller('ProductBenefitsController', ['$scope','$location','$window', '$state','SalesPlayService','loadedData',
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
	
		
	    $scope.createBenefitDetails = function(customerData,mappingId,index){
//	    	var test = $scope.customerProduct[0].productInfo;
//	    	var aa =  $scope.customerInfo[0];
	    	$scope.savingIndicator = true;
			SalesPlayService.addBenefitDetails(customerData,mappingId).then(
					function(response) {
						$scope.savingIndicator = false;
						$scope.errors = response.errors;
						if ($scope.errors.length == 0) {
							$scope.returnMessage[index]="Succssfully added Benefits";
						}
					});
			};
			$scope.previousAction = function(){
				$state.transitionTo("productdatadetails",{playId:$scope.salesPlay.spid});
			};
			$scope.nextAction = function(){
				$state.transitionTo("productbenefits",{playId:$scope.salesPlay.spid});
			};
		}
   	]);