tracker.factory("IncidentService", function($http,$filter){
	var service = {
		getResource : function() {
			return 'incident';
		},
		
		getHttp : function() {
			return $http;
		},
		
		getBaseUrl : function() {
			return baseUrl;
		},
	    loadIncident : function(id) {
    		var url = baseUrl + 'incident/'+ id + '/?_=' + Math.random();
				return $http.get(url).then(this.successHandler, this.errorHandler);
	    },
	    
	    searchIncident : function(id) {
    		var url = baseUrl + 'searchIncident/'+ id + '/?_=' + Math.random();
				return $http.get(url).then(this.successHandler, this.errorHandler);
	    },		
	    updateIncident : function(incidentData){
	    	var method = 'POST';
	    	var url = baseUrl + 'incident';
			if(incidentData.id){
				method = 'PUT';
				url += '/' + incidentData.id;
			}
	    	return $http({
				method: method,
				url: url,
				data: incidentData
			}).then(this.successHandler, this.errorHandler);
	    },	    
	};
	return angular.extend(service, BaseService);
});