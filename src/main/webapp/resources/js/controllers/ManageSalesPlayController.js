tracker.controller("ManageSalesPlayController", function($scope, $http,$state) {
    $scope.data = {
            AllActive: [],
            Team: [{ suid: '1', firstName: 'Saket', lastName: 'Ati' }, { suid: '3', firstName: 'Murali', lastName: 'Veluru' }, { suid: '4', firstName: 'Kishore', lastName: 'Mattapalli' }]
        }
	$scope.goToSalesPlay = function(){
		$state.transitionTo("newSalesPlay");
	}	 
	$scope.goToDisabledSalesPlay = function(){
		$state.transitionTo("disabledsalesplay");
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
	        //console.log("Get active spids: "+ url);
	        $http.get(url).then(function (result) {
	            $scope.data.AllActive = [];
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
	        		    $scope.data.AllActive.push(spid);
	        		}
	        		else if (spid.status == "L") {
	        		    spid.color = "circle-blue";
	        		    $scope.numSent += 1;
	        		    $scope.data.AllActive.push(spid);
	        		}
	        		else if (spid.status == "A") {
	        		    spid.color = "circle-yellow";
	        		    $scope.numWip += 1;
	        		    $scope.data.AllActive.push(spid);
	        		}
	        	});
	        });	
    	}
    	$scope.shareWith = "";
    	$scope.getSpids();
    	$scope.share = function () {
    	    var e = document.getElementById("select-user");
    	    var shareWith = e.options[e.selectedIndex].value;
    	    var url = "http://scityws.azurewebsites.net/Service/ShareSpid/?";
    	    var params = "spid=" + $scope.shareSpid + "&uid=" + $scope.shareSuid + "&sharewith=" + shareWith;
    	    url = url + encodeURI(params);
    	    console.log("Share spid: "+ url);
    	    $http.get(url).then(function (result) {
    	        console.log("SPID share result: " + result.data);
    	        //if (result.data != "Success") alert("Sharing spid " + spid + " failed!");
    	    });
    	}
    	$scope.disable = function () {
    	    var url = "http://scityws.azurewebsites.net/Service/SetSpidStatus/?";
    	    var params = "spid=" + $scope.disableSpid + "&status=" + "I";
    	    url = url + encodeURI(params);
    	    console.log("Disable spid: "+ url);
    	    $http.get(url).then(function (result) {
    	        if (result.data != "Success") {
    	            console.log("Disabling spid " + $scope.disableSpid + " failed!");
    	        }
    	        else {
    	            $scope.getSpids();
    	        }
    	    });
    	}
    	$scope.delete = function () {
    	    var url = "http://scityws.azurewebsites.net/Service/SetSpidStatus/?";
    	    var params = "spid=" + $scope.deleteSpid + "&status=" + "D";
    	    url = url + encodeURI(params);
    	    console.log("Delete spid: " + url);
    	    $http.get(url).then(function (result) {
    	        if (result.data != "Success") {
    	            alert("Deleting spid " + spid + " failed!");
    	        }
    	        else {
    	            $scope.getSpids();
    	        }
    	    });
    	}
    	$scope.actionplay = function(actionType, spid, suid){
    	    if (actionType === "clone"){
    	        var url = "http://scityws.azurewebsites.net/Service/CloneSpid/?";
    	        var params = "spid="+spid + "&uid="+suid;
    	        url = url + encodeURI(params);
    	        //console.log("Clone spid: "+ url);
    	        $http.get(url).then(function (result){
    	            console.log("SPID clone result: " + result.data);
    	            $scope.getSpids();		   	    		
    	            //if (result.data != "Clone Success 1") alert("Cloning spid " + spid + " failed!");
    	        });
    	    }
    	}
   		/*if (actionType === "disable"){
		  		var url = "http://scityws.azurewebsites.net/Service/SetSpidStatus/?";
	   		  		var params = "spid="+spid + "&status=" + "I";
	   		  		url = url + encodeURI(params);
		   		  	//console.log("Disable spid: "+ url);
		   	    	$http.get(url).then(function (result){
		   	    	    if (result.data != "Success") {
		   	    	        alert("Disabling spid " + spid + " failed!");
		   	    	    }
		   	    	    else {
		   	    	        $scope.getSpids();
		   	    	    }
		   	    	});
		  		}
   		if (actionType === "delete"){
	  		var url = "http://scityws.azurewebsites.net/Service/SetSpidStatus/?";
    	    	//var url = "http://localhost:8080/selloCityWeb/manageplay/clonespidservice?";
   		  		var params = "spid="+spid + "&status=" + "D";
   		  		url = url + encodeURI(params);
	   		  	//console.log("Disable spid: "+ url);
	   	    	$http.get(url).then(function (result){
	   	    	    if (result.data != "Success") {
	   	    	        alert("Deleting spid " + spid + " failed!");
	   	    	    }
	   	    	    else {
	   	    	        $scope.getSpids();
	   	    	    }
	   	    	});
	  		}*/
    	    	//alert(actionvalue);
        
   	   $scope.openShareModal = function (spid, name, suid) {
   	       $scope.shareWith = "";
   	       document.getElementById('select-user').selectedIndex = 0;
   	       $('#share-modal').openModal();
   	       $scope.shareSpid = spid;
   	       $scope.shareSpidName = name;
   	       $scope.shareSuid = suid;
   	   }
   	   $scope.closeShareModal = function () {
   	       $('#share-modal').closeModal();
   	   }

   	   $scope.openDisableModal = function (spid, name) {
   	       $('#disable-modal').openModal();
   	       $scope.disableSpid = spid;
   	       $scope.disableSpidName = name;
   	   }
   	   $scope.closeDisableModal = function () {
   	       $('#disable-modal').closeModal();
   	   }
   	   $scope.openDeleteModal = function (spid, name) {
   	       $('#delete-modal').openModal();
   	       $scope.deleteSpid = spid;
   	       $scope.deleteSpidName = name;
   	   }
   	   $scope.closeDeleteModal = function () {
   	       $('#delete-modal').closeModal();
   	   }
    	   
    	
    });