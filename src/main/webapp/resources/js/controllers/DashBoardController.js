tracker.controller("DashBoardController", function($scope, $http,$state) {
	      
	        $scope.data = {
	            AllSpids: [],
	        }

			$scope.getManageProfile = function(){
				$state.transitionTo("managesalesplay");
			}
			$scope.goToSalesPlay = function(){
				$state.transitionTo("newSalesPlay");
			}
			$scope.editSalesPlay=function(salesPlayId){
				$state.transitionTo("editsalesplay",{playId:salesPlayId});
			}
	    	$scope.suid = "2";
	    	$scope.getTeam = function () {
	    	    var url = "http://scityws.azurewebsites.net/Service/GetTeamUsers/";
	    	    var params = "?id="+ $scope.suid;
	    	    url = url + encodeURI(params);
	    	    //console.log("Get active spids: "+ url);
	    	    $http.get(url).then(function (result) {
	    	        angular.forEach(result.data, function (value, key) {
	    	            var teammate = { suid: '', name: '' };
	    	            teammate.suid = value.SUID;
	    	            teammate.firstName = value.FIRST_NAME;
	    	            teammate.lastName = value.LAST_NAME;
	    	            $scope.data.Team.push(teammate);
	    	        });
	    	    });
	    	}

	    	$scope.getSpids = function () {
		        var url = "http://scityws.azurewebsites.net/Service/GetSpidsBySP/";
		        var params = "?id="+ $scope.suid;
		        url = url + encodeURI(params);
		        console.log("Get active spids: "+ url);
		        $http.get(url).then(function (result) {
		            $scope.data.AllSpids = [];
		            $scope.numRead = 0;
		            $scope.numSent = 0;
		            $scope.numWip = 0;
		        	angular.forEach(result.data, function(value, key){
		        		var spid = {spid:'', name:'', status:'', color:''};
		        		spid.spid = value.SPID;
		        		spid.name = value.NAME;
		        		spid.status = value.CSTATUS;
		        		if (spid.status == "V") {
		        		    spid.color = "circle-green";
		        		    $scope.numRead += 1;
		        		    $scope.data.AllSpids.push(spid);
		        		}
		        		else if (spid.status == "L") {
		        		    spid.color = "circle-blue";
		        		    $scope.numSent += 1;
		        		    $scope.data.AllSpids.push(spid);
		        		}
		        		else if (spid.status == "A") {
		        		    spid.color = "circle-yellow";
		        		    $scope.numWip += 1;
		        		    $scope.data.AllSpids.push(spid);
		        		}
		        	});
		        });
	    	}
	    	$scope.shareWith = "";
	    	$scope.getSpids();

	   	   $scope.openSendModal = function (spid, name) {
	   	       $scope.shareWith = "";
	   	       //document.getElementById('select-user').selectedIndex = 0;
	   	       $('#send-modal').openModal();
	   	       $scope.sendSpid = spid;
	   	       $scope.sendSpidName = name;
	   	   }
	   	   $scope.closeSendModal = function () {
	   	       $('#send-modal').closeModal();
	   	   }
	    });