tracker.factory("IncidentSearchService", function($http,$filter,$q,$timeout){
	var service = {
		getResource : function() {
			return 'searchIncident';
		},
		
		getHttp : function() {
			return $http;
		},
		
		getBaseUrl : function() {
			return baseUrl;
		},
	    getDirectorNames : function() {
    		var url = baseUrl + 'director/?_=' + Math.random();
				return $http.get(url).then(this.successHandler, this.errorHandler);
	    },			
	  searchIncident : function(id) {
    		var url = baseUrl + 'incidentsearch/?_=' + Math.random();
				return $http.get(url).then(this.successHandler, this.errorHandler);
	    },	
//		//fake call to the server, normally this service would serialize table state to send it to the server (with query parameters for example) and parse the response
//		//in our case, it actually performs the logic which would happened in the server
//		getPage : function getPage(incidentData){
//			var deferred = $q.defer();
//
//			var filtered = params.search.predicateObject ? $filter('filter')(this.searchIncident(), params.search.predicateObject) : this.searchIncident();
//
//			if (params.sort.predicate) {
//				filtered = $filter('orderBy')(filtered, params.sort.predicate, params.sort.reverse);
//			}
//
//			var result = filtered.slice(start, start + number);
//
//			$timeout(function () {
//				//note, the server passes the information about the data set size
//				deferred.resolve({
//					data: result,
//					numberOfPages: Math.ceil(1000 / number)
//				});
//			}, 1500);
//
//
//			return deferred.promise;
//		},
		loadStatus : function(){
			var status = new Array("Updated","Resolved","Finalized");
		    return status;
		    
		},
	};
	return angular.extend(service, BaseService);
});