tracker.controller('IncidentController', ['$scope','$location','$window', '$state','IncidentService','loadedData','inputData','IncidentSearchService',
     function($scope,$location, $window, $state,IncidentService,loadedData,inputData,IncidentSearchService) {
		$scope.errors = [];
		$scope.incident = loadedData.data;
		$scope.statusNames = new Array("New", "Closed", "Open");
		$scope.statusTypes = IncidentSearchService.loadStatus();
		$scope.formatIncidentNo = function(incident) {
			if(incident) {
				$scope.incident = incident;
	  			return incident.incidentNo;	
			}
//			}else{
//				return $scope.incident.incidentNo;
//			}
		};  
		$scope.changeEntityId = function(entity){
			console.log(entity.incidentNo);
			$scope.incident= entity;
  		}; 		
		
		$scope.changeIncidentNo = function(selectedItem){
			$scope.incident.incidentNo = selectedItem.incidentNo;
		};
		$scope.cancel = function(){
			$state.transitionTo("incidentsearch");
		}
		$scope.updateIncident = function(incident){
			$scope.savingIndicator = true;
			IncidentService.updateIncident(incident).then(
					function(response) {
						$scope.savingIndicator = false;
						$scope.errors = response.errors;
						if ($scope.errors.length == 0) {
							$scope.incidentForm.$setPristine();
							$scope.incident = response.data;
							$state.transitionTo("incidentsearch");
						}
					});
			};
		
		}
   	]);