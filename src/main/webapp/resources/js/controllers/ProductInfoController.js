tracker.controller('ProductInfoController', ['$scope','$location','$window', '$state','SalesPlayService','loadedData',
     function($scope,$location, $window, $state,SalesPlayService,loadedData) {

	  	$scope.paintPoints;
		$scope.returnMessage=[];
		$scope.errors = [];
		$scope.salesPlay = loadedData.data;

		$scope.paintPoints = $scope.salesPlay.scSalesplayMappings;
	
		$scope.customerInfo = $scope.salesPlay.scSalesplayMappings;
	
	    $scope.addProductInfo = function(customerData,mappingId,index){

	    	$scope.savingIndicator = true;
			SalesPlayService.addProductData(customerData,mappingId).then(
					function(response) {
						$scope.savingIndicator = false;
						$scope.errors = response.errors;
						if ($scope.errors.length == 0) {
							$scope.returnMessage[index]="Successfully added Product";
						}						
					});
			};
			$scope.previousAction = function(){
				$state.transitionTo("addsalesplay",{playId:$scope.salesPlay.spid});
			};
			$scope.nextAction = function(){
				for(i=0;i<$scope.paintPoints.length;i++){
					if($scope.customerInfo[i].productInfo == ""){
						alert("Plese enter the Product for the  "+$scope.customerInfo[i].painPoint);
						return;
					}
				}
				$state.transitionTo("productdatadetails",{playId:$scope.salesPlay.spid});
			};
		}

   	]);