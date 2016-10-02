tracker.controller("DisabledSalesPlayController", function($scope, $http,$state) {
    //alert("I am in controller");
    $scope.data = {
        AllDisabled: [],
    }
    $scope.suid = "2";

    $scope.getSpids = function () {
        var url = "http://scityws.azurewebsites.net/Service/GetSpidsBySP/";
        var params = "?id=" + $scope.suid;
        url = url + encodeURI(params);
        //console.log("Get active spids: "+ url);
        $http.get(url).then(function (result) {
            $scope.data.AllDisabled = [];
            $scope.numRead = 0;
            $scope.numSent = 0;
            $scope.numWip = 0;
            angular.forEach(result.data, function (value, key) {
                var spid = { spid: '', name: '', status: '', color: '' };
                spid.spid = value.SPID;
                spid.name = value.NAME;
                spid.status = value.CSTATUS;
                if (spid.status == "V") {
                    $scope.numRead += 1;
                }
                else if (spid.status == "L") {
                    $scope.numSent += 1;
                }
                else if (spid.status == "A") {
                    $scope.numWip += 1;
                }
                else if (spid.status == "I") {
                    $scope.data.AllDisabled.push(spid);
                }
            });
        });
    }
    $scope.getSpids();
    $scope.edit = function () {
        var url = "http://scityws.azurewebsites.net/Service/SetSpidStatus/?";
        var params = "spid=" + $scope.enableSpid + "&status=" + "A";
        url = url + encodeURI(params);
        console.log("Enable spid: " + url);
        $http.get(url).then(function (result) {
            if (result.data != "Success") {
                alert("Enabling spid " + $scope.enableSpid + " failed!");
            }
            else {
                $scope.getSpids();
            }
        });
    }

    $scope.openEditModal = function (spid, name) {
        $('#edit-modal').openModal();
        $scope.enableSpid = spid;
        $scope.enableSpidName = name;
    }
    $scope.closeEditModal = function () {
        $('#edit-modal').closeModal();
    }
});
