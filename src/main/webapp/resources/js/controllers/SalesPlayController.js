tracker.controller('SalesPlayController', ['$scope','$location','$window', '$state','SalesPlayService',
     function($scope,$location, $window, $state,SalesPlayService) {
	  $scope.salesPlay;
	   $scope.paintPoints;
		$scope.errors = [];
		   $scope.tabs = [{
	            title: 'One',
	            url: 'resources/partials/sales-play-tab3.html'
	        }, {
	            title: 'Two',
	            url: 'two.tpl.html'
	        }, {
	            title: 'Three',
	            url: 'three.tpl.html'
	    }];


	    $scope.currentTab = 'resources/partials/sales-play-tab3.html';

	    $scope.onClickTab = function (tab) {
	        $scope.currentTab = tab.url;
	    }
	    
	    $scope.isActiveTab = function(tabUrl) {
	        return tabUrl == $scope.currentTab;
	    }	
	    $scope.addSalesPlay = function(customerInfo){
	    	if(!customerInfo.salesPlayName){
	    		alert("The name of Sales Play required");
	    		return;
	    	}
	    	if(!customerInfo.clientName){
	    		alert("Client Name required");
	    		return;
	    	}	    	
	    	if(!customerInfo.salesPlayName){
	    		alert("Client Contact required.");
	    		return;
	    	}
	    	if(!customerInfo.customerClientContact){
	    		alert("Client Name required");
	    		return;
	    	}	    	
	    	if(!customerInfo.customerClientEmail){
	    		alert("Enter valid email address");
	    		return;
	    	}
    	
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