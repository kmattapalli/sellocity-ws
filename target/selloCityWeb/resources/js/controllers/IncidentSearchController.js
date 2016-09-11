tracker.controller('IncidentSearchController', ['$scope','$location','$state','IncidentSearchService','$timeout','$window',
     function($scope,$location, $state,IncidentSearchService,$timeout,$window) {
		$scope.errors = [];

		$scope.rowCollection= [];
		if(!$state.current.searchParams) {
			$scope.searchParams = {"incidentNo":"","director":"","toolStatus":"", "sortKey":"incidentNo", "sortDir":"asc", "currentPage": 1};
		}else{
			$scope.searchParams = $state.current.searchParams;
		}
  		$scope.searchResponse = {};
  		$scope.statusTypes=IncidentSearchService.loadStatus();
  		$scope.edit = function(incident) {
  			$state.transitionTo("incident", {id:incident.id});
  		};
		$scope.formatIncidentNo = function(incident) {
			if(incident) {
	  			return incident.incidentNo;	
			}else{
				return $scope.searchParams.incidentNo;
			}
		};  
		$scope.cancel = function(){
			$state.transitionTo("home");
		}		
		$scope.changeIncidentNo = function(selectedItem){
			
			$scope.searchParams.incidentNo  = selectedItem.incidentNo;
		};  		
  		IncidentSearchService.getDirectorNames().then(function(response){
  			$scope.directors=response.data;
  		});
		$scope.exportToPDF = function(){
			window.opem(baseUrl+"/myreport.pdf");
		};  
	
}]);